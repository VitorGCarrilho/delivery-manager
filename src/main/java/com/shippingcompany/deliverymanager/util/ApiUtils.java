package com.shippingcompany.deliverymanager.util;

import java.util.UUID;

public class ApiUtils {
	public static final String API = "api/";
	public static final String VERSION_V1 = "v1/";
	public static final String SHIPMENT_QUEUE_VARIABLE = "${app.queue.shipment}";
	public static final String SHIPMENT_STATUS_QUEUE_VARIABLE = "${app.queue.shipment.status}";
	
	public static String getUIDCode(){
		return UUID.randomUUID().toString();
	}
}
