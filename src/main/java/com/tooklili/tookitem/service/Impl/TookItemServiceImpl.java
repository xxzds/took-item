package com.tooklili.tookitem.service.Impl;

import com.tooklili.tookitem.mapper.TookHotKeywordMapper;
import com.tooklili.tookitem.model.TookHotKeyword;
import com.tooklili.tookitem.service.TookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务
 */
@Service
public class TookItemServiceImpl implements TookItemService{

    @Autowired
    private TookHotKeywordMapper tookHotKeywordMapper;

    @Override
    public List<TookHotKeyword> getRandomKeywords(Integer count) {
        if(count == null){
            count = 10;
        }
        return tookHotKeywordMapper.selectRandomKeyWord(count);
    }
}
