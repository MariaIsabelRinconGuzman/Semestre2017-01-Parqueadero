package manager;

import dao.ConectarBD;
import dao.VehiculoDAO;
import dto.VehiculoDTO;

public class VehiculoManager {
	VehiculoDAO vehiculoDao=new VehiculoDAO();
	ConectarBD conec=new ConectarBD();

	public void actualizarPropietario(VehiculoDTO vehiculo) throws Exception {
		vehiculoDao.actualizarPropietario(vehiculo, conec.ObtenerConnection());
	}

	public boolean consultarVehiculo(String placa) throws Exception {
		if(vehiculoDao.consultarVehiculo(placa, conec.ObtenerConnection())==true){
			return true;
		}else{
			return false;			
		}
		
	}

}
