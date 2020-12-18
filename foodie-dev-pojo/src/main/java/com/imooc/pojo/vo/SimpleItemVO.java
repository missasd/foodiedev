package com.imooc.pojo.vo;

/**
 * 6个商品的简单数据类型
 *
 *       <id column="itemId" property="itemId" jdbcType="VARCHAR" />
 *             <result column="itemName" property="itemName" jdbcType="VARCHAR" />
 *             <result column="itemUrl" property="itemUrl" jdbcType="VARCHAR" />
 */
public class SimpleItemVO {
    private String itemId;
    private String itemName;
    private String itemUrl;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
