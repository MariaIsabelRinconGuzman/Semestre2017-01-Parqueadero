package manager;

import dao.ConectarBD;
import dao.CostoDAO;
import dto.CostoDTO;

public class CostoManager {
	CostoDAO costoDao=new CostoDAO();
	ConectarBD conec=new ConectarBD();
	
	public void insertar(CostoDTO costo) throws Exception {
		costoDao.insertar(costo, conec.ObtenerConnection());
	}
}
