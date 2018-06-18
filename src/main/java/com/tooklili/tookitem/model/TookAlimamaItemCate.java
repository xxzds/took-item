package com.tooklili.tookitem.model;

/**
 * 阿里妈妈商品分类（超值9块9、20元封顶、特价好货、高佣活动）
 */
public class TookAlimamaItemCate {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String itemCateName;

    /**
     * 排序位置
     */
    private Integer itemCateSort;

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

    public String getItemCateName() {
        return itemCateName;
    }

    public void setItemCateName(String itemCateName) {
        this.itemCateName = itemCateName == null ? null : itemCateName.trim();
    }

    public Integer getItemCateSort() {
        return itemCateSort;
    }

    public void setItemCateSort(Integer itemCateSort) {
        this.itemCateSort = itemCateSort;
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }
}