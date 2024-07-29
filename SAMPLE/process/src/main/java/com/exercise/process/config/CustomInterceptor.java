//package com.exercise.process.config;
//
//import com.exercise.process.jwtAuth.JwtUtil;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//
//@Component
//public class CustomInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        System.out.println(request.getRequestURI());
//        String auth=request.getHeader("authorisation");
//        if((request.getRequestURI().contains("login") || request.getRequestURI().contains("save"))){
//           jwtUtil.extractAllClaims(auth);
//        }
////        System.out.println(auth);
//
//        return HandlerInterceptor.super.preHandle(request, response, handler);
//
//    }
//}
