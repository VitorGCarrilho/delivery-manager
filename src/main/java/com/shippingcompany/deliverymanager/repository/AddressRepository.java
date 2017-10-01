package com.shippingcompany.deliverymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shippingcompany.deliverymanager.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
