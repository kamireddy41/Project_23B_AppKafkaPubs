package com.telusko.AppKafkaPubs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.telusko.AppKafkaPubs.model.Customer;
import com.telusko.AppKafkaPubs.util.AppConstants;

@Service
public class KafkaService 
{
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	
	public String addCxMessage(Customer cx)
	{
		kafkaTemplate.send(AppConstants.TOPIC_NAME, cx);
		return "Customer data added into Kafka Server";
	}
	

}
