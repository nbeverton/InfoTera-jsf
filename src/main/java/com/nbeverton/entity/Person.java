package com.nbeverton.entity;

public class Person {
	
	private int id;
	private String name;
	private String type;
	private String email;
	private String telephone;
	
	
	public Person(String name, String type, String email, String telephone) {
		super();
		this.name = name;
		this.type = type;
		this.email = email;
		this.telephone = telephone;
	}
	
	public Person() {
		
	}
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

	
}
