package com.tooklili.tookitem.config;

import com.tooklili.tookitem.util.WebUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *服务接口url配置
 */
@Component
public class ServerUrlConfig {


    @Value("${server.api.type}")
    private  String type;

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerUrlConfig.class);

    /**
     * 随机获取商品接口
     */
    private  String randomItemUrl;

    /**

     * 获取淘口令接口
     */
    private  String twdAndShortLinkInfoUrl;

    /**
     * 超级搜商品接口
     */
    private  String superSearchItemsUrl;


    /**
     * 动态获取基础url
     * @return
     */
     private  String getBaseUrl(){
         String baseUrl =null;
         if(StringUtils.isNotEmpty(type) && "dynamic".equals(type)){
             ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
             HttpServletRequest request = requestAttributes.getRequest();
              baseUrl = WebUtils.getLocaleUrlRoot(request)+"/tookApp";
         }else{
              baseUrl = "http://zch.tooklili.com/tookApp";
         }

         LOGGER.info("服务接口请求的基础url：{}",baseUrl);
         return baseUrl;
     }


    public String getRandomItemUrl() {
        return getBaseUrl()+"/getRandomItemByCateId";
    }

    public String getTwdAndShortLinkInfoUrl() {
        return getBaseUrl() +"/getTwdAndShortLinkInfo";
    }

    public String getSuperSearchItemsUrl() {
        return getBaseUrl() +"/superSearchItems";
    }


}
