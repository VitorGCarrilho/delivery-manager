package com.shippingcompany.deliverymanager.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.service.ShipmentService;
 
@Component
public class ShipmentConsumer extends AbstractConsumer<Shipment> {
	
	@Autowired
	private ShipmentService shipmentService;

	@JmsListener(destination = "${app.queue.shipment}")
    public void consume(Shipment shipment) {
        shipmentService.save(shipment);
    }
 
}