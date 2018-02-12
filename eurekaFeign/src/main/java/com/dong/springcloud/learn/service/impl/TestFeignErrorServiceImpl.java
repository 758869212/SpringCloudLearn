package com.dong.springcloud.learn.service.impl;

import com.dong.springcloud.learn.service.TestFeignService;
import org.springframework.stereotype.Component;

/**
 * @user Dong.
 * @date 2018-01-13 16：02
 */
@Component
public class TestFeignErrorServiceImpl implements TestFeignService {

	public String testQuery() {
		return "Error Method testQuery!" ;
	}

	public String testToken() {
		return "Error Method testTokeny!" ;
	}
}
