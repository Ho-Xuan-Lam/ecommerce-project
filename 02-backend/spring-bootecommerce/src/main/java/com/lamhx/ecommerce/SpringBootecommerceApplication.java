package com.lamhx.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;




@SpringBootApplication
@EnableSwagger2WebMvc
public class SpringBootecommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootecommerceApplication.class, args);
	}

}
