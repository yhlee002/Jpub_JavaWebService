package com.jpub.ch04.ch04Ex.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Interception : 'preHandle()' -> 컨트롤러의 메소드 -> 'postHandle()' -> 'afterConcurrentHandlingStarted()' '순으로 실행
 */
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis(); //1970년 1월 1일부터 현재까지의 밀리초
        request.setAttribute("startTime", startTime);

        String reqUri = request.getRequestURI();
        System.out.println("request uri : "+reqUri);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        long startTime = (long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        request.setAttribute("executeTime", executeTime);

        System.out.println("["+handler+"] executeTime : "+executeTime+"ms");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
