package com.example.basic_interceptor.RequestInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Component
public class RequestInterceptor extends InterceptorRegistry implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // return HandlerInterceptor.super.preHandle(request, response, handler);

        //* Business logic just when the request is received and intercepted by this interceptor before reaching the controller
        try {
            System.out.println("1 - preHandle() : Before sending request to the Controller");
            System.out.println("Method Type: " + request.getMethod());
            System.out.println("Request URL: " + request.getRequestURI());
        }
        //* If the Exception is caught, this method will return false
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        //* Business logic just before the response reaches the client and the request is served
        try {
            System.out.println("2 - postHandle() : After the Controller serves the request (before returning back response to the client)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

        //* Business logic after request and response is Completed
        try {
            System.out.println("3 - afterCompletion() : After the request and Response is completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
