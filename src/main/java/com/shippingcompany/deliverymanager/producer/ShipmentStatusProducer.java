package com.shippingcompany.deliverymanager.producer;

import javax.annotation.Resource;
import javax.jms.Queue;

import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.ShipmentStatus;

@Component
public class ShipmentStatusProducer extends AbstractProducer<ShipmentStatus> {

	@Resource(name = "shipmentStatusQueue")
	protected Queue queue;  
	
	@Override
	public void produce(ShipmentStatus shipmnetStatus) {
		this.jmsMessagingTemplate.convertAndSend(queue, shipmnetStatus);
	}

}
