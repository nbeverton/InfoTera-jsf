package com.nbeverton.entity;

import java.util.Objects;

public class Adress {
	
	private Integer id;
	private Integer person_id;
	private String nm_adress;
	private String nr_adress;
	private String nm_city;
	private String nm_state;
	private String nm_country;
	
	
	public Adress() {
	}
	
	public Adress(Integer id, Integer person_id, String nm_adress, String nr_adress, String nm_city, String nm_state,
			String nm_country) {
		super();
		this.id = id;
		this.person_id = person_id;
		this.nm_adress = nm_adress;
		this.nr_adress = nr_adress;
		this.nm_city = nm_city;
		this.nm_state = nm_state;
		this.nm_country = nm_country;
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
		Adress other = (Adress) obj;
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
	public String getNm_adress() {
		return nm_adress;
	}
	public void setNm_adress(String nm_adress) {
		this.nm_adress = nm_adress;
	}
	public String getNr_adress() {
		return nr_adress;
	}
	public void setNr_adress(String nr_adress) {
		this.nr_adress = nr_adress;
	}
	public String getNm_city() {
		return nm_city;
	}
	public void setNm_city(String nm_city) {
		this.nm_city = nm_city;
	}
	public String getNm_state() {
		return nm_state;
	}
	public void setNm_state(String nm_state) {
		this.nm_state = nm_state;
	}
	public String getNm_country() {
		return nm_country;
	}
	public void setNm_country(String nm_country) {
		this.nm_country = nm_country;
	}

}
