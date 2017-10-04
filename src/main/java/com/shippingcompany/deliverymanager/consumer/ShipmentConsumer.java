package com.shippingcompany.deliverymanager.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.service.ShipmentService;
 
@Component
public class ShipmentConsumer extends AbstractConsumer<Shipment> {
	
	/**
	 * ShipmentService will execute the business logic
	 * **/
	@Autowired
	private ShipmentService shipmentService;
	
	/**
	 * Logger for ShipmentConsumer class
	 * **/
	private static Logger logger = LoggerFactory.getLogger(ShipmentConsumer.class);

	/**
	 * This method consume the shipment queue
	 * If some error occurs when try to save the shipment on database, it will consume again until the successes.
	 * @param shipment is the shipment to be saved in the database.
	 * **/
	@JmsListener(destination = "${app.queue.shipment}")
    public void consume(Shipment shipment) {
		try {
			shipmentService.save(shipment);
        	logger.debug("shipment {} was consumed by shipment consumer.", shipment.getShipmentCode());
		} catch (Exception e) {
			logger.error("an error occurred when trying to save the shipment {}.", shipment.getShipmentCode(), e);
			throw e;
		}
    }
 
}