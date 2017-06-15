package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.FacturaDTO;

public class MensualidadDAO {

	public boolean pagarMensualidad(FacturaDTO factura, Connection connection) throws Exception {
		try{
		String m="INSERT INTO factura (costo_anio, factura_hora_inicio, factura_hora_fin, factura_total, factura_placa) VALUES (?,?,?,?,?)";
		PreparedStatement ps=connection.prepareStatement(m);
		int index=1;
		ps.setInt(index++, factura.getAnio());
		ps.setString(index++,factura.getFecha_inicio());
		ps.setString(index++, factura.getFecha_fin());
		ps.setDouble(index++, factura.getTotal());
		ps.setString(index++, factura.getPlaca());
		ps.executeUpdate();
	   	return true;
			}catch(SQLException e){
				return false;
			}
	}
}
