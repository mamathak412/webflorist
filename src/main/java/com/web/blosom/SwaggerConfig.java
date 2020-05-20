package com.web.blosom;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket customImplementation() {
		
		 return new Docket(DocumentationType.SWAGGER_2)
		    	  .apiInfo(getApiInfo())	  
		    	  .select()
			  .apis(RequestHandlerSelectors.any())
			  .paths(PathSelectors.any())
			  .build();
		
	}
	
	private ApiInfo getApiInfo() {
	      return new ApiInfo("REST Api Documentation",
		  "REST Api Documentation", 
		  "1.0", 
		  "urn:tos",
		   new Contact("", "", ""), 
		  "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", 
		   new ArrayList<VendorExtension>());
	   }

}
