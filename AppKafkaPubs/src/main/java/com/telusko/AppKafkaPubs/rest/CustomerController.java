package com.telusko.AppKafkaPubs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.AppKafkaPubs.model.Customer;
import com.telusko.AppKafkaPubs.service.KafkaService;

@RestController
public class CustomerController 
{
	@Autowired
	private KafkaService service;
	
	@PostMapping("/addcx")
	public String addCx(@RequestBody Customer cx)
	{
		return service.addCxMessage(cx);
	}
	
//	@PostMapping("/addcx")
//	public ResponseEntity<String> addCx(@RequestBody Customer cx)
//	{
//		String msg= service.addCxMessage(cx);
//		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
//	}

}
