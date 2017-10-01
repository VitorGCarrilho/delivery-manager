package com.shippingcompany.deliverymanager.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.service.ShipmentService;
import static com.shippingcompany.deliverymanager.util.ApiUtils.SHIPMENT_QUEUE_VARIABLE;
 
@Component
public class ShipmentConsumer extends AbstractConsumer<Shipment> {
	
	@Autowired
	private ShipmentService shipmentService;

	@JmsListener(destination = SHIPMENT_QUEUE_VARIABLE)
    public void consume(Shipment shipment) {
        shipmentService.save(shipment);
    }
 
}