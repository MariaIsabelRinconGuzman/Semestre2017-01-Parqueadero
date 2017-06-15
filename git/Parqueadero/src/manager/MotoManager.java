package manager;

import java.sql.SQLException;

import dao.ConectarBD;
import dao.MotoDAO;
import dto.MotoDTO;

public class MotoManager {
	MotoDAO motoDao=new MotoDAO();
	ConectarBD conec = new ConectarBD();
	
	public void insertar(MotoDTO moto) throws SQLException {
		motoDao.insertar(moto, conec.ObtenerConnection());
	}	
}
