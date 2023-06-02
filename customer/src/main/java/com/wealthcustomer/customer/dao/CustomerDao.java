package com.wealthcustomer.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wealthcustomer.customer.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String>{

	public Customer findByEmailAndPwd(String email, String pwd);
}
