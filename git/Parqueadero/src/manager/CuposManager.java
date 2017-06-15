package manager;

import dao.ConectarBD;
import dao.CuposDAO;

public class CuposManager {
	CuposDAO cuposDao = new CuposDAO();
	ConectarBD conec=new ConectarBD();
	
	public int consultarCupos() throws Exception{
		return cuposDao.consultarCupos(conec.ObtenerConnection());
	}

}
