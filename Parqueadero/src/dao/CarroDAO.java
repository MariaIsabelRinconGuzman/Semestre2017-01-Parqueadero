package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.CarroDTO;


public class CarroDAO {
	public void insertar(CarroDTO carro, Connection connection) throws SQLException{
		String p = "INSERT INTO carro (carro_placa, carro_modelo, carro_combustible, carro_tipo, carro_marca)"
				+ " VALUES (?,?,?,?,?)" ;
		PreparedStatement sentencia1=null;
		int rss=0;	
		
       	sentencia1=connection.prepareStatement(p);
       	sentencia1.setString(1, carro.getPlaca());
       	sentencia1.setString(2, carro.getModelo());
       	sentencia1.setString(3, carro.getCombustible());
       	sentencia1.setString(4, carro.getTipo());
       	sentencia1.setString(5, carro.getMarca());
    	rss=sentencia1.executeUpdate();	
    	
	}

}
