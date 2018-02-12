package com.dong.springcloud.learn.ribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @user Dong.
 * @date 2018-01-11 15：42
 */
@Service
public class TestRibbonServiceImpl implements com.dong.springcloud.learn.ribbon.service.TestRibbonService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Override
	@HystrixCommand(fallbackMethod = "eruekaTestQueryError")
	public String eruekaTestQuery() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-CLIENT");
		System.out.println("serviceInstance.getPort() = " + serviceInstance.getPort());
		System.out.println("serviceInstance.getUri() = " + serviceInstance.getUri());
		return restTemplate.getForObject(serviceInstance.getUri()+"/test/testQuery",String.class);
	}

	public String eruekaTestQueryError() {
		return "eruekaTestQuery,Sorry,Error!";
	}
}
