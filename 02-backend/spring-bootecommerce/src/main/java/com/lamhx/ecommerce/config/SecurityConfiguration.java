//package com.lamhx.ecommerce.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@CrossOrigin("http://localhost:4200")
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		// protect endpoint /api/orders
//		http.authorizeRequests()
//			.antMatchers("/api/orders/**")
//			.authenticated()
//			.and()
//			.oauth2ResourceServer()
//			.jwt();
//		
//		// add CORS filter
//		http.cors();
//	}	
//}
