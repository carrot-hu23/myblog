package com.hujinbo.blogs.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 虚拟路径映射: C:/blogData/ -》localhost:8080/image/资源名称
 * @author 胡锦波
 **/
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:C:/blogData/");
    }
}




