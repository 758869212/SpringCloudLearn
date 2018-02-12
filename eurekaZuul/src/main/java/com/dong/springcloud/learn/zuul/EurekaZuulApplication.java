package com.dong.springcloud.learn.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @user Dong.
 * @date 2018-01-13 22：15
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class EurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaZuulApplication.class,args);
	}
}
