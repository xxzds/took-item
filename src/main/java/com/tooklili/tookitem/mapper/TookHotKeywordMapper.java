package com.tooklili.tookitem.mapper;

import com.tooklili.tookitem.model.TookHotKeyword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 热门关键字持久层
 * @author shuai.ding
 * @date 2018年06月09日 下午2:43
 */
@Mapper
public interface TookHotKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TookHotKeyword record);

    int insertSelective(TookHotKeyword record);

    TookHotKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TookHotKeyword record);

    int updateByPrimaryKey(TookHotKeyword record);

    /**
     * 随机获取count个关键字
     * @param count
     * @return
     */
    List<TookHotKeyword> selectRandomKeyWord(@Param("count") Integer count);
}