package com.shippingcompany.deliverymanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<ShipmentResponse> postShipment(@RequestBody Shipment shipment) {
		ShipmentResponse shipmentResponse = new ShipmentResponse(shipment.getShipmentCode());
		shipmentProducer.produce(shipment);
		return new ResponseEntity<ShipmentResponse>(shipmentResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("{shipmentCode}")
	public ResponseEntity<Shipment> getShipment(@PathVariable String shipmentCode) {
		Shipment shipment = shipmentService.get(shipmentCode);
		return new ResponseEntity<Shipment>(shipment, HttpStatus.OK);
	}
	
}
