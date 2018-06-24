package com.tooklili.tookitem.mapper;

import com.tooklili.tookitem.model.TookItemSelect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 人工选择的商品 持久层
 * @author shuai.ding
 * @date 2018年06月24日 下午5:33
 */
@Mapper
public interface TookItemSelectMapper {

    /**
     * 通过商品分类，查询商品列表
     * @param cateName
     * @return
     */
    List<TookItemSelect> queryItem(@Param("cateName") String cateName);
}
