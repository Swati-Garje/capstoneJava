package com.wealthcustomer.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wealthcustomer.customer.model.Customer;
import com.wealthcustomer.customer.service.CustomerService;

@CrossOrigin
@RequestMapping("user")
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/signup")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> allCustomers = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Customer> getCustomer(@RequestBody Customer customer) {
		Customer findCustomer = customerService.findByEmailAndPwd(customer.getEmail(), customer.getPwd());
		return new ResponseEntity<Customer>(findCustomer,HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updatePassword(@RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updatePassword(customer);
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer)
	{
		String status=customerService.deleteCustomer(customer);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
}








