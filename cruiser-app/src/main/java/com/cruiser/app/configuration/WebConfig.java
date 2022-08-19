package com.cruiser.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.app.controller" })
public class WebConfig implements WebMvcConfigurer {

	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	    registry
	        .addResourceHandler("/static/**") // « /static/css/myStatic.css
	        .addResourceLocations("classpath:/static/") // Default Static Loaction
	        .setCachePeriod( 3600 )
	        .resourceChain(true)
	        .addResolver(new PathResourceResolver());

	  }
}
