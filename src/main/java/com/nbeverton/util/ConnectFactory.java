package com.nbeverton.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {
	
	private static Connection connect;
	public static final String URL_CONNECT = "jdbc:mysql://localhost/InfoTeraJSF";
	public static final String USER = "root";
	public static final String PASSWORD = "12345678";
	
	

	public static Connection getConnect() throws ErroSystem{
			if(connect == null) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						connect = DriverManager.getConnection(URL_CONNECT, USER, PASSWORD);
					} catch (SQLException e) {
						throw new ErroSystem("Não foi possível conectar ao BD!", e);
					} catch (ClassNotFoundException e) {
						throw new ErroSystem("O driver do BD não foi encontrado!", e);
					}
			}
		
		return connect;
	}
	
	public static void closeConnect() throws ErroSystem{
		if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					throw new ErroSystem("Erro ao fechar conexão com o BD!", e);
				}
				connect = null;
			connect = null;
		}
	}
	
	
}
