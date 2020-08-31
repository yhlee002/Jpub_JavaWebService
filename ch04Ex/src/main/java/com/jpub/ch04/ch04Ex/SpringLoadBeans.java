package com.jpub.ch04.ch04Ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringLoadBeans {
    public static void main(String args[]){
        ApplicationContext ctx = SpringApplication.run(SpringLoadBeans.class, args);
//        String[] beanNames  = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for(String name : beanNames){
//            System.out.println(name);
//        }
    }
}
