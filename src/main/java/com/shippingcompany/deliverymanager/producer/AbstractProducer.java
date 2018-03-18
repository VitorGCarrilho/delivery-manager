package com.shippingcompany.deliverymanager.producer;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

public abstract class AbstractProducer<T> {
	
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
	
	/**
	 * Logger for ShipmentConsumer class
	 * **/
	private static Logger logger = LoggerFactory.getLogger(JmsMessagingTemplate.class);
	
	private Queue queue;  
	
	public AbstractProducer(Queue queue) {
		this.queue = queue;
	}
    
    public void produce(T t){
    	this.jmsMessagingTemplate.convertAndSend(queue, t);
    	logger.debug("jms message converted and sended: {}", t);
    }
    
}
