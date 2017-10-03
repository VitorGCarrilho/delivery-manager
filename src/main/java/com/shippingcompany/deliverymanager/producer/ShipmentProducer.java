package com.shippingcompany.deliverymanager.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.Shipment;
 
@Component
public class ShipmentProducer extends AbstractProducer<Shipment> { 
	
	@Autowired
    public ShipmentProducer (@Qualifier("shipmentQueue") Queue queue){
		super(queue);
	}  
	
    public void produce(Shipment shipment) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, shipment);
    }
}