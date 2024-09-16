package com.stockservice.kafka;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.basedomains.dto.OrderEvent;

//import com.orderservice.kafka.OrderProducer;

@Service
public class OrderConsumer {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}",
			groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		
		LOGGER.info("Order event received in stock service => %s", event.toString());
	}
	
}
