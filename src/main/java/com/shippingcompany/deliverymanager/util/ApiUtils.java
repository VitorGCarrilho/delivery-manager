package com.shippingcompany.deliverymanager.util;

import java.util.UUID;

public class ApiUtils {
	public static final String API = "api/";
	public static final String VERSION_V1 = "v1/";
	
	public static String getUIDCode(){
		return UUID.randomUUID().toString();
	}
}
