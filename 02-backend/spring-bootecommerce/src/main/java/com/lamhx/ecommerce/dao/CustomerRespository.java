package com.lamhx.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lamhx.ecommerce.entity.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Long>{

	Customer findByEmail(String theEmail);
}
