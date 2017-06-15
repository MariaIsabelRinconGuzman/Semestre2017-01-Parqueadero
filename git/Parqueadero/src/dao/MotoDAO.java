package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.MotoDTO;

public class MotoDAO {

	public boolean insertar(MotoDTO moto, Connection connection) throws SQLException {
		try{
			String p = "INSERT INTO moto (moto_placa, moto_modelo, moto_combustible, moto_cilindraje, moto_marca)"
					+ " VALUES (?,?,?,?,?)";
			int index=1;
	       	PreparedStatement ps1=connection.prepareStatement(p);
	       	ps1.setString(index++, moto.getPlaca());
	       	ps1.setInt(index++, moto.getModelo());
	       	ps1.setString(index++, moto.getCombustible());
	       	ps1.setString(index++, moto.getCilindraje());
	       	ps1.setString(index++, moto.getMarca());
	    	ps1.executeUpdate();	    
	    	
	    	String v= "INSERT INTO vehiculo (vehiculo_placa, moto_placa, propietario_id)"
					+ " VALUES (?,?,?)";
	    	int inde=1;
	    	PreparedStatement ps2=connection.prepareStatement(v);
	       	ps2.setString(inde++, moto.getPlaca());
	       	ps2.setString(inde++, moto.getPlaca());
	       	ps2.setInt(inde++, moto.getPropietario());
	       	ps2.executeUpdate();
	       	return true;
		}catch(SQLException e){
			return false;
		}
		
	}
}
