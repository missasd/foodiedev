package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.service.CarouselService;
import com.imooc.service.CategoryService;
import com.imooc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("index")
@Api(value = "首页", tags = {"用于首页的相关接口"})
public class IndexController {

    @Autowired
    CarouselService carouselService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/carousel")
    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    public JSONResult carousel(){
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);

        return JSONResult.ok(list);
    }

    /**
     * 首页分类展示需求：
     * 1. 第一次刷新主页查询大分类, 渲染展示到首页
     * 2. 如果鼠标上移到大分类, 则加载其子分类的内容, 如果已经存在子分类, 则不需要加载(懒加载)
     */
    @RequestMapping("/cats")
    @ApiOperation(value = "用于获取商品分类（一级分类）", notes = "用于获取商品分类 （一级分类）", httpMethod = "GET")
    public JSONResult category(){
        List<Category> list = categoryService.queryAllRootLevelCat();
        return JSONResult.ok(list);
    }

    /**
     *  subCat/' + rootCatId,
     */
    @RequestMapping("/subCat/{rootCatId}")
    @ApiOperation(value = "用于获取商品子分类", notes = "用于获取商品子分类", httpMethod = "GET")
    public JSONResult subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id",required = true)
            @PathVariable("rootCatId") Integer rootCatId){
        if (rootCatId == null){
            return JSONResult.errorMsg("分类不存在");
        }

        List<CategoryVO> subCatList = categoryService.getSubCatList(rootCatId);
        return JSONResult.ok(subCatList);
    }

    @GetMapping("/sixNewItems/{rootCatId}")
    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    public JSONResult getSixNewItemsLazy(
            @ApiParam(name = "rootCatId", value = "一级分类id",required = true)
            @PathVariable("rootCatId")Integer rootCatId){
        if (rootCatId == null) return JSONResult.errorMsg("分类不存在");
        List sixNewItemsLazy = categoryService.getSixNewItemsLazy(rootCatId);
        if (sixNewItemsLazy.size() == 0 || sixNewItemsLazy == null){
            return JSONResult.errorMsg("");
        }
        return JSONResult.ok(sixNewItemsLazy);
    }



}

