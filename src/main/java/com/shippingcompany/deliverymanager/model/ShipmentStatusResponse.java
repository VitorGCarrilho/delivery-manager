package com.shippingcompany.deliverymanager.model;

import java.io.Serializable;
import java.util.Date;

public class ShipmentStatusResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7349687290441262997L;

	private String shipmentCode;
	
	private String shipmentStatusCode;
	
	private Date requestDate;

	public ShipmentStatusResponse(String shipmentCode, String shipmentStatusCode){
		this.shipmentCode = shipmentCode;
		this.shipmentStatusCode = shipmentStatusCode;
		this.requestDate = new Date();
	}
	
	public String getShipmentCode() {
		return shipmentCode;
	}

	public String getShipmentStatusCode() {
		return shipmentStatusCode;
	}

	public Date getRequestDate() {
		return requestDate;
	}
}
