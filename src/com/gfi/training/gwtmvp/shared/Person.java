package com.gfi.training.gwtmvp.shared;

public class Person {
	protected String firstname;
	protected String lastname;
	
	public Person() {
		this("Gavin", "Stewart");
	}
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public String getFullName() {
		return this.firstname + " " + this.lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
