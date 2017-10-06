package com.shippingcompany.deliverymanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shippingcompany.deliverymanager.exception.ServiceUnavaliableException;
import com.shippingcompany.deliverymanager.model.ShipmentStatus;
import com.shippingcompany.deliverymanager.producer.AbstractProducer;
import com.shippingcompany.deliverymanager.repository.ShipmentStatusRepository;

@Service
@Transactional
public class ShipmentStatusService {

	private ShipmentStatusRepository shipmentStatusRepository;

	private AbstractProducer<ShipmentStatus> shipmentStatusProducer;

	/**
	 * Logger for ShipmentStatusService class
	 **/
	private static Logger logger = LoggerFactory.getLogger(ShipmentStatusService.class);

	public void save(ShipmentStatus shipmentStatus) {
		shipmentStatusRepository.save(shipmentStatus);
	}

	public void produce(ShipmentStatus shipmentStatus) throws ServiceUnavaliableException {
		try {
			shipmentStatusProducer.produce(shipmentStatus);
		} catch (Exception e) {
			logger.error("An error occurs when trying produce the shipment status {}",
					shipmentStatus.getShipmentStatusCode(), e);
			throw new ServiceUnavaliableException("An error occurs when trying produce the shipment status");
		}

	}
	
	@Autowired
	public ShipmentStatusService(ShipmentStatusRepository shipmentStatusRepository, AbstractProducer<ShipmentStatus> shipmentStatusProducer){
		this.shipmentStatusRepository = shipmentStatusRepository;
		this.shipmentStatusProducer = shipmentStatusProducer;
	}

}
