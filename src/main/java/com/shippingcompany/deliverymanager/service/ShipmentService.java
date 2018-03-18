package com.shippingcompany.deliverymanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shippingcompany.deliverymanager.exception.NotFoundException;
import com.shippingcompany.deliverymanager.exception.ServiceUnavaliableException;
import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.producer.AbstractProducer;
import com.shippingcompany.deliverymanager.producer.ShipmentProducer;
import com.shippingcompany.deliverymanager.repository.ShipmentRepository;

@Service
@Transactional
public class ShipmentService {
	
	private ShipmentRepository shipmentRepository;
	
	private AbstractProducer<Shipment> shipmentProducer;
	
	/**
	 * Logger for ShipmentService class
	 * **/
	private static Logger logger = LoggerFactory.getLogger(ShipmentService.class);
	
	/**
	 * This method saves the shipment.
	 * **/
	public void save(Shipment shipment){
		shipmentRepository.save(shipment);
	}
	
	/**
	 * This method returns the shipment specified by the shipment code.
	 * The system must be accessible even  if the database 
	 * isn't running. Thus it will throws a not found exception
	 * and return http status 404 in such scenario. 
	 * @param shipmentCode is the shipment code.
	 * @return the shipment
	 * **/
	@Transactional(readOnly=true)
	public Shipment get(String shipmentCode){
		Shipment shipment = null;
		try {
			shipment = shipmentRepository.findOne(shipmentCode);
		} catch (Exception e) {
			logger.error("An error occurs when trying to find the shipment {}", shipmentCode, e);
			throw new ServiceUnavaliableException("An error occurs when trying to find the shipment");
		}
		if (shipment == null) {
			logger.error("No shipment with shipment code {} was found", shipmentCode);
			throw new NotFoundException();
		}
		return shipment;
	}
	
	public void produce(Shipment shipment){
		try {
			shipmentProducer.produce(shipment);
		} catch (Exception e){
			logger.error("An error occurs when trying produce the shipment {}", shipment.getShipmentCode(), e);
			throw new ServiceUnavaliableException("An error occurs when trying produce the shipment");
		}
	}
	
	@Autowired
	public ShipmentService(ShipmentProducer shipmentProducer, ShipmentRepository shipmentRepository){
		this.shipmentProducer = shipmentProducer;
		this.shipmentRepository = shipmentRepository;
	}
}
