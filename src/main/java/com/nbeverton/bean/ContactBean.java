package com.nbeverton.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.nbeverton.dao.ContactDAO;
import com.nbeverton.entity.Contact;
import com.nbeverton.util.ErroSystem;

//@ManagedBean
//@SessionScoped
public class ContactBean {
	
	private Contact contact = new Contact();
	private List<Contact> contactList = new ArrayList<>();
	private ContactDAO contactDao = new ContactDAO();
	
	public void addContact() throws ErroSystem{
		contactList.add(contact);
		contactDao.save(contact);
		contact = new Contact();
	}
	
	public void searchContact() throws ErroSystem{
		contactList = contactDao.search();
	}
	
	public void editContact(Contact c) throws ErroSystem{
		contact = c;
	}
	
	public void deleteContact(Contact c) throws ErroSystem {
		contactDao.delete(c.getId());
	}
	

//	Métodos getters and setters
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public ContactDAO getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}

}
