package com.tooklili.tookitem.service;

import com.tooklili.tookitem.model.TookItemSelect;
import com.tooklili.tookitem.result.PageResult;

/**
 * 人工选择的商品服务
 * @author shuai.ding
 * @date 2018年06月24日 下午5:42
 */
public interface TookItemSelectService {

    /**
     * 查询商品
     * @param cateName     商品分类
     * @param currentPage  当前页
     * @param pageSize     页面大小
     * @return
     */
    PageResult<TookItemSelect> findItem(String cateName,Integer currentPage, Integer pageSize);
}
