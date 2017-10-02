package com.shippingcompany.deliverymanager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.shippingcompany.deliverymanager.util.ApiUtils;


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
	
	@OneToMany(mappedBy = "shipment")
	private List<ShipmentStatus> shipmentStatus;
	
	public Shipment() {
		this.shipmentCode = ApiUtils.getUIDCode();
	}
	
	public Shipment(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public String getShipmentCode() {
		return shipmentCode;
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

	public List<ShipmentStatus> getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(List<ShipmentStatus> shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
}
