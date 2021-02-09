package com.mindtree.PassportManagement.Entity;

public class Passport
{

	private String id;
	private int passNumber;
	
	private Person person;
	
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Passport(String id, int passNumber, Person person) {
		super();
		this.id = id;
		this.passNumber = passNumber;
		this.setPerson(person);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassNumber() {
		return passNumber;
	}
	public void setPassNumber(int passNumber) {
		this.passNumber = passNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
