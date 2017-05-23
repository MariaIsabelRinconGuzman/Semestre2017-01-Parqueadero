package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.CostoDTO;

public class CostoDAO {

	public void insertar(CostoDTO costo, Connection connection) throws Exception {
		String a= "INSERT INTO costo (costo_hora_carro, costo_dia_carro, costo_hora_moto, costo_dia_moto, costo_semana_carro, costo_mes_carro, costo_mes_moto, "
				+ "costo_anio, costo_semana_moto, costo_hora_nocturna_carro, costo_hora_nocturna_moto) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		int index=1;
		PreparedStatement ps=connection.prepareStatement(a);
		ps.setDouble(index++, costo.getHora_carro());
		ps.setDouble(index++, costo.getDia_carro());
		ps.setDouble(index++, costo.getHora_moto());
		ps.setDouble(index++, costo.getDia_moto());
		ps.setDouble(index++, costo.getSemana_carro());
		ps.setDouble(index++, costo.getMes_carro());
		ps.setDouble(index++, costo.getMes_moto());
		ps.setInt(index++, costo.getAnio());
		ps.setDouble(index++, costo.getSemana_moto());
		ps.setDouble(index++, costo.getLavado_carro());
		ps.setDouble(index++, costo.getLavado_moto());
		ps.executeUpdate();
	}
	public CostoDTO consultarPorAnio(String anio, Connection connection) throws Exception{
		CostoDTO costo=new CostoDTO();
		String c="Select * from costo where costo_anio=?";
		PreparedStatement ps=connection.prepareStatement(c);
		ps.setString(1, anio);
		ResultSet rs=ps.executeQuery();		
		while(rs.next()){
			costo.setAnio(rs.getInt("costo_anio"));
			costo.setHora_carro(rs.getDouble(("costo_hora_carro")));
			costo.setHora_moto(rs.getDouble(("costo_hora_moto")));
			costo.setDia_carro(rs.getDouble(("costo_dia_carro")));
			costo.setDia_moto(rs.getDouble(("costo_dia_moto")));
			costo.setSemana_moto(rs.getDouble(("costo_semana_moto")));
			costo.setSemana_carro(rs.getDouble(("costo_semana_carro")));
			costo.setMes_moto(rs.getDouble(("costo_mes_moto")));
			costo.setMes_carro(rs.getDouble(("costo_mes_moto")));
			costo.setLavado_moto(rs.getDouble(("costo_lavado_moto")));
			costo.setLavado_carro(rs.getDouble(("costo_lavado_carro")));	
		}		
		return costo;		
	}
}
