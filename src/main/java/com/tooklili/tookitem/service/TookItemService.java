package com.tooklili.tookitem.service;

import com.tooklili.tookitem.model.TookHotKeyword;

import java.util.List;

/**
 * 商品服务
 */
public interface TookItemService {

    /**
     * 获取{count}个热门关键字
     * @param count  个数
     * @return
     */
    List<TookHotKeyword> getRandomKeywords(Integer count);
}
