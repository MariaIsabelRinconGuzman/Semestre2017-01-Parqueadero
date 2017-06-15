package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.VehiculoDTO;

public class VehiculoDAO {

	public void actualizarPropietario(VehiculoDTO vehiculo, Connection connection) throws SQLException {
		String v="UPDATE vehiculo SET propietario_id=? WHERE vehiculo_placa=?";
		PreparedStatement ps2=connection.prepareStatement(v);
		ps2.setInt(1, vehiculo.getPropietario());
        ps2.setString(2, vehiculo.getPlaca());  
        ps2.executeUpdate(); 
	}
	public String consultarTipoVehiculo(String placa, Connection connection) throws Exception{
		String c="SELECT moto_placa FROM vehiculo where vehiculo_placa=?";
		PreparedStatement ps=connection.prepareStatement(c);
		ps.setString(1, placa);
		ResultSet rs=ps.executeQuery();		
		rs.next();
		if(rs.getString("moto_placa")!=null){
			return "moto";			
		}else{
			return "carro";
		}		
	}
	public boolean consultarVehiculo(String placa, Connection connection) throws SQLException {
		String c="SELECT * FROM vehiculo where vehiculo_placa=?";
		PreparedStatement ps=connection.prepareStatement(c);
		ps.setString(1, placa);
		ResultSet rs=ps.executeQuery();		
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
}
