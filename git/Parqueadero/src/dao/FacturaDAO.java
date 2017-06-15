package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.FacturaDTO;

public class FacturaDAO {
	public FacturaDTO consultar(FacturaDTO factura, Connection connection) throws Exception{
		String c="SELECT * FROM parqueadero.factura where factura_placa=? order By factura_codigo desc";
		PreparedStatement ps=connection.prepareStatement(c);
		ps.setString(1,factura.getPlaca());
		ResultSet rs=null;
		rs=ps.executeQuery();
		rs.next();
		factura.setAnio(rs.getInt("costo_anio"));
		factura.setFecha_inicio(rs.getString("factura_hora_inicio"));
		factura.setFecha_fin(rs.getString("factura_hora_fin"));
		return factura;	
	}	
	public void actualizar(FacturaDTO factura, Connection connection) throws Exception{
		String c="SELECT factura_codigo from factura WHERE factura_placa=?";
		PreparedStatement ps1=connection.prepareStatement(c);
		ps1.setString(1,factura.getPlaca());
		ResultSet rs=null;
		rs=ps1.executeQuery();
		String codigo=null;
		while(rs.next()){
			codigo=rs.getString(1);
		}
		String a="UPDATE factura SET factura_horas=?, factura_lavado=?, factura_hora_fin=?, factura_total=? WHERE factura_codigo=?";
		int index=1;
		PreparedStatement ps=connection.prepareStatement(a);
		ps.setDouble(index++, factura.getHoras());
		ps.setString(index++, factura.getLavado());
		ps.setString(index++, factura.getFecha_fin());
		ps.setDouble(index++, factura.getTotal());
		ps.setString(index++, codigo);
		ps.executeUpdate();
	}
	public boolean pagar(FacturaDTO factura, Connection connection) throws Exception {
		try{
		String b= "DELETE FROM ingreso WHERE vehiculo_placa=?";
		PreparedStatement ps=connection.prepareStatement(b);
		ps.setString(1,factura.getPlaca());
		ps.executeUpdate();		
	   	return true;
			}catch(SQLException e){
				return false;
			}
}
}