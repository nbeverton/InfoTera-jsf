package com.nbeverton.entity;

import java.util.Objects;

public class Document {
	
	private Integer id;
	private Integer person_id;
	private String nr_document;
	private String tp_document;
	
	
	public Document() {
	}
	
	public Document(Integer id, Integer person_id, String nr_document, String tp_document) {
		super();
		this.id = id;
		this.person_id = person_id;
		this.nr_document = nr_document;
		this.tp_document = tp_document;
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
		Document other = (Document) obj;
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
	public String getNr_document() {
		return nr_document;
	}
	public void setNr_document(String nr_document) {
		this.nr_document = nr_document;
	}
	public String getTp_document() {
		return tp_document;
	}
	public void setTp_document(String tp_document) {
		this.tp_document = tp_document;
	}
}
