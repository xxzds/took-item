package com.tooklili.tookitem.mapper;

import com.tooklili.tookitem.model.TookAlimamaItemCate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 阿里妈妈 商品分类 持久层
 */
@Mapper
public interface TookAlimamaItemCateMapper {

    /**
     * 查询所有可用的分类
     * @return
     */
    List<TookAlimamaItemCate> getTookAlimamaItemCates();
}