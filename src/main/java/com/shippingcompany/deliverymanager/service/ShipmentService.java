package com.shippingcompany.deliverymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shippingcompany.deliverymanager.exception.NotFoundException;
import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.repository.ShipmentRepository;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
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
	public Shipment get(String shipmentCode){
		Shipment shipment = null;
		try {
			shipment = shipmentRepository.findOne(shipmentCode);
		} catch (Exception e) {
			throw new NotFoundException();
		}
		return shipment;
	}
}
