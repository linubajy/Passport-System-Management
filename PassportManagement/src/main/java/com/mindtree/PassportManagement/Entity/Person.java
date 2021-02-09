package com.mindtree.PassportManagement.Entity;

public class Person {

	private String pid;
	private String name;
	private String birthplace;
	private int age;

	private Passport passport;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String pid, String name, String birthplace, int age) {
		super();
		this.pid = pid;
		this.name = name;
		this.birthplace = birthplace;
		this.age = age;
		
	}

	public String getpid() {
		return pid;
	}

	public void setpid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
