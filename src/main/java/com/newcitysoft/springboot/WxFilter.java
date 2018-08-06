package com.newcitysoft.springboot;

import com.jfinal.core.JFinalFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/8/6 17:08
 */
@Configuration
public class WxFilter {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new JFinalFilter());
        bean.addUrlPatterns("/wx/*");
        bean.addInitParameter("configClass", "com.newcitysoft.springboot.config.WxConfig");
        bean.setName("WxFilter");
        bean.setOrder(0);

        return bean;
    }
}
