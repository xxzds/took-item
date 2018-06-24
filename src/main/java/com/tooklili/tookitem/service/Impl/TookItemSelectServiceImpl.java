package com.tooklili.tookitem.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tooklili.tookitem.mapper.TookItemSelectMapper;
import com.tooklili.tookitem.model.TookItemSelect;
import com.tooklili.tookitem.result.PageResult;
import com.tooklili.tookitem.service.TookItemSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuai.ding
 * @date 2018年06月24日 下午5:45
 */
@Service
public class TookItemSelectServiceImpl implements TookItemSelectService {

    @Autowired
    private TookItemSelectMapper tookItemSelectMapper;


    @Override
    public PageResult<TookItemSelect> findItem(String cateName, Integer currentPage, Integer pageSize) {
        PageResult<TookItemSelect> result = new PageResult<TookItemSelect>();

        if(currentPage == null) currentPage = 1;
        if(pageSize == null) pageSize = 10;

        PageHelper.startPage(currentPage,pageSize);

        Page<TookItemSelect> page = (Page<TookItemSelect>)tookItemSelectMapper.queryItem(cateName);

        result.setData(page.getResult());
        result.setCurrentPage(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setTotalCount(page.getTotal());

        return result;
    }
}
