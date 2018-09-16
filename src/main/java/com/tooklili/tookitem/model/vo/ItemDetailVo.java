package com.tooklili.tookitem.model.vo;

/**
 * @author shuai.ding
 * @date 2018年06月03日 下午3:28
 */
public class ItemDetailVo {

    /**
     * 标题
     */
    private String title;

    /**
     *主图url
     */
    private String picUrl;

    /**
     * 原价
     */
    private String price;

    /**
     * 折扣价
     */
    private String couponPrice;

    /**
     * 优惠券
     */
    private String quan;

    /**
     * 领券地址
     */
    private String quanUrl;

    /**
     * 销量
     */
    private String volume;

    /**
     * 淘宝中对应的商品id
     */
    private String numId;

    /**
     * 商品类别(B、天猫 C、淘宝)
     */
    private String shopType;

    /**
     * 单品淘客链接
     */
    private String clickUrl;

    /**
     * 用户表示 （1、ds 2、gc）
     */
    private Integer userFlag;

    public String getTitle() {
        return title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getPrice() {
        return price;
    }

    public String getCouponPrice() {
        return couponPrice;
    }

    public String getQuan() {
        return quan;
    }

    public String getVolume() {
        return volume;
    }

    public String getNumId() {
        return numId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getShopType() {
        return shopType;
    }

    public String getQuanUrl() {
        return quanUrl;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setQuanUrl(String quanUrl) {
        this.quanUrl = quanUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }
}
