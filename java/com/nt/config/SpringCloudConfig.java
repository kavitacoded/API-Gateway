package com.nt.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

	//1 Route Locator =list(routes) --> 1 route =1 MS
	@Bean
	public RouteLocator configRoute(RouteLocatorBuilder builder) {
			return builder.routes()
					//1 route -- 1 MS#
					.route("employeeId", r-> r.path("/emp/**").uri("lb://Emp-Service"))
					.route("productId", r->r.path("/product/**").uri("lb://Product-Service"))
		.build();
	
	}
	
}
