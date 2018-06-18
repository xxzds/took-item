package com.tooklili.tookitem.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tooklili.tookitem.mapper.TookItemTwentyMapper;
import com.tooklili.tookitem.model.Item;
import com.tooklili.tookitem.model.vo.QueryItemVo;
import com.tooklili.tookitem.result.PageResult;
import com.tooklili.tookitem.service.TookItemTwentyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuai.ding
 * @date 2018年05月27日 上午11:39
 */
@Service
public class TookItemTwentyServiceImpl implements TookItemTwentyService{

    @Autowired
    private TookItemTwentyMapper tookItemTwentyMapper;

    @Override
    public PageResult<Item> findItemTwenty(QueryItemVo queryItemVo,Integer currentPage, Integer pageSize) {
        PageResult<Item> result = new PageResult<>();

        if(currentPage == null) currentPage = 1;
        if(pageSize == null) pageSize = 10;

        PageHelper.startPage(currentPage,pageSize);
        Page<Item> page = null;
        if(queryItemVo == null){
            page = (Page<Item>)tookItemTwentyMapper.queryItemTwenty(null,null);
        }else{
            page = (Page<Item>)tookItemTwentyMapper.queryItemTwenty(queryItemVo.getCateId(),queryItemVo.getType() == null ? null : queryItemVo.getType().toString());
        }

        result.setData(page.getResult());
        result.setCurrentPage(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setTotalCount(page.getTotal());

        return result;
    }
}
