package com.shippingcompany.deliverymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shippingcompany.deliverymanager.model.ShipmentStatus;

public interface ShipmentStatusRepository extends JpaRepository<ShipmentStatus, String>{

}
