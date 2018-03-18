package com.shippingcompany.deliverymanager.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
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
    	Queue queue = new ActiveMQQueue(shipmentQueue);
        return queue;
    }
    
    @Bean("shipmentStatusQueue")
    public Queue shipmentStatusQueue(@Value("${app.queue.shipment.status}") String shipmentStatusQueue) {
        return new ActiveMQQueue(shipmentStatusQueue);
    }
    
    
    @Bean
    public ConnectionFactory getActiveMQConnectionFactory() {
        // Configure the ActiveMQConnectionFactory
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://0.0.0.0:61616");
        activeMQConnectionFactory.setUserName("admin");
        activeMQConnectionFactory.setPassword("admin");
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.shippingcompany.deliverymanager.model","java.util"));

        // Configure the redeliver policy and the dead letter queue
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setInitialRedeliveryDelay(0);
        redeliveryPolicy.setRedeliveryDelay(60000);
        redeliveryPolicy.setUseExponentialBackOff(true);
        redeliveryPolicy.setMaximumRedeliveries(-1);
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);

        return activeMQConnectionFactory;
    }
}
