package manager;

import java.sql.SQLException;
import java.util.Calendar;

import dao.ConectarBD;
import dao.IngresoDAO;
import dto.IngresoDTO;

public class IngresoManager {
IngresoDAO ingresoDao= new IngresoDAO();
ConectarBD conec = new ConectarBD();
	
	public void insertarmoto(IngresoDTO ingreso) throws SQLException{
		Calendar c=Calendar.getInstance();
		int horaActual=c.getTime().getHours();
		ingreso.setHora(horaActual);
		ingreso.setFecha(c.getTime().toString());
		int anio=c.getTime().getYear()+1900;
		ingresoDao.insertarMoto(ingreso, anio, conec.ObtenerConnection());
	}
	public void insertarcarro(IngresoDTO ingreso) throws SQLException{
		Calendar c=Calendar.getInstance();
		int horaActual=c.getTime().getHours();
		ingreso.setHora(horaActual);
		ingreso.setFecha(c.getTime().toString());
		int anio=c.getTime().getYear()+1900;
		ingresoDao.insertarCarro(ingreso, anio, conec.ObtenerConnection());
	}
}
