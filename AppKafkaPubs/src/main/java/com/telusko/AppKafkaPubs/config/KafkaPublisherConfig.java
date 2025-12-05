package com.telusko.AppKafkaPubs.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.telusko.AppKafkaPubs.model.Customer;
import com.telusko.AppKafkaPubs.util.AppConstants;

@Configuration
public class KafkaPublisherConfig 
{
	@Bean
	public ProducerFactory<String, Customer> producerFactory()
	{
		Map<String ,Object> configProps=new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST_URL);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(configProps);
		
	}
	
	@Bean
	public KafkaTemplate<String, Customer> kafkaTemplate()
	{
		return new KafkaTemplate<String, Customer>(producerFactory());
	}
	
	
	
	

}
