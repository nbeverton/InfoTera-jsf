package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nbeverton.entity.Person;
import com.nbeverton.util.Connect;

public class personDAO {
	
	public void save(Person person) {
		Connection connect = Connect.getConnect();
		try {
			PreparedStatement ps = connect.prepareCall("INSERT INTO `InfoTeraJSF`.`person` (`nm_person`, `tp_person`, `nm_email`, `nr_telephone`) VALUES (?, ?, ?, ?)");
			ps.setString(1, person.getName());
			ps.setString(2, person.getType());
			ps.setString(3, person.getEmail());
			ps.setString(4, person.getTelephone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
