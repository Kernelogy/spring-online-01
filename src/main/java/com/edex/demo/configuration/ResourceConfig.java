package com.edex.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //Serve the resources under this url
		registry.addResourceHandler("/uploads/**")
        .addResourceLocations("file:" + 
                //Resource folder to serve
                env.getProperty("resources.uploads.location") 
            );
	}
	
}