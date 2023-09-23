package com.nbeverton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nbeverton.entity.Person;
import com.nbeverton.util.ConnectFactory;
import com.nbeverton.util.ErroSystem;

public class personDAO {
	
	public void save(Person person) throws ErroSystem{
		
			Connection connect = ConnectFactory.getConnect();
			try {
				PreparedStatement ps;
				if (person == null) {
					ps = connect.prepareStatement("INSERT INTO `InfoTeraJSF`.`person` (`nm_person`, `tp_person`, `nm_email`, `nr_telephone`) VALUES (?, ?, ?, ?)");	
				} else {
					ps = connect.prepareStatement("UPDATE person SET nm_person=?, tp_person=?, nm_email=?, nr_telephone=? WHERE id=?");
					ps.setInt(5, person.getId());
				}
				ps.setString(1, person.getName());
				ps.setString(2, person.getType());
				ps.setString(3, person.getEmail());
				ps.setString(4, person.getTelephone());
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
	
	
	public List<Person> search() throws ErroSystem
	{
		
			Connection connect = ConnectFactory.getConnect();
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM person");
			ResultSet resultSet = ps.executeQuery();
			List<Person> personList = new ArrayList<>();
			while(resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setName(resultSet.getString("nm_person"));
				person.setType(resultSet.getString("tp_person"));
				person.setEmail(resultSet.getString("nm_email"));
				person.setTelephone(resultSet.getString("nr_telephone"));
				personList.add(person);
			}
			ConnectFactory.closeConnect();
			return personList;
			
		} catch (SQLException e) {
			throw new ErroSystem("Erro ao buscar info do BD!", e);
		}
	}
	
	}
