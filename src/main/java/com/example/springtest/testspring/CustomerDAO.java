package com.example.springtest.testspring;

import org.springframework.stereotype.Repository;

// Importing the Customers class to use the defined properties in this class

@Repository

// Class to create a list of Customers
public class CustomerDAO {

	private static Customers list = new Customers();

	// This static block is executed before executing the main block
	static {

		// Creating a few Customers and adding them to the list
		list.getAllCustomerList().add(new Customer(
				1,
				"Name1",
				"Dummy1",
				"dummy1@gmail.com"));

		list.getAllCustomerList().add(new Customer(
				2, "Name2",
				"Dummy2",
				"dummy2@gmail.com"));

		list.getAllCustomerList().add(new Customer(
				3, "Name3",
				"Dummy3",
				"dummy3@gmail.com"));
	}

	// Method to return the list
	public Customers getAllCustomers() {
		return list;
	}

	// Method to return the id in the list
	public Customer getCustomerById(int id) {
		return list.getAllCustomerList().get(id-1);
	}

	// Method to delete the id in the list
	public Customer deleteCustomerById(int id) {
		return list.getAllCustomerList().remove(id-1);
	}

	// Method to delete the list
	public void deleteAllCustomers() {
		list.getAllCustomerList().clear();;
	}

	// Method to add an Customer to the Customers list
	public void addCustomer(Customer Customer) {
		list.getAllCustomerList().add(Customer);
	}

	// Method to add an Customer to the Customers list
	public void updateCustomer(Customer Customer, int id) {
		list.getAllCustomerList().set(id, Customer);
	}
}