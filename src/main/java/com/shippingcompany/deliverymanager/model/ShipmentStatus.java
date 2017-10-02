package com.shippingcompany.deliverymanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShipmentStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -457566861209258430L;

	@Id
	private String shipmentStatusCode;
	
	private String shipmentStatus;
	
	private Date statusChangeDate;

	public String getShipmentStatusCode() {
		return shipmentStatusCode;
	}

	public void setShipmentStatusCode(String shipmentStatusCode) {
		this.shipmentStatusCode = shipmentStatusCode;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public Date getStatusChangeDate() {
		return statusChangeDate;
	}

	public void setStatusChangeDate(Date statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}	
}
