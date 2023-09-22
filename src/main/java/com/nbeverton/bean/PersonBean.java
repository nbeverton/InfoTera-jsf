package com.nbeverton.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.nbeverton.dao.personDAO;
import com.nbeverton.entity.Person;
import com.nbeverton.util.ErroSystem;

@ManagedBean
@SessionScoped
public class PersonBean {
	
	
	private Person person = new Person();
	private List<Person> personList = new ArrayList<>();
	private personDAO personDao = new personDAO();
	
	public void addPerson() throws ErroSystem{
		personList.add(person);
		personDao.save(person);
		person = new Person();
	}
	
	public void search() throws ErroSystem{
		personList = personDao.search();
	}
	
	public void edit(Person p) throws ErroSystem{
		person = p;
	}
	
	public void delete(Person p) throws ErroSystem {
		personDao.delete(p.getId());
	}
	
	

//	Métodos getters and setters
	
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
