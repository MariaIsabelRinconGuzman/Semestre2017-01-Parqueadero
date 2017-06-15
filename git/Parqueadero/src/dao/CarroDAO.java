package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.CarroDTO;


public class CarroDAO {
	public boolean insertar(CarroDTO carro, Connection connection) throws SQLException{
		try{
			String p = "INSERT INTO carro (carro_placa, carro_modelo, carro_combustible, carro_tipo, carro_marca)"
					+ " VALUES (?,?,?,?,?)" ;
			int index=1;
			PreparedStatement ps1=connection.prepareStatement(p);
	       	ps1.setString(index++, carro.getPlaca());
	       	ps1.setInt(index++, carro.getModelo());
	       	ps1.setString(index++, carro.getCombustible());
	       	ps1.setString(index++, carro.getTipo());
	       	ps1.setString(index++, carro.getMarca());
	    	ps1.executeUpdate();
	    	
	    	String v= "INSERT INTO vehiculo (vehiculo_placa, carro_placa, propietario_id)"
					+ " VALUES (?,?,?)";
	    	int inde=1;
	    	PreparedStatement ps2=connection.prepareStatement(v);
	       	ps2.setString(inde++, carro.getPlaca());
	       	ps2.setString(inde++, carro.getPlaca());
	       	ps2.setInt(inde++, carro.getPropietario());
	       	ps2.executeUpdate();
	       	return true;
		}catch(SQLException e){
			return false;
		}
	}
}
