package com.interceptor2.demo_interceptor2.configurations;

import com.interceptor2.demo_interceptor2.interceptors.APILoggingInterceptor;
import com.interceptor2.demo_interceptor2.interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMVCConfigurazion implements WebMvcConfigurer {
    @Autowired
    private MonthInterceptor monthInterceptor;
    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor).addPathPatterns("/months");
        registry.addInterceptor(apiLoggingInterceptor).addPathPatterns("/months");
    }

}
