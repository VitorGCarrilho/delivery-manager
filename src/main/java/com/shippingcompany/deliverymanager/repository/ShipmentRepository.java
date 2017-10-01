package com.shippingcompany.deliverymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shippingcompany.deliverymanager.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>{

}
