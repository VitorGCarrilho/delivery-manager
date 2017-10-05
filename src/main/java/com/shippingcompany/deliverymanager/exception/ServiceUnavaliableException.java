package com.shippingcompany.deliverymanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavaliableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7203189395419935146L;

	public ServiceUnavaliableException(){}
	
	public ServiceUnavaliableException(String message){
		super(message);
	}
}
