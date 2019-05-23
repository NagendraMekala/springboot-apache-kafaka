package com.example.springBootKafakaProducer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserController {
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "spring-json-topic";
	
	@GetMapping("/send/{name}")
	public String post(@PathVariable("name") final String name) throws InterruptedException, ExecutionException, TimeoutException {
					
		for (int i = 0; i < 2000; i++) {
		ListenableFuture<SendResult<String, User>> ac = kafkaTemplate.send(TOPIC, new User(name+i, "It", 60000));
		ac.addCallback(new AsyncProducerHandler());
		}
		
		return "message successfully sent";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello message";
	}

}
