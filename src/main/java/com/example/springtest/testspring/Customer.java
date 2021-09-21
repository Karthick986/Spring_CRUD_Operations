package com.example.springtest.testspring;

// Creating an entity Customer
public class Customer {

	public Customer() {}

	// Parameterized Constructor to assign the values to the properties of the entity
	public Customer(Integer id, String firstName, String lastName, String mobile) {
		super();

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
	}

	 private Integer id;
	 private String firstName;
	 private String lastName;
	 private String mobile;

	// Overriding the toString method to find all the values
	@Override
 	public String toString() {
		return "Customer [id="+ id + 
		", firstName="+ firstName + 
		", lastName="+ lastName + 
		", mobile="+ mobile + "]";
	}

	// Getters and setters of the properties
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}