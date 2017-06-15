package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.IngresoDTO;


public class IngresoDAO {
	public boolean insertarMoto(IngresoDTO ingreso, int anio, Connection connection) throws SQLException {
		try{
		String p = "INSERT INTO ingreso (vehiculo_placa, reserva_codigo, ingreso_fecha, ingreso_hora, ingreso_cascos)"
				+ " VALUES (?,?,?,?,?)";
		int index=1;
       	PreparedStatement ps1=connection.prepareStatement(p);
       	ps1.setString(index++, ingreso.getPlaca());
       	ps1.setInt(index++, ingreso.getReserva());
       	ps1.setString(index++, ingreso.getFecha());
       	ps1.setInt(index++, ingreso.getHora());
       	ps1.setInt(index++, ingreso.getCascos());
       	ps1.executeUpdate();
       	
       	ResultSet rs=null;
       	String c="SELECT max(ingreso_codigo) FROM ingreso";
       	PreparedStatement psc=connection.prepareStatement(c);
       	rs=psc.executeQuery();
       	rs.next();
       	int codigo=rs.getInt("max(ingreso_codigo)");
       	
       	String f="INSERT INTO factura (ingreso_codigo, costo_anio, factura_cascos, factura_hora_inicio, factura_placa) VALUES (?,?,?,?,?)";
       	int inde=1;
    	PreparedStatement ps2=connection.prepareStatement(f);
       	ps2.setInt(inde++, codigo);
       	ps2.setInt(inde++, anio);
       	ps2.setInt(inde++, ingreso.getCascos());
       	ps2.setString(inde++, ingreso.getFecha());
       	ps2.setString(inde++, ingreso.getPlaca());
       	ps2.executeUpdate();
       	return true;
    		}catch(SQLException e){
    			return false;
    		}
       	}
	public void insertarCarro(IngresoDTO ingreso, int anio, Connection connection) throws SQLException {
		String p = "INSERT INTO ingreso (vehiculo_placa, reserva_codigo, ingreso_fecha, ingreso_hora, ingreso_llaves)"
				+ " VALUES (?,?,?,?,?)";
		int index=1;
       	PreparedStatement ps1=connection.prepareStatement(p);
       	ps1.setString(index++, ingreso.getPlaca());
       	ps1.setInt(index++, ingreso.getReserva());
       	ps1.setString(index++, ingreso.getFecha());
       	ps1.setInt(index++, ingreso.getHora());
       	ps1.setString(index++, ingreso.getLlaves());
       	ps1.executeUpdate();
       	ResultSet rs=null;
       	String c="SELECT max(ingreso_codigo) FROM ingreso";
       	PreparedStatement psc=connection.prepareStatement(c);
       	rs=psc.executeQuery();
       	rs.next();
       	int codigo=rs.getInt("max(ingreso_codigo)");
       	
       	String f="INSERT INTO factura (ingreso_codigo, costo_anio, factura_llaves, factura_hora_inicio, factura_placa) VALUES (?,?,?,?,?)";
       	int inde=1;
    	PreparedStatement ps2=connection.prepareStatement(f);
       	ps2.setInt(inde++, codigo);
       	ps2.setInt(inde++, anio);
       	ps2.setString(inde++, ingreso.getLlaves());
       	ps2.setString(inde++, ingreso.getFecha());
       	ps2.setString(inde++, ingreso.getPlaca());
       	ps2.executeUpdate();
       	
       	}
}
