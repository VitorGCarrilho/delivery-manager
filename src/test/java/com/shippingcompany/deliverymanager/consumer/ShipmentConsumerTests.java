package com.shippingcompany.deliverymanager.consumer;

import static org.mockito.Matchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shippingcompany.deliverymanager.model.ShipmentStatus;
import com.shippingcompany.deliverymanager.service.ShipmentStatusService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentConsumerTests {
	
	@MockBean
	private ShipmentStatusService shipmentStatusService;
	
	private ShipmentStatusConsumer shipmentStatusConsumer;
	
	@Test(expected = Exception.class)
	public void produceErrorWhenTryingSaveShipment(){
		Mockito.doThrow(Exception.class).when(shipmentStatusService).save(any());
		shipmentStatusConsumer.consume(new ShipmentStatus());
	}

}
