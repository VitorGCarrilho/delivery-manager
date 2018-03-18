package com.shippingcompany.deliverymanager.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shippingcompany.deliverymanager.exception.ServiceUnavaliableException;
import com.shippingcompany.deliverymanager.exception.NotFoundException;
import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.producer.ShipmentProducer;
import com.shippingcompany.deliverymanager.repository.ShipmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentServiceTests {
		
	@MockBean
	private ShipmentProducer shipmentProducer;
	
	@MockBean
	private ShipmentRepository shipmentRepository;
	
	private ShipmentService shipmentService;
	
	@Test(expected = ServiceUnavaliableException.class) 
	public void produceServiceUnavaliableWhenShipmentProducerError() {
		Mockito.doThrow(Exception.class).when(shipmentProducer).produce(any());
		shipmentService = new ShipmentService(shipmentProducer, shipmentRepository);
		shipmentService.produce(new Shipment());
	}
	
	@Test(expected = NotFoundException.class) 
	public void produceNotFoundWhenSearchNonexistentShipment(){
		Mockito.doReturn(null).when(shipmentRepository).findOne(anyString());
		shipmentService = new ShipmentService(shipmentProducer, shipmentRepository);
		shipmentService.get("code");
	}

}
