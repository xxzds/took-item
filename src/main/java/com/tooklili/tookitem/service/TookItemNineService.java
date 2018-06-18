package com.tooklili.tookitem.service;

import com.tooklili.tookitem.model.Item;
import com.tooklili.tookitem.model.vo.QueryItemVo;
import com.tooklili.tookitem.result.PageResult;

/**
 * 9块9商品服务
 * @author shuai.ding
 * @date 2018年05月26日 下午10:49
 */
public interface TookItemNineService {

    /**
     * 分页查询9块9商品信息
     * @param queryItemVo      查询条件
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageResult<Item> findItemNine(QueryItemVo queryItemVo, Integer currentPage, Integer pageSize);
}
