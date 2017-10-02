package com.shippingcompany.deliverymanager.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class QueueConfiguration {
	
    @Bean("shipmentQueue")
    public Queue shipmentQueue(@Value("${app.queue.shipment}") String shipmentQueue) {
        return new ActiveMQQueue(shipmentQueue);
    }
    
    @Bean("shipmentStatusQueue")
    public Queue shipmentStatusQueue(@Value("${app.queue.shipment.status}") String shipmentStatusQueue) {
        return new ActiveMQQueue(shipmentStatusQueue);
    }
}
