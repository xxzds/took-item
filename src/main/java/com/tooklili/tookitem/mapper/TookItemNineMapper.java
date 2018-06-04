package com.tooklili.tookitem.mapper;

import com.tooklili.tookitem.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shuai.ding
 * @date 2018年05月26日 下午8:57
 */
@Mapper
public interface TookItemNineMapper {
    /**
     * 查询9块9商品
     * @return
     */
    List<Item> queryItemNine();
}