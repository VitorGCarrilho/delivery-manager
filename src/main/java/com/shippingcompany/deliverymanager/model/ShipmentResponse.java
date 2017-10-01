package com.shippingcompany.deliverymanager.model;

import java.util.Date;

public class ShipmentResponse {
	
	private String shipmentCode;
	
	private Date requestDate;

	public ShipmentResponse(String shipmentCode){
		this.shipmentCode = shipmentCode;
		this.requestDate = new Date();
	}
	
	public String getShipmentCode() {
		return shipmentCode;
	}

	public Date getRequestDate() {
		return requestDate;
	}
}
