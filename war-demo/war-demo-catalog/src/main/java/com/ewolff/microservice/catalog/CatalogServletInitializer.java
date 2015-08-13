package com.ewolff.microservice.catalog;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class CatalogServletInitializer extends SpringBootServletInitializer {
	
	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(CatalogApp.class);
	    }

}
