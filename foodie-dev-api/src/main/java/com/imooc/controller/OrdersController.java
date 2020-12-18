package com.imooc.controller;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayMethod;
import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.SubmitOrderBO;
import com.imooc.pojo.vo.MerchantOrdersVO;
import com.imooc.pojo.vo.OrderVO;
import com.imooc.service.OrderService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("orders")
@Api(value = "订单相关", tags = {"订单相关的api接口"})
public class OrdersController extends BaseController{

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public JSONResult create(

            @RequestBody SubmitOrderBO submitOrderBO,
            HttpServletRequest request,
            HttpServletResponse response) {


//        if (StringUtils.isBlank(userId)){
//            return JSONResult.errorMsg("用户id不能为空");
//        }
//        List<UserAddress> list = addressService.queryAll(userId);
        if (submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type
            && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type
        ){
            return JSONResult.errorMsg("支付方式不支持");
        }

        //System.out.println(submitOrderBO.toString());

        // 1. 创建订单
        OrderVO orderVO  = orderService.createOrder(submitOrderBO);
        String orderId = orderVO.getOrderId();

        // 2. 创建订单以后, 移除购物车中已结算(已提交)的商品
        /**
         *  1001
         *  2002 -> 用户购买
         *  3003 -> 用户购买
         *  4004
         *  用户购买之后 修改购物车数据 将数据写回cookie
         */
        // TODO 整合redis之后, 完善购物车中的已结算商品清除, 并且同步到前端的cookie
        //CookieUtils.setCookie(request, response, FOODIE_SHOPCART, "", true);
        // 3. 向支付中心发送当前订单, 用于保存支付中心的订单数据
        MerchantOrdersVO merchantOrdersVO = orderVO.getMerchantOrdersVO();
        merchantOrdersVO.setReutrnUrl(payReturnUrl);

        // 为了方便测试, 所以所有的支付金额都统一改为1分钱
        merchantOrdersVO.setAmount(1);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("imoocUserId", "imooc");
//        headers.add("password", "imooc");

        // 3.1 构建request携带header 以及 vo

//        HttpEntity<MerchantOrdersVO> entity =
//                new HttpEntity<>(merchantOrdersVO, headers);
//
//        ResponseEntity<JSONResult> responseEntity =
//                restTemplate.postForEntity(paymentUrl, entity, JSONResult.class);
//
//        JSONResult paymentResult = responseEntity.getBody();
//        if (paymentResult.getStatus() != 200){
//            return JSONResult.errorMsg("支付中心订单创建失败, 请联系管理员");
//        }

        return JSONResult.ok(orderId);
    }

    // merchantOrderId 对应于数据库订单表中的id
    // 支付成功的回调接口修改订单状态
    @ApiOperation(value = "支付成功的回调接口修改订单状态", notes = "支付成功的回调接口修改订单状态", httpMethod = "POST")
    @PostMapping("/notifyMerchantOrderPaid")
    public Integer notifyMerchantOrderPaid(String merchantOrderId){

        orderService.updateOrderStatus(merchantOrderId, OrderStatusEnum.WAIT_DELIVER.type);

        return HttpStatus.OK.value();
    }
}
