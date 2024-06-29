package com.sondev.interceptor.config;

import com.sondev.interceptor.interceptor.AdminInterceptor;
import com.sondev.interceptor.interceptor.ClientInterceptor;
import com.sondev.interceptor.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // OneNote k có ghi
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Autowired
    AdminInterceptor adminInterceptor;
    @Autowired
    ClientInterceptor clientInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // Đăng ký các interceptor với "registry"
        // Ở đây đăng ký 3 interceptor: LoginInterceptor, AdminInterceptor, ClientInterceptor
        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/login");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**")
              .excludePathPatterns("/admin/login","/admin/chklogin");
        registry.addInterceptor(clientInterceptor).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);

        // Notation: Có thể đang ký bao nhiêu Interceptor tuỳ ý.
    }
}
