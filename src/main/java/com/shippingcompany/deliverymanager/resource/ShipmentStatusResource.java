package com.shippingcompany.deliverymanager.resource;

import static com.shippingcompany.deliverymanager.util.ApiUtils.API;
import static com.shippingcompany.deliverymanager.util.ApiUtils.VERSION_V1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.model.ShipmentStatus;
import com.shippingcompany.deliverymanager.producer.AbstractProducer;

@RestController
@RequestMapping(value = { API + VERSION_V1 + "shipment-status" })
public class ShipmentStatusResource {
	
	@Autowired
	private AbstractProducer<ShipmentStatus> shipmentStatusProducer;
	
	@PostMapping("{shipmentCode}")
	public ResponseEntity<?> createStatus(@PathVariable String shipmentCode, @RequestBody ShipmentStatus shipmentStatus) {
		shipmentStatus.setShipment(new Shipment(shipmentCode));
		shipmentStatusProducer.produce(shipmentStatus);
		return new ResponseEntity(shipmentCode, HttpStatus.CREATED);
	}
}
