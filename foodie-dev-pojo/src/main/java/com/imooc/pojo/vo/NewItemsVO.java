package com.imooc.pojo.vo;

import java.util.List;

/**
 * 最新商品VO
 */
public class NewItemsVO {
    /**

     <id column="rootCatId" property="rootCatId" jdbcType="INTEGER" />
     <result column="rootCatName" property="rootCatName" jdbcType="VARCHAR" />
     <result column="slogan" property="slogan" jdbcType="VARCHAR" />
     <result column="catImage" property="catImage" jdbcType="VARCHAR" />
     <result column="bgColor" property="bgColor" jdbcType="VARCHAR" />
     */

    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;

    private List<SimpleItemVO> simpleItemList;

    public Integer getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public List<SimpleItemVO> getSimpleItemList() {
        return simpleItemList;
    }

    public void setSimpleItemList(List<SimpleItemVO> simpleItemList) {
        this.simpleItemList = simpleItemList;
    }
}
