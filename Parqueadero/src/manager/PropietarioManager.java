package manager;



import dao.ConectarBD;
import dao.PropietarioDAO;
import dto.MotoDTO;
import dto.PropietarioDTO;
import dto.VehiculoDTO;

public class PropietarioManager {
	PropietarioDAO propietarioDao=new PropietarioDAO();
	ConectarBD conec=new ConectarBD();

	public void insertar(PropietarioDTO propietario) throws Exception {
		propietarioDao.insertar(propietario, conec.ObtenerConnection());
	}
}
