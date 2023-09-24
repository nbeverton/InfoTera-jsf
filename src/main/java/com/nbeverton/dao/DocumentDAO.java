package com.nbeverton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nbeverton.entity.Document;
import com.nbeverton.util.ConnectFactory;
import com.nbeverton.util.ErroSystem;

public class DocumentDAO {
	
	public void save(Document document) throws ErroSystem{
		
		Connection connect = ConnectFactory.getConnect();
		try {
			PreparedStatement ps;
			if (document == null) {
				ps = connect.prepareStatement("INSERT INTO `InfoTeraJSF`.`document` (`person_id`, `nr_document`, `tp_document`) VALUES (?, ?, ?)");	
			} else {
				ps = connect.prepareStatement("UPDATE document SET person_id=?, nr_document=?, tp_document=?, WHERE id=?");
				ps.setInt(4, document.getId());
			}
			ps.setInt(1, document.getPerson_id());
			ps.setString(2, document.getNr_document());
			ps.setString(3, document.getTp_document());
			ps.execute();
		} catch (SQLException e) {
			throw new ErroSystem("Erro ao tentar salvar!", e);
		}
		ConnectFactory.closeConnect();
	}

public void delete(Integer id) throws ErroSystem{
	Connection connect = ConnectFactory.getConnect();
	try {
		PreparedStatement ps = connect.prepareStatement("DELETE FROM document WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
	} catch (SQLException e) {
		throw new ErroSystem("Erro ao deletar info do BD!", e);
	}
}


public List<Document> search() throws ErroSystem
{
	
		Connection connect = ConnectFactory.getConnect();
	try {
		PreparedStatement ps = connect.prepareStatement("SELECT * FROM document");
		ResultSet resultSet = ps.executeQuery();
		List<Document> personList = new ArrayList<>();
		while(resultSet.next()) {
			Document document = new Document();
			document.setId(resultSet.getInt("id"));
			document.setPerson_id(resultSet.getInt("person_id"));
			document.setNr_document(resultSet.getString("nr_document"));
			document.setTp_document(resultSet.getString("tp_document"));
			personList.add(document);
		}
		ConnectFactory.closeConnect();
		return personList;
		
	} catch (SQLException e) {
		throw new ErroSystem("Erro ao buscar info do BD!", e);
	}
}

}
