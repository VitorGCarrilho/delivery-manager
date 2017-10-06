package com.shippingcompany.deliverymanager.service;

import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shippingcompany.deliverymanager.exception.ServiceUnavaliableException;
import com.shippingcompany.deliverymanager.model.ShipmentStatus;
import com.shippingcompany.deliverymanager.producer.AbstractProducer;
import com.shippingcompany.deliverymanager.repository.ShipmentStatusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentStatusServiceTests {
	
	@MockBean
	private ShipmentStatusRepository shipmentStatusRepository;
	
	@MockBean
	private AbstractProducer<ShipmentStatus> shipmentStatusProducer;
	
	private ShipmentStatusService shipmentStatusService;
	
	@Test(expected = ServiceUnavaliableException.class) 
	public void produceServiceUnavaliableWhenShipmentStatusProducerError() {
		Mockito.doThrow(Exception.class).when(shipmentStatusProducer).produce(any());
		shipmentStatusService = new ShipmentStatusService(shipmentStatusRepository, shipmentStatusProducer);
		shipmentStatusService.produce(new ShipmentStatus());
	}
	
}
