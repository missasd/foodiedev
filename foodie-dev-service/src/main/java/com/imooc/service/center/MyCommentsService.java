package com.imooc.service.center;

import com.imooc.pojo.OrderItems;
import com.imooc.pojo.bo.center.OrderItemsCommentBO;
import com.imooc.utils.PagedGridResult;

import java.util.List;

public interface MyCommentsService {

    /**
     * 根据订单id查询待评价商品
     * @param orderId
     * @return
     */
    public List<OrderItems> queryPendingComment(String orderId);

    /**
     * 保存评价到数据库
     * @param orderId
     * @param userId
     * @param commentList
     */
    public void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);


    /**
     * 根据用户id分页查询历史评价
     * @param userId
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize);

}
