package com.shippingcompany.deliverymanager.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.ShipmentStatus;
import com.shippingcompany.deliverymanager.service.ShipmentStatusService;

@Component
public class ShipmentStatusConsumer extends AbstractConsumer<ShipmentStatus> {
	
	/**
	 * shipmentStatusService will execute the business logic
	 * **/
	@Autowired
	private ShipmentStatusService shipmentStatusService;
	
	/**
	 * Logger for ShipmentStatusConsumer class
	 * **/
	private static Logger logger = LoggerFactory.getLogger(ShipmentStatusConsumer.class);

	/**
	 * This method consume the shipment status queue
	 * If some error occurs when try to save the shipment status on database, it will consume again until the successes.
	 * @param shipmentStatus  is the shipment status to be saved in the database.
	 * **/
	@JmsListener(destination = "${app.queue.shipment.status}")
	public void consume(ShipmentStatus shipmentStatus) {
		try {
			shipmentStatusService.save(shipmentStatus);
			logger.debug("shipment status {} was consumed by shipment status consumer.", shipmentStatus.getShipmentStatusCode());
		} catch (Exception e) {
			logger.error("an error occurred when trying to save the shipment status {}.", shipmentStatus.getShipmentStatusCode(), e);
			throw e;
		}
		
	}

}
