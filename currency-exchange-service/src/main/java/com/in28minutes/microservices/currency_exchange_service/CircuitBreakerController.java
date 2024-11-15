package com.in28minutes.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;



@RestController
public class CircuitBreakerController {

	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
//	@GetMapping("/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//	public String sampleApi(){
//		logger.info("Sample api call received");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
//					String.class);
//		return forEntity.getBody();
//	}
	
	@GetMapping("/sample-api")
//	@RateLimiter(name="default")
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	@Bulkhead(name="sample-api")
	public String sampleApi(){
//		logger.info("Sample api call received");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
//					String.class);
//		return forEntity.getBody();
		return "sample-api";
	}
	
	
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
	
	
}
