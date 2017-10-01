package com.shippingcompany.deliverymanager.resource;

import static com.shippingcompany.deliverymanager.util.ApiUtils.API;
import static com.shippingcompany.deliverymanager.util.ApiUtils.VERSION_V1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { API + VERSION_V1 + "shipment-status" })
public class ShipmentStatusResource {
	
	@PostMapping("{shipmentCode}")
	public ResponseEntity<?> createStatus(@PathVariable String shipmentCode) {
		return new ResponseEntity(shipmentCode, HttpStatus.CREATED);
	}
}
