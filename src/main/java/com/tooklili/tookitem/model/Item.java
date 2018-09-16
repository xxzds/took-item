package com.tooklili.tookitem.model;

import java.util.Date;
/**
 * 商品信息
 * @author shuai.ding
 * @date 2018年05月26日 下午8:52
 */
public class Item {

    /**
     * 主键
     */
    private Long id;

    /**
     * 商品分类id，关联表took_alimama_item_cate
     */
    private Integer cateId;

    /**
     * 淘宝中对应商品id
     */
    private Long numIid;

    /**
     * 商品标题
     */
    private String title;


    /**
     * 商品图片地址
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
     * 优惠券金额
     */
    private String quan;

    /**
     * 领券地址
     */
    private String quanUrl;

    /**
     * 优惠券总数
     */
    private Integer quanSurplus;

    /**
     * 优惠券剩余数
     */
    private Integer quanReceive;

    /**
     * 销量
     */
    private String volume;


    /**
     * 开始时间
     */
    private String couponStartTime;

    /**
     * 结束时间
     */
    private String couponEndTime;


    /**
     * 添加时间
     */
    private Date addTime;


    /**
     * 商品类别(B、天猫 C、淘宝)
     */
    private String shopType;

    /**
     * 商品简单描述
     */
    private String intro;

    /**
     * 优惠券id
     */
    private String couponId;

    /**
     * 单品淘客链接
     */
    private String clickUrl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public Integer getQuanSurplus() {
        return quanSurplus;
    }

    public void setQuanSurplus(Integer quanSurplus) {
        this.quanSurplus = quanSurplus;
    }

    public Integer getQuanReceive() {
        return quanReceive;
    }

    public void setQuanReceive(Integer quanReceive) {
        this.quanReceive = quanReceive;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(String couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public String getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(String couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCouponId() {
        return couponId;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getQuanUrl() {
        return quanUrl;
    }

    public void setQuanUrl(String quanUrl) {
        this.quanUrl = quanUrl;
    }
}
