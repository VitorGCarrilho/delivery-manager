package com.shippingcompany.deliverymanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Shipment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2063943198563463792L;

	@Id
	private String shipmentCode;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date shipmentDate;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date expectedDeliveryDate;

	public String getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(String id) {
		this.shipmentCode = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
