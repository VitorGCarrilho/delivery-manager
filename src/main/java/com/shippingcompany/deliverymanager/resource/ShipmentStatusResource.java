package com.shippingcompany.deliverymanager.resource;

import static com.shippingcompany.deliverymanager.util.ApiUtils.API;
import static com.shippingcompany.deliverymanager.util.ApiUtils.VERSION_V1;

import javax.validation.Valid;

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
import com.shippingcompany.deliverymanager.model.ShipmentStatusResponse;
import com.shippingcompany.deliverymanager.service.ShipmentStatusService;

@RestController
@RequestMapping(value = { API + VERSION_V1 + "shipment-status" })
public class ShipmentStatusResource {
	
	@Autowired
	private ShipmentStatusService shipmentStatusService;

	@PostMapping("{shipmentCode}")
	public ResponseEntity<ShipmentStatusResponse> createStatus(@PathVariable String shipmentCode,
			@Valid @RequestBody ShipmentStatus shipmentStatus) {
		shipmentStatus.setShipment(new Shipment(shipmentCode));
		shipmentStatusService.produce(shipmentStatus);
		return new ResponseEntity<ShipmentStatusResponse>(
				new ShipmentStatusResponse(shipmentCode, shipmentStatus.getShipmentStatusCode()), HttpStatus.CREATED);
	}
}
