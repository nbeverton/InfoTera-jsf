package com.nbeverton.entity;

import java.util.Objects;

public class Person {
	
	private Integer id;
	private String name;
	private String type;
	private String email;
	private String telephone;
	
	
	public Person(Integer id, String name, String type, String email, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.email = email;
		this.telephone = telephone;
	}
	
	public Person() {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
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
