package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
	private static Connection con;
	public Connection obtenerConexion() throws Exception {		
		String driver ="com.mysql.jdbc.Driver";
		String connection = "jdbc:mysql://127.0.0.1:3306/parqueadero";
		String user = "root";
		String password = "root";
		Class.forName(driver);
		con = DriverManager.getConnection(connection, user, password);
		return con;
	}	
}

