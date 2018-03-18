package com.shippingcompany.deliverymanager.model;

import java.io.Serializable;
import java.util.Date;

public class ShipmentResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3230951044063405319L;

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
