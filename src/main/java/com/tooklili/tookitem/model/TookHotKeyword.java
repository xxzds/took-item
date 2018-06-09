package com.tooklili.tookitem.model;

/**
 * 热门关键字
 * @author shuai.ding
 * @date 2018年06月09日 下午4:41
 */
public class TookHotKeyword {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 1-可用，2-不可用
     */
    private Integer isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }
}