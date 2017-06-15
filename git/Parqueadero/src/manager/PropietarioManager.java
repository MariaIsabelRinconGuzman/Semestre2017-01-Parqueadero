package manager;

import dao.ConectarBD;
import dao.PropietarioDAO;
import dto.PropietarioDTO;

public class PropietarioManager {
	PropietarioDAO propietarioDao=new PropietarioDAO();
	ConectarBD conec=new ConectarBD();

	public void insertar(PropietarioDTO propietario) throws Exception {
		propietarioDao.insertar(propietario, conec.ObtenerConnection());
	}
}
