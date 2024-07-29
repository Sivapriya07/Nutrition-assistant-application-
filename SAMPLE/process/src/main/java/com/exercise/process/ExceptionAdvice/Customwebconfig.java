//package com.exercise.process.ExceptionAdvice;
//
//import com.exercise.process.config.CustomInterceptor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@RequiredArgsConstructor
//@Configuration
//public class Customwebconfig implements WebMvcConfigurer {
//    @Autowired
//    private CustomInterceptor customInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(customInterceptor);
//    }
//}