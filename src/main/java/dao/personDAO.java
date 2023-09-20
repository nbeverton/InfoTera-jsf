package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nbeverton.entity.Person;
import com.nbeverton.util.Connect;

public class personDAO {
	
	public void save(Person person) {
		
		try {
			Connection connect = Connect.getConnect();
			PreparedStatement ps = connect.prepareCall("INSERT INTO `InfoTeraJSF`.`person` (`nm_person`, `tp_person`, `nm_email`, `nr_telephone`) VALUES (?, ?, ?, ?)");
			ps.setString(1, person.getName());
			ps.setString(2, person.getType());
			ps.setString(3, person.getEmail());
			ps.setString(4, person.getTelephone());
			ps.execute();
			Connect.closeConnect();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(personDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
