package com.nbeverton.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.nbeverton.entity.Person;

@ManagedBean
@SessionScoped
public class PersonBean {
	
	
	private Person person = new Person();
	private List<Person> personList = new ArrayList<>();
	
	public void addPerson() {
		personList.add(person);
//		new personDAO().save(person);
		person = new Person();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

}
