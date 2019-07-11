package com.nxist.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入我们自己定义的ErrorAttributes，改变springboot默认向错误页中提供的数据
 * @Author: xym760
 * @Date: 2019/7/11 17:39
 * @Description:
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    /**
     *
     * @param webRequest
     * @param includeStackTrace
     * @return 返回值的map就是页面和JSON能获取的所有字段
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "Microsoft");
        Throwable error = getError(webRequest);
        map.put("exception", error.getClass().getName());
        //吧我们的异常处理器携带的数据放入到map中，用于页面和JSON进行获取
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
    }

}
