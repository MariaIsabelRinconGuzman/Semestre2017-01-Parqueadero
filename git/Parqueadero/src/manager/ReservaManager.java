package manager;

import java.sql.SQLException;

import dao.ConectarBD;
import dao.ReservaDAO;
import dto.ReservaDTO;

public class ReservaManager {
	ReservaDAO reservaDao=new ReservaDAO();
	ConectarBD conec = new ConectarBD();
	
	public void reservar(ReservaDTO reserva) throws SQLException {
		reservaDao.reservar(reserva, conec.ObtenerConnection());
	}
}
