package com.dong.springcloud.learn.service;

import com.dong.springcloud.learn.service.impl.TestFeignErrorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @user Dong.
 * @date 2018-01-12 15：00
 */
@FeignClient(name = "eureka-client",fallback = TestFeignErrorServiceImpl.class)
@Service
public interface TestFeignService {

	@RequestMapping(value = "/test/testQuery",method = RequestMethod.GET)
	String testQuery();

	@RequestMapping(value = "/test/token/info",method = RequestMethod.GET)
	String testToken();
}
