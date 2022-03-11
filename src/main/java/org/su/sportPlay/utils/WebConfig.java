//package org.su.sportPlay.utils;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//// 全局配置类 -- 配置跨域请求
//@Configuration
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        /**
//         * 1. 访问路径
//         * 2. 请求来源
//         * 3. 方法
//         * 4. 允许携带
//         * 5. 最大请求时间
//         */
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8080/sports/","null")
//                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE")
//                .allowCredentials(true)
//                .maxAge(10000);
//    }
//}
package org.su.sportPlay.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// 全局配置类 -- 配置跨域请求
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080","http://192.168.0.102:8080")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(5000)
                .allowedHeaders("*");
    }
}
