package com.tooklili.tookitem.model.vo;

/**
 * @author shuai.ding
 * @date 2018年06月16日 下午6:11
 */
public class QueryItemVo {

    /**
     * 分类id
     */
    private Integer cateId;


    /**
     * 查询类型
     */
    private ItemQueryType type;

    public Integer getCateId() {
        return cateId;
    }

    public ItemQueryType getType() {
        return type;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public void setType(ItemQueryType type) {
        this.type = type;
    }

    public static enum ItemQueryType{
        moren,ishot,ishit,isfee;
    }
}


