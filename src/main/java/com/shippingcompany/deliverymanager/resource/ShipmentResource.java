package com.shippingcompany.deliverymanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.model.ShipmentResponse;
import com.shippingcompany.deliverymanager.producer.AbstractProducer;
import com.shippingcompany.deliverymanager.service.ShipmentService;

import static com.shippingcompany.deliverymanager.util.ApiUtils.*;

@RestController
@RequestMapping(value = { API + VERSION_V1 + "shipment" })
public class ShipmentResource {

	@Autowired
	private AbstractProducer<Shipment> shipmentProducer;

	@Autowired
	private ShipmentService shipmentService;

	@PostMapping
	public ResponseEntity<ShipmentResponse> sendMessage(@RequestBody Shipment shipment) {
		String shipmentCode = shipmentService.generateShipmentCode(shipment);
		ShipmentResponse shipmentResponse = new ShipmentResponse(shipmentCode);
		shipmentProducer.produce(shipment);
		return new ResponseEntity<>(shipmentResponse, HttpStatus.CREATED);
	}
}
