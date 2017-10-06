package com.shippingcompany.deliverymanager.consumer;

import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shippingcompany.deliverymanager.model.Shipment;
import com.shippingcompany.deliverymanager.service.ShipmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentStatusConsumerTests {
	
	@MockBean
	private ShipmentService shipmentService;
	
	private ShipmentConsumer shipmentConsumer;
	
	@Test(expected = Exception.class)
	public void produceErrorWhenTryingSaveShipment(){
		Mockito.doThrow(Exception.class).when(shipmentService).save(any());
		shipmentConsumer.consume(new Shipment());
	}

}
