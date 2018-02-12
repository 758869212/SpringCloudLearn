package com.dong.springcloud.learn.ribbon.controller;

import com.dong.springcloud.learn.ribbon.service.TestRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @user Dong.
 * @date 2018-01-11 15：34
 */
@RestController
@RequestMapping("/ribbon")
public class TestRibbonController {

	@Autowired
	private TestRibbonService testRibbonService;

	@RequestMapping(value = "/testQuery")
	public String testQuery() {
		return testRibbonService.eruekaTestQuery();
	}
}
