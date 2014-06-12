package com.gfi.training.gwtmvp.shared;

public class Board {
	protected String firstname;
	protected String lastname;
	
	public Board() {
		this("Gavin", "Stewart");
	}
	
	public Board(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public String getFullName() {
		return this.getFirstname() + " " + this.getLastname();
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
