package com.tooklili.tookitem.config;

import com.tooklili.tookitem.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *服务接口url配置
 */
public class ServerUrlConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerUrlConfig.class);

    /**
     * 随机获取商品接口
     */
    public  static String randomItemUrl = getBaseUrl()+"/getRandomItemByCateId";

    /**
     * 获取淘口令接口
     */
    public static String twdAndShortLinkInfoUrl = getBaseUrl() +"/getTwdAndShortLinkInfo";

    /**
     * 超级搜商品接口
     */
    public static  String superSearchItemsUrl = getBaseUrl() +"/superSearchItems";


    /**
     * 动态获取基础url
     * @return
     */
     private static String getBaseUrl(){
         ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = requestAttributes.getRequest();
         String baseUrl = WebUtils.getLocaleUrlRoot(request)+"/tookApp";
         LOGGER.info("服务接口请求的基础url：{}",baseUrl);
         return baseUrl;
     }
}
