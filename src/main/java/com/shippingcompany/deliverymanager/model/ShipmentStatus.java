package com.shippingcompany.deliverymanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shippingcompany.deliverymanager.model.enumeration.ShipmentStatusEnum;
import com.shippingcompany.deliverymanager.util.ApiUtils;

@Entity
public class ShipmentStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -457566861209258430L;

	@Id
	private String shipmentStatusCode;
	
	@NotNull
	@Column(nullable = false)
	private ShipmentStatusEnum shipmentStatus;
	
	private Date statusChangeDate;
	
	@NotNull
	@Size(max=64)
	private String city;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="shipment_code")
	private Shipment shipment; 
	
	public ShipmentStatus() {
		this.shipmentStatusCode = ApiUtils.getUIDCode();
	}

	public String getShipmentStatusCode() {
		return shipmentStatusCode;
	}

	public ShipmentStatusEnum getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatusEnum shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public Date getStatusChangeDate() {
		return statusChangeDate;
	}

	public void setStatusChangeDate(Date statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
