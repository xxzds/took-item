package com.tooklili.tookitem.service;

import com.alibaba.fastjson.JSON;
import com.tooklili.tookitem.model.TookItemSelect;
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
 * @date 2018年06月24日 下午5:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TookItemSelectServiceTest {
    private static  final Logger LOGGER = LoggerFactory.getLogger(TookItemSelectServiceTest.class);

    @Autowired
    private TookItemSelectService tookItemSelectService;


    @Test
    public void findItem() {
        PageResult<TookItemSelect> result = tookItemSelectService.findItem("纸巾",1,10);
        LOGGER.info("result:{}", JSON.toJSONString(result));
    }
}