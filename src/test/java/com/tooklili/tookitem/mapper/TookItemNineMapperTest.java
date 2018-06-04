package com.tooklili.tookitem.mapper;

import com.alibaba.fastjson.JSON;
import com.tooklili.tookitem.model.Item;
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
 * @date 2018年05月26日 下午10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TookItemNineMapperTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TookItemNineMapperTest.class);

    @Autowired
    private TookItemNineMapper tookItemNineMapper;

    @Test
    public void queryItemNine() {
        try{
            List<Item> items = tookItemNineMapper.queryItemNine();
            LOGGER.info("item:{}", JSON.toJSONString(items));
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }

    }
}