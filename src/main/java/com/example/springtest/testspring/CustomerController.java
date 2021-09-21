package com.example.springtest.testspring;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Import the above-defined classes to use the properties of those classes

// Creating the REST controller
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
 	private CustomerDAO CustomerDao;
	 
// Implementing a GET method to get the list of all the Customers
 	@GetMapping(
	path = "/",
	produces = "application/json")

	public Customers getCustomers() {
		return CustomerDao.getAllCustomers();
	}

	@GetMapping(
	path = "/{id}",
	produces = "application/json")

	public Customer getCustomerById(@PathVariable("id") Integer id) {
		return CustomerDao.getCustomerById(id);
	}

	@PostMapping(
	path = "/delete",
	produces = "application/json")

	public Customer deleteCustomerById(@RequestParam("id") Integer id) {
		return CustomerDao.deleteCustomerById(id);
	}

	@PostMapping(
	path = "/deleteAll",
	produces = "application/json")

	public void deleteAllCustomers() {
		CustomerDao.deleteAllCustomers();
	}

	@PutMapping(
	path = "/update",
	consumes = "application/json",
	produces = "application/json")

	public ResponseEntity<Object> updateCustomer(@RequestBody Customer Customer, @RequestParam("id") Integer id) {
	
			CustomerDao.updateCustomer(Customer, id-1);
	
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
						Customer.getId()).toUri();
	
			   return ResponseEntity.created(location).build();
	}

// Create a POST method to add an Customer to the list
 	@PostMapping(
	path = "/add",
	consumes = "application/json",
	produces = "application/json")

	public ResponseEntity<Object> addCustomer(@RequestBody Customer Customer) {

	// Creating an ID of an Customer from the number of Customers
		Integer id = CustomerDao.getAllCustomers().getAllCustomerList().size() +1;

		Customer.setId(id);

		CustomerDao.addCustomer(Customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
					Customer.getId()).toUri();

		   return ResponseEntity.created(location).build();
	}
}