package com.shippingcompany.deliverymanager.model.enumeration;

public enum ShipmentStatusEnum {
	SENDED("sended"),
	ON_ROAD("On road"),
	ARRIVED("Arrived"),
	EXTRACTED("Extracted")
	;
	
	private final String STATUS;
	
	ShipmentStatusEnum(String status){
		this.STATUS = status;
	}
	
	public String getStatus () {
		return this.STATUS;
	}
}
