package com.imooc.controller.center;

import com.imooc.controller.BaseController;
import com.imooc.pojo.Orders;
import com.imooc.pojo.vo.OrderStatusCountsVO;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.JSONResult;
import com.imooc.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户中心我的订单", tags = {"用户中心我的订单"})
@RestController
@RequestMapping("myorders")
public class MyOrdersController extends BaseController {
    /**
     *
     * axios.post(
     * 	serverUrl + '/myorders/query?userId=' + userInfo.id + "&orderStatus=" + orderStatus +
     * 			"&page=" + page +
     * 			"&pageSize=" + pageSize, {}, {
     * 			headers: {
     * 			'headerUserId': userInfo.id,
     * 			'headerUserToken': userInfo.userUniqueToken
     *                                                                }* 							})
     */

    @Autowired
    private MyOrdersService myOrdersService;

    @ApiOperation(value = "分页查询订单列表", notes = "分页查询订单列表", httpMethod = "POST")
    @PostMapping("/query")
    public JSONResult query(@ApiParam(name = "userId", value = "用户id", required = true)
                            @RequestParam String userId,
                            @ApiParam(name = "orderStatus", value = "用户订单状态", required = false)
                            @RequestParam Integer orderStatus,
                            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
                            @RequestParam Integer page,
                            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
                                @RequestParam Integer pageSize
                            ){
        if (StringUtils.isBlank(userId)){
            return JSONResult.errorMsg(null);
        }

        if (page == null) page = 1;
        if (pageSize == null) pageSize = COMMON_PAGE_SIZE; // 10

        PagedGridResult grid = myOrdersService.queryMyOrders(userId, orderStatus, page, pageSize);

        return JSONResult.ok(grid);


    }

    @ApiOperation(value="商家发货", notes="商家发货", httpMethod = "GET")
    @GetMapping("/deliver")
    public JSONResult deliver(
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId) throws Exception {

        if (StringUtils.isBlank(orderId)) {
            return JSONResult.errorMsg("订单ID不能为空");
        }
        myOrdersService.updateDeliverOrderStatus(orderId);
        return JSONResult.ok();
    }

    @ApiOperation(value="用户确认收货", notes="用户确认收货", httpMethod = "POST")
    @PostMapping("/confirmReceive")
    public JSONResult confirmReceive(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId
            ) throws Exception {

        // 1. 验证策略
        // 1.1 验证参数合法性
        if (StringUtils.isBlank(orderId)) {
            return JSONResult.errorMsg("订单ID不能为空");
        }
        // 1.2 验证用户和订单关联性
        JSONResult checkResult = checkUserOrder(userId, orderId);
        if (checkResult.getStatus() != HttpStatus.OK.value()){
            return checkResult;
        }

        boolean res = myOrdersService.updateReceiveOrderStatus(orderId);
        if (!res) return JSONResult.errorMsg("订单确认收货失败");

        return JSONResult.ok();
    }

    @ApiOperation(value="用户删除订单", notes="用户删除订单", httpMethod = "POST")
    @PostMapping("/delete")
    public JSONResult delete(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @RequestParam String orderId
    ) throws Exception {

        // 1. 验证策略
        // 1.1 验证参数合法性
        if (StringUtils.isBlank(orderId)) {
            return JSONResult.errorMsg("订单ID不能为空");
        }
        // 1.2 验证用户和订单关联性
        JSONResult checkResult = checkUserOrder(userId, orderId);
        if (checkResult.getStatus() != HttpStatus.OK.value()){
            return checkResult;
        }

        boolean res = myOrdersService.deleteOrder(userId, orderId);
        if (!res) return JSONResult.errorMsg("订单删除失败");

        return JSONResult.ok();
    }


    @ApiOperation(value="获得订单状态数概况", notes="获得订单状态数概况", httpMethod = "POST")
    @PostMapping("/statusCounts")
    public JSONResult statusCounts(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId) {
        // 用户id不能为空
        if (StringUtils.isBlank(userId)) return JSONResult.errorMsg(null);

        OrderStatusCountsVO result = myOrdersService.getOrderStatusCounts(userId);
        return JSONResult.ok(result);
    }

    @ApiOperation(value="查询订单动向", notes="查询订单动向", httpMethod = "POST")
    @PostMapping("/trend")
    public JSONResult trend(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
            @RequestParam Integer pageSize) {
        // 用户id不能为空
        if (StringUtils.isBlank(userId)){
            return JSONResult.errorMsg(null);
        }

        if (page == null) page = 1;
        if (pageSize == null) pageSize = COMMON_PAGE_SIZE; // 10
        PagedGridResult grid = myOrdersService.getOrderTrend(userId, page, pageSize);
        return JSONResult.ok(grid);
    }


}
