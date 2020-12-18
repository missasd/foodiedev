package com.imooc.controller;

import com.imooc.pojo.Orders;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@Controller
public class BaseController {



    // 购物车相关; 和前端cookie中的购物车字段一致
    public static final String FOODIE_SHOPCART = "shopcart";

    public static final Integer COMMON_PAGE_SIZE = 10;
    // 默认搜索商品显示20条
    public static final Integer PAGE_SIZE = 20;


    // 支付中心的调用地址
//    String paymentUrl = "http://payment.t.mukewang.com/foodie-payment/createMerchantOrder";
    String paymentUrl = "http://127.0.0.1:8089/createMerchantOrder";

    // 订单成功的支付回调地址
    // 微信支付成功 -> 支付中心 -> 天天吃货平台
    //                       |- 回调通知的url
    String payReturnUrl = "http://localhost:8082/orders/notifyMerchantOrderPaid";

    // 用户头像保存的位置
    // C:\Users\dell\Desktop\foodie-faces
    public static final String IMAGE_USER_FACE_LOCATION =  "C:"+ File.separator +"Users" + File.separator +
            "dell" + File.separator + "Desktop"+File.separator + "foodie-faces";




    /**
     * 验证用户和订单是否有关联关系, 避免非法用户调用
     * @param userId
     * @param orderId
     * @return
     */
    @Autowired
    public MyOrdersService myOrdersService;

    public JSONResult checkUserOrder(String userId, String orderId){
        Orders order = myOrdersService.queryMyOrder(userId, orderId);
        if (order == null) return JSONResult.errorMsg("订单不存在! ");

        return JSONResult.ok(order);
    }
}
