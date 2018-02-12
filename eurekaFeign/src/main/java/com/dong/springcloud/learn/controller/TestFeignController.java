package com.dong.springcloud.learn.controller;

import com.dong.springcloud.learn.service.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @user Dong.
 * @date 2018-01-12 15：03
 */
@RestController
@RequestMapping("/feign")
public class TestFeignController {

	@Autowired
	private TestFeignService testFeignService;

	@RequestMapping("/testQuery")
	public String testFegin() {
		return testFeignService.testQuery();
	}

	@RequestMapping("/token/testToken")
	public String testFeginToken() {
		return testFeignService.testToken();
	}
}
