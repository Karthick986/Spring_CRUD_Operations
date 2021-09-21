package com.example.springtest.testspring;

import java.util.ArrayList;
import java.util.List;

// Class to store the list of all the Customers in an Array List
public class Customers {

	private List<Customer> CustomerList;

	// Method to return the list of Customers
	public List<Customer> getAllCustomerList() {

		if (CustomerList == null) {
			CustomerList = new ArrayList<>();
		}

		return CustomerList;
	}

	public void setCustomerList(List<Customer> CustomerList) {
		this.CustomerList = CustomerList;
	}
}