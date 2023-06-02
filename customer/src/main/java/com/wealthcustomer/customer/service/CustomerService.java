package com.wealthcustomer.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wealthcustomer.customer.model.Customer;

@Service
public interface CustomerService {
	public Customer saveCustomer(Customer customer);
	public Customer findByEmailAndPwd(String email, String pwd);
	public Customer getCustomerById(String email);
	public List<Customer> getAllCustomers();
	public String deleteCustomer(Customer customer);
	public Customer updatePassword(Customer customer);
}
