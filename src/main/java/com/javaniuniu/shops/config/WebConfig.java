package com.javaniuniu.shops.config;


import com.javaniuniu.shops.common.web.AdminAuthenticationInterceptor;
import com.javaniuniu.shops.common.web.AppConfigInterceptor;
import com.javaniuniu.shops.common.web.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 9:34 PM
 * 配置文件
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    AppConfigInterceptor appConfigInterceptor;

    @Autowired
    AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    AdminAuthenticationInterceptor adminAuthenticationInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns(
                "/user/*","/order/*","/cart/*"
        ).excludePathPatterns("/user/login","/user/reg","/user/logout");
        registry.addInterceptor(adminAuthenticationInterceptor).addPathPatterns(
                "/admin/*","/*/admin/*"
        ).excludePathPatterns("/admin/login","/admin/reg","/admin/logout");


        registry.addInterceptor(appConfigInterceptor).addPathPatterns(
                "/*"
        );
    }

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

}