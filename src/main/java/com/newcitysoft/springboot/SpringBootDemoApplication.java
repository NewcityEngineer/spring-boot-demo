package com.newcitysoft.springboot;

import com.jfinal.core.JFinalFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/7/5 10:01
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
public class SpringBootDemoApplication {

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

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
