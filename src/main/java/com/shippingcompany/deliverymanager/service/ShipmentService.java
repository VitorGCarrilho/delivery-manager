package com.shippingcompany.deliverymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.repository.ShipmentRepository;

@Service
public class ShipmentService {
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	public void save(Shipment shipment){
		shipmentRepository.save(shipment);
	}
	
	public Shipment get(String shipmentCode){
		return shipmentRepository.findOne(shipmentCode);
	}
}
