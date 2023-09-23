package com.nbeverton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nbeverton.entity.Contact;
import com.nbeverton.util.ConnectFactory;
import com.nbeverton.util.ErroSystem;

public class ContactDAO {
	
	public void save(Contact contact) throws ErroSystem{
	Connection connect = ConnectFactory.getConnect();
	try {
		PreparedStatement ps;
		if (contact == null) {
			ps = connect.prepareStatement("INSERT INTO `InfoTeraJSF`.`contact` (`person_id`, `nm_contact`, `nr_telephone`, `nm_email`) VALUES (?, ?, ?, ?)");	
		} else {
			ps = connect.prepareStatement("UPDATE contact SET person_id=?, nm_contact=?, nr_telephone=?, nm_email=? WHERE id=?");
			ps.setInt(5, contact.getId());
		}
		ps.setInt(1, contact.getPerson_id());
		ps.setString(2, contact.getNm_contact());
		ps.setString(3, contact.getNr_telephone());
		ps.setString(4, contact.getNm_email());
		ps.execute();
	} catch (SQLException e) {
		throw new ErroSystem("Erro ao tentar salvar!", e);
	}
	ConnectFactory.closeConnect();
}

	public void delete(Integer id) throws ErroSystem{
	Connection connect = ConnectFactory.getConnect();
	try {
		PreparedStatement ps = connect.prepareStatement("DELETE FROM person WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
	} catch (SQLException e) {
		throw new ErroSystem("Erro ao deletar info do BD!", e);
	}
	}

	
	public List<Contact> search() throws ErroSystem
	{
	
		Connection connect = ConnectFactory.getConnect();
	try {
		PreparedStatement ps = connect.prepareStatement("SELECT * FROM contact");
		ResultSet resultSet = ps.executeQuery();
		List<Contact> contactList = new ArrayList<>();
		while(resultSet.next()) {
			Contact contact = new Contact();
			contact.setId(resultSet.getInt("id"));
			contact.setPerson_id(resultSet.getInt("person_id"));
			contact.setNm_contact(resultSet.getString("nm_contact"));
			contact.setNr_telephon(resultSet.getString("nr_telephone"));
			contact.setNm_email(resultSet.getString("nm_email"));
			contactList.add(contact);
		}
		ConnectFactory.closeConnect();
		return contactList;
		
	} catch (SQLException e) {
		throw new ErroSystem("Erro ao buscar info do BD!", e);
	}
	}
	
	}
