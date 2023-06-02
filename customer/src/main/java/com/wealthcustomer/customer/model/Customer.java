package com.wealthcustomer.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
		private String uname;
		private String pwd;
		private String panNo;
		@Id
		private String email;
		private String location;
//		Asset asset;
	
}
