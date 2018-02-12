package com.dong.springcloud.learn.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @user Dong.
 * @date 2018-01-11 11：21
 */
@RestController
@RequestMapping(value = "/test")
@RefreshScope
public class TestController {

	@Value("${server.port}")
	String port;

	@Value("${test.info}")
	String language;

	@RequestMapping(value = "/testQuery")
	public String testQuery() {
		return "testQuery,port:" + port + ",language:" + language;
	}

	@RequestMapping(value = "/token/info")
	public String testToken() {
		return "testToken,port:" + port + ",language:" + language;
	}
}
