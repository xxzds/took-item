package com.tooklili.tookitem.mapper;

import com.alibaba.fastjson.JSON;
import com.tooklili.tookitem.model.TookHotKeyword;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author shuai.ding
 * @date 2018年06月09日 下午2:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TookHotKeywordMapperTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TookHotKeywordMapperTest.class);

    @Autowired
    private TookHotKeywordMapper tookHotKeywordMapper;

    /**
     * 随机获取关键字
     * @throws Exception
     */
    @Test
    public void selectRandomKeyWord() throws Exception {
        try{
            List<TookHotKeyword> list = tookHotKeywordMapper.selectRandomKeyWord(10);
            LOGGER.info("keywords:{}", JSON.toJSONString(list));
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }

    }

}