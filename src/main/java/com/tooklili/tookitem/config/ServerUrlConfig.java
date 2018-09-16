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

     * 获取淘口令接口(淘宝客接口)
     */
    private  String twdAndShortLinkInfoUrl;

    /**
     * 超级搜商品接口
     */
    private  String superSearchItemsUrl;

    /**
     * 通过淘宝客接口获取商品列表
     */
    private String tbkApiItemUrl;


    /**
     * 通过分类，获取优惠券商品列表
     */
    private String materialGetItemsUrl;

    /**
     * 好券清单接口
     */
    private String getCouponItemsUrl;

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
              baseUrl = "http://www.tooklili.com/tookApp";
         }

         LOGGER.info("服务接口请求的基础url：{}",baseUrl);
         return baseUrl;
     }


    public String getRandomItemUrl() {
        return getBaseUrl()+"/getRandomItemByCateId";
    }

    public String getTwdAndShortLinkInfoUrl() {
        return getBaseUrl() +"/tbk/getTpwdAndShortLink";
    }

    public String getSuperSearchItemsUrl() {
        return getBaseUrl() +"/superSearchItems";
    }

    public String getTbkApiItemUrl() {
        return getBaseUrl() +"/tbk/material/optiona/getItems";
    }

    public String getMaterialGetItemsUrl() {
        return getBaseUrl()+"/tbk/material/getItems";
    }

    public String getGetCouponItemsUrl() {
        return getBaseUrl()+"/tbk/getCouponItems";
    }
}
