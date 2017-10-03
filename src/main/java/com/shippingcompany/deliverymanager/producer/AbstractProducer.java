package com.shippingcompany.deliverymanager.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

public abstract class AbstractProducer<T> {
	@Autowired
    protected JmsMessagingTemplate jmsMessagingTemplate;
	
	protected Queue queue;  
	
	public AbstractProducer(Queue queue) {
		this.queue = queue;
	}
    
    public abstract void produce(T t);
}
