package com.shippingcompany.deliverymanager.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.ShipmentStatus;
import com.shippingcompany.deliverymanager.service.ShipmentStatusService;

@Component
public class ShipmentStatusConsumer extends AbstractConsumer<ShipmentStatus> {
	
	@Autowired
	private ShipmentStatusService shipmentStatusService;

	@JmsListener(destination = "${app.queue.shipment.status}")
	public void consume(ShipmentStatus shipmentStatus) {
		shipmentStatusService.save(shipmentStatus);
	}

}
