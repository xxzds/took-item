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
 * @date 2018年05月26日 下午10:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TookItemNineServiceTest {
    private static  final Logger LOGGER = LoggerFactory.getLogger(TookItemNineServiceTest.class);

    @Autowired
    private TookItemNineService tookItemNineService;

    @Test
    public void findItemNine() {
        try{
            PageResult<Item> result=  tookItemNineService.findItemNine(null,1,10);
            LOGGER.info("items:{}", JSON.toJSONString(result));
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }
    }
}