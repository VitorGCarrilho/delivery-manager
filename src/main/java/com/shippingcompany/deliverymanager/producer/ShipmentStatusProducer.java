package com.shippingcompany.deliverymanager.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.ShipmentStatus;

@Component
public class ShipmentStatusProducer extends AbstractProducer<ShipmentStatus> {
	
	@Autowired
    public ShipmentStatusProducer (@Qualifier("shipmentStatusQueue") Queue queue){
		super(queue);
	}
	
}
