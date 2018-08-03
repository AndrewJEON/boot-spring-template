package com.boot.template.config.springconfig;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import com.boot.template.framework.web.log.ControllerLoggingAspect;
import com.boot.template.interceptor.TemplateInterceptor;

/**
 * Spring Web MVC Configuration 확장
 *
 * @author Cheong SungHyun <hashmap27@gmail.com>
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /** Controller AOP 로깅 */
    @Bean
    public ControllerLoggingAspect controllerLoggingAspect() {
        return new ControllerLoggingAspect();
    }

    /** Interceptor */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TemplateInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //NOTE: 입맛대로 수정
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/").setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).mustRevalidate());
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS).mustRevalidate());
        registry.addResourceHandler("/html/**").addResourceLocations("/html").setCacheControl(CacheControl.noStore());
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS).mustRevalidate());
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCacheControl(CacheControl.noStore());
        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/").setCacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS).mustRevalidate());
        registry.addResourceHandler("/web/**").addResourceLocations("/web/").setCacheControl(CacheControl.noStore());
    }

    /** Spring에서 사용할 ViewResolver 설정 */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
        MappingJackson2XmlView xmlView = new MappingJackson2XmlView();
        xmlView.setPrettyPrint(true);
        registry.enableContentNegotiation(jsonView, xmlView);
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

}
