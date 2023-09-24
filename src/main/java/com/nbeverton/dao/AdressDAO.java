package com.nbeverton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nbeverton.entity.Adress;
import com.nbeverton.util.ConnectFactory;
import com.nbeverton.util.ErroSystem;

public class AdressDAO {
	
	public void saveAdress(Adress adress) throws ErroSystem{
		
		Connection connect = ConnectFactory.getConnect();
		try {
			PreparedStatement ps;
			if (adress == null) {
				ps = connect.prepareStatement("INSERT INTO `InfoTeraJSF`.`adress` (`person_id`, `nm_adress`, `nr_adress`, `nm_city`, `nm_state`, `nm_country`) VALUES (?, ?, ?, ?, ?, ?)");	
			} else {
				
//				Continuar daqui!!!!!
				ps = connect.prepareStatement("UPDATE adress SET person_id=?, nm_adress=?, nr_adress=?, nm_city=?, nm_state=?, nm_country=? WHERE id=?");
				ps.setInt(7, adress.getId());
			}
			ps.setInt(1, adress.getPerson_id());
			ps.setString(2, adress.getNm_adress());
			ps.setString(3, adress.getNr_adress());
			ps.setString(4, adress.getNm_city());
			ps.setString(4, adress.getNm_state());
			ps.setString(4, adress.getNm_country());
			ps.execute();
		} catch (SQLException e) {
			throw new ErroSystem("Erro ao tentar salvar!", e);
		}
		ConnectFactory.closeConnect();
	}

public void deleteAdress(Integer id) throws ErroSystem{
	Connection connect = ConnectFactory.getConnect();
	try {
		PreparedStatement ps = connect.prepareStatement("DELETE FROM person WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
	} catch (SQLException e) {
		throw new ErroSystem("Erro ao deletar info do BD!", e);
	}
}


public List<Adress> searchAdress() throws ErroSystem
{
	
		Connection connect = ConnectFactory.getConnect();
	try {
		PreparedStatement ps = connect.prepareStatement("SELECT * FROM adress");
		ResultSet resultSet = ps.executeQuery();
		List<Adress> adressList = new ArrayList<>();
		while(resultSet.next()) {
			Adress adress = new Adress();
			adress.setId(resultSet.getInt("id"));
			adress.setPerson_id(resultSet.getInt("person_id"));
			adress.setNm_adress(resultSet.getString("nm_adress"));
			adress.setNr_adress(resultSet.getString("nr_adress"));
			adress.setNm_city(resultSet.getString("nm_city"));
			adress.setNm_state(resultSet.getString("nm_state"));
			adress.setNm_country(resultSet.getString("nm_country"));
			adressList.add(adress);
		}
		ConnectFactory.closeConnect();
		return adressList;
		
	} catch (SQLException e) {
		throw new ErroSystem("Erro ao buscar info do BD!", e);
	}
}

}
