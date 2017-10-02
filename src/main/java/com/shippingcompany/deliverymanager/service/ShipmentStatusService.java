package com.shippingcompany.deliverymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shippingcompany.deliverymanager.model.ShipmentStatus;
import com.shippingcompany.deliverymanager.repository.ShipmentStatusRepository;

@Service
public class ShipmentStatusService {
	@Autowired
	private ShipmentStatusRepository shipmentStatusRepository;
	
	public void save(ShipmentStatus shipmentStatus){
		shipmentStatusRepository.save(shipmentStatus);
	}
}
