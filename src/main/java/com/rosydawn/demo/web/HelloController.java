package com.rosydawn.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 相当于SpringMVC中的 @Controller + @ResponseBody
 */
@RestController
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	/**
	 * 映射"/hello"请求
	 */
	@RequestMapping("/hello")
	public String hello(){
		logger.error("ERROR日志");
		logger.warn("WARN日志");
		logger.info("INFO日志");
		logger.debug("DEBUG日志");
		return "Hello Spring Boot Application!";
	}
}
