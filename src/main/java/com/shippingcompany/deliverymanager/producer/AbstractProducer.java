package com.shippingcompany.deliverymanager.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

public abstract class AbstractProducer<T> {
	@Autowired
    protected JmsMessagingTemplate jmsMessagingTemplate;
    
    public abstract void produce(T t);
}
