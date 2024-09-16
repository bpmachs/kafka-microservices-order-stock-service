package com.orderservice.controller;

import org.apache.kafka.common.Uuid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basedomains.dto.Order;
import com.basedomains.dto.OrderEvent;
import com.orderservice.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	private OrderProducer orderProducer;

	public OrderController(OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
	}
	
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {
		order.setOrderId(Uuid.randomUuid().toString());
		
		OrderEvent orderEvent = new OrderEvent();
		
		orderEvent.setStatus("PENDING");
		orderEvent.setMessage("order is in a pending state");
		orderEvent.setOrder(order);
		return "Order placed succesffully";
	}
}
