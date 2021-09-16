package com.airline.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author rmolaba1
 * It works only when we disable the gateway dependency in pom.xml
 */
@RestController
@RequestMapping("/api")
public class AirUserController {

	private RestTemplate restTemplate;
	public AirUserController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/message")
	public String getMessage() {
		return restTemplate.getForObject("http://AIRLINE-SERVICE-API/user/message", String.class);
	}

}
