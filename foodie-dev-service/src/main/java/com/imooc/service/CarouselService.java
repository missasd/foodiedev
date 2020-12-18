package com.imooc.service;

import com.imooc.pojo.Carousel;

import java.util.List;

/**
 * 轮播图
 */
public interface CarouselService {
    // 查询所有
    public List<Carousel> queryAll(Integer isShow);

}
