package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CuposDAO {

	public int consultarCupos(Connection connection) throws Exception {
		String c="SELECT count(*) as vehiculos FROM parqueadero.ingreso";
		PreparedStatement ps=connection.prepareStatement(c);
		ResultSet rs=ps.executeQuery();	
		rs.next();
		return rs.getInt("vehiculos");
	}

}
