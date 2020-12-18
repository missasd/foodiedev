package com.imooc.controller.center;

import com.imooc.controller.BaseController;
import com.imooc.enums.YesOrNo;
import com.imooc.pojo.OrderItems;
import com.imooc.pojo.Orders;
import com.imooc.pojo.bo.center.OrderItemsCommentBO;
import com.imooc.service.center.MyCommentsService;
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

import java.util.List;

@Api(value = "用户中心评价模块", tags = {"用户中心评价模块"})
@RestController
@RequestMapping("mycomments")
public class MyCommentsController extends BaseController {
    /**
     *
     * serverUrl + '/mycomments/pending?userId=' + userInfo.id + "&orderId=" + orderId* 							})
     */

    @Autowired
    private MyCommentsService myCommentsService;

    @ApiOperation(value = "分页查询订单列表", notes = "分页查询订单列表", httpMethod = "POST")
    @PostMapping("/pending")
    public JSONResult query(@ApiParam(name = "userId", value = "用户id", required = true)
                            @RequestParam String userId,
                            @ApiParam(name = "orderId", value = "订单id", required = true)
                            @RequestParam String orderId

                            ){

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

        Orders myOrder = (Orders) checkResult.getData();
        // 1.3 判断该笔订单是否已经评价
        if (myOrder.getIsComment() == YesOrNo.YES.type) {
            return JSONResult.errorMsg("该笔订单已经评价");
        }

        List<OrderItems> list = myCommentsService.queryPendingComment(orderId);

        return JSONResult.ok(list);

    }

    /**
     *
     * @param userId
     * @param orderId
     * @param commentList 本身也是前端传过来的一个json ，list里的是一个BO也就是一个业务级对象
     * @return
     */
    @ApiOperation(value = "保存评论列表", notes = "保存评论列表", httpMethod = "POST")
    @PostMapping("/saveList")
    public JSONResult saveList(@ApiParam(name = "userId", value = "用户id", required = true)
                               @RequestParam String userId,
                               @ApiParam(name = "orderId", value = "订单id", required = true)
                               @RequestParam String orderId,
                               @RequestBody List<OrderItemsCommentBO> commentList
                               ){
        System.out.println(commentList);

        // 判断用户和订单是否关联
        JSONResult checkResult = checkUserOrder(userId, orderId);
        if (checkResult.getStatus() != HttpStatus.OK.value()){
            return checkResult;
        }
        // 判断评论内容list不能为空
        if (commentList == null || commentList.isEmpty() || commentList.size() == 0){
            return JSONResult.errorMsg("评论内容不能为空");
        }
        // 完成所有信息的保存 (涉及三张表)
        myCommentsService.saveComments(orderId, userId, commentList);
        return JSONResult.ok();
    }

    //

    @ApiOperation(value = "分页查询我的评价", notes = "分页查询我的评价", httpMethod = "POST")
    @PostMapping("/query")
    public JSONResult query(@ApiParam(name = "userId", value = "用户id", required = true)
                            @RequestParam String userId,
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

        PagedGridResult grid = myCommentsService.queryMyComments(userId,  page, pageSize);

        return JSONResult.ok(grid);


    }



}
