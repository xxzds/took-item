package com.tooklili.tookitem.service;

import com.alibaba.fastjson.JSON;
import com.tooklili.tookitem.model.Item;
import com.tooklili.tookitem.result.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuai.ding
 * @date 2018年05月27日 上午11:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TookItemTwentyServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TookItemTwentyServiceTest.class);


    @Autowired
    private TookItemTwentyService tookItemTwentyService;

    @Test
    public void findItemTwenty() {
        try{
            PageResult<Item> result=  tookItemTwentyService.findItemTwenty(null,1,10);
            LOGGER.info("items:{}", JSON.toJSONString(result));
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }
    }
}