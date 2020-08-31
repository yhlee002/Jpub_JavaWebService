package com.jpub.ch04.ch04Ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@ControllerAdvice // 클래스의 경로를 검색해서 오류를 캐치할 구현 클래스를 만들게 도와줌
public class ResourceAdvice {
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @ModelAttribute("versionResourceResolver")
    public ResourceUrlProvider versionResourceResolver(){
        return this.resourceUrlProvider;
    }
}
