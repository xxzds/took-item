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
     * 销量
     */
    private String volume;

    /**
     * 淘宝中对应的商品id
     */
    private String numId;

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
}
