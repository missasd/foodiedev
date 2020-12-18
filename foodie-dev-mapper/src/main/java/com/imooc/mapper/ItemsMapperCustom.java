package com.imooc.mapper;

import com.imooc.pojo.vo.ItemCommentVO;
import com.imooc.pojo.vo.SearchItemsVO;
import com.imooc.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {
    // @Param("paramsMap" 中的值需与xml中的参数一致
    public List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    // searchItems
    public List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);

    // searchItems
    public List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);

    public List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List specIdList);

    // 返回值1表示update语句执行成功, 0表示执行失败
    public int decreaseItemSpecStock( @Param("specId") String specId ,
                                      @Param("pendingCounts") int pendingCounts);


}
