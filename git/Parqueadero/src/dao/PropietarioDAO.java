package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.PropietarioDTO;

public class PropietarioDAO {

	public boolean insertar(PropietarioDTO propietario, Connection connection) throws Exception {
		try{
		 String p= "INSERT INTO propietario (propietario_id, propietario_nombre, propietario_telefono)"
					+ "VALUES (?,?,?)";
			int index=1;
			PreparedStatement ps1=connection.prepareStatement(p);
			ps1.setInt(index++, propietario.getId());
			ps1.setString(index++, propietario.getNombre());
			ps1.setString(index++, propietario.getTelefono());
			ps1.executeUpdate();
		   	return true;
				}catch(SQLException e){
					return false;
				}
	}
}
