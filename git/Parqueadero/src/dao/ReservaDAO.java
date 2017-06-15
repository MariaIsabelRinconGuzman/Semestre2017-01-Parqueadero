package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ReservaDTO;

public class ReservaDAO {

	public boolean reservar(ReservaDTO reserva, Connection connection) throws SQLException {
		try{
		String p = "INSERT INTO reserva (reserva_fecha, vehiculo_placa, reserva_hora)"
				+ " VALUES (?,?,?)" ;
		int index=1;
       	PreparedStatement ps=connection.prepareStatement(p);
       	ps.setString(index++, reserva.getFecha().toString());
       	ps.setString(index++, reserva.getPlaca());
       	ps.setString(index++, reserva.getHora());
    	ps.executeUpdate();	
       	return true;
    		}catch(SQLException e){
    			return false;
    		}
	}
}
