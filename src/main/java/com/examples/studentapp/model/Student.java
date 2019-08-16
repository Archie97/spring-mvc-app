package com.examples.studentapp.model;

public class Student {
	Integer id;

	String name;
	Integer section;
	String fatherName;
	String email;

	String address;

	public boolean isNew() {
		return (this.id == null);
	}
	
	public Integer getId() {
		return id;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public Integer getSection() {
		return section;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName=fatherName;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
