package com.jpub.ch04.ch04Ex.config;

import com.jpub.ch04.ch04Ex.controller.ExecuteTimeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;
/*
 * 클래스파일을 사용해 설정 추가 가능
 * static이나 public 이외의 폴더에 resource를 저장하려고 할 때 경로를 지정해주거나,
 * 별도의 resolver 추가, 캐시 설정 변경 등을 수행 가능
 * WebMvcConfigurerAdapter를 상속해서 addResourceHandler혹은 addViewControllers 등을 사용 가능
 * cf. WebMvcConfigurerAdapter는 deprecated됨(이전까지는 이를 상속해야 원하는 메소드만 오버라이딩 가능했지만,
 * 이제 모든 메소드를 필요한 메소드만 골라 오버라이딩 가능하게 되면서 필요없어지게 되어 deprecated)
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ExecuteTimeInterceptor executeTimeInterceptor(){
        return new ExecuteTimeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(executeTimeInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/", "/assets/")
                .setCachePeriod(60*60*24*365) //캐시 기한 : 1년
                .resourceChain(true)
                .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
    }
    //페이지에 데이터를 추가로 전달하지 않고, 페이지와 url의 연결만 필요한 경우에는 addViewControllers()를 사용하면 됨
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }
}
