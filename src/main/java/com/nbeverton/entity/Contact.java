package com.nbeverton.entity;

import java.util.Objects;

public class Contact {
	
	private Integer id;
	private Integer person_id;
	private String nm_contact;
	private String nr_telephone;
	private String nm_email;
	
	
	public Contact() {
		
	}
	
	public Contact(Integer id, Integer person_id, String nm_contact, String nr_telephone, String nm_email) {
		super();
		this.id = id;
		this.person_id = person_id;
		this.nm_contact = nm_contact;
		this.nr_telephone = nr_telephone;
		this.nm_email = nm_email;
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
		Contact other = (Contact) obj;
		return Objects.equals(id, other.id);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPerson_id() {
		return person_id;
	}
	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}
	public String getNm_contact() {
		return nm_contact;
	}
	public void setNm_contact(String nm_contact) {
		this.nm_contact = nm_contact;
	}
	public String getNr_telephone() {
		return nr_telephone;
	}
	public void setNr_telephon(String nr_telephone) {
		this.nr_telephone = nr_telephone;
	}
	public String getNm_email() {
		return nm_email;
	}
	public void setNm_email(String nm_email) {
		this.nm_email = nm_email;
	}
}
