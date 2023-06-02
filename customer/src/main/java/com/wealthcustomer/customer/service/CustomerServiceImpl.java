package com.wealthcustomer.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wealthcustomer.customer.dao.CustomerDao;
import com.wealthcustomer.customer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer saveCustomer(Customer customer) {
		customerDao.save(customer);
		return customer;
	}

	@Override
	public Customer findByEmailAndPwd(String email, String pwd) {
		Customer customer= customerDao.findByEmailAndPwd(email, pwd);
		return customer;
	}
	

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = customerDao.findAll();
		return allCustomers;
	}
	
	public Customer getCustomerById(String email) {
		Optional<Customer> optCustomer = customerDao.findById(email);
		 if(optCustomer.isPresent())
		 {
			return  optCustomer.get();		 
		 } 
		 return null;
		
	}

	@Override
	public Customer updatePassword(Customer customer) {

		Customer oldCustomer = getCustomerById(customer.getEmail());
		oldCustomer.setPwd(customer.getPwd());

		return customerDao.save(oldCustomer);
		
		
	
	}

	@Override
	public String deleteCustomer(Customer customer) {
		Customer found = getCustomerById(customer.getEmail());
//		customerDao.deleteById(customer.getEmail());
		if(found!=null) {
			customerDao.deleteById(customer.getEmail());
			return "1";
		
	}
		return "0";
}
}





