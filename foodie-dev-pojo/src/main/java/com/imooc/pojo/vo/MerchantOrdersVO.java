package com.imooc.pojo.vo;

public class MerchantOrdersVO {

    private String merchantOrderId; // 商户订单号
    private String merchantUserId; // 商户方的发起用户的主键id
    private Integer amount; // 实际支付金额
    private Integer payMethod; // 支付方式 1. 微信 2. 支付宝
    private String reutrnUrl;  // 支付成功后的回调地址 (自定义)

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public String getReutrnUrl() {
        return reutrnUrl;
    }

    public void setReturnUrl(String reutrnUrl) {
        this.reutrnUrl = reutrnUrl;
    }
}
