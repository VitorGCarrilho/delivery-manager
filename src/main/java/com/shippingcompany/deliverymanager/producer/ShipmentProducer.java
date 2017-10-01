package com.shippingcompany.deliverymanager.producer;
import javax.annotation.Resource;
import javax.jms.Queue;

import org.springframework.stereotype.Component;

import com.shippingcompany.deliverymanager.model.Shipment;
import static com.shippingcompany.deliverymanager.util.ApiUtils.SHIPMENT_QUEUE_VARIABLE;
 
@Component
public class ShipmentProducer extends AbstractProducer<Shipment> { 
	
	@Resource(name = SHIPMENT_QUEUE_VARIABLE)
    protected Queue queue;  
	
    public void produce(Shipment shipment) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, shipment);
    }
}