package com.tooklili.tookitem.mapper;

import com.tooklili.tookitem.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 20元商品持久层
 * @author shuai.ding
 * @date 2018年05月27日 上午10:35
 */
@Mapper
public interface TookItemTwentyMapper {

    /**
     * 查询20块商品
     * @return
     */
    List<Item> queryItemTwenty();

}