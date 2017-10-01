package com.shippingcompany.deliverymanager;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import static com.shippingcompany.deliverymanager.util.ApiUtils.SHIPMENT_QUEUE_VARIABLE;
import static com.shippingcompany.deliverymanager.util.ApiUtils.SHIPMENT_STATUS_QUEUE_VARIABLE;

@SpringBootApplication
@EnableJms
public class DeliveryManagerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DeliveryManagerApplication.class, args);
	}
	
    @Bean
    public Queue shipmentQueue(@Value(SHIPMENT_QUEUE_VARIABLE) String shipmentQueue) {
        return new ActiveMQQueue(shipmentQueue);
    }
    
    @Bean
    public Queue shipmentStatusQueue(@Value(SHIPMENT_STATUS_QUEUE_VARIABLE) String shipmentStatusQueue) {
        return new ActiveMQQueue(shipmentStatusQueue);
    }
}
