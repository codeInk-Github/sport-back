package org.su.sportPlay.utils;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 后台监控
    @Bean
    public ServletRegistrationBean a() {
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(),
                        "/druid/*");
        // 需要登录，配置用户名和密码
        HashMap<String, String> initMap = new HashMap<>();
        initMap.put("loginUsername","zucker");
        initMap.put("loginPassword","123456");

        // 允许谁可以访问
        initMap.put("allow","");
        // 禁止谁访问
        //initMap.put("kuang","192.168.11.123");
        bean.setInitParameters(initMap);

        return bean;
    }


}
