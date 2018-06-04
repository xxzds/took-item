package com.tooklili.tookitem.service;

import com.tooklili.tookitem.model.Item;
import com.tooklili.tookitem.result.PageResult;

/**
 * 20元商品服务
 * @author shuai.ding
 * @date 2018年05月27日 上午11:38
 */
public interface TookItemTwentyService {

    /**
     * 分页查询20元商品信息
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageResult<Item> findItemTwenty(Integer currentPage, Integer pageSize);
}
