package manager;

import java.sql.SQLException;

import dao.CarroDAO;
import dao.ConectarBD;
import dto.CarroDTO;


public class CarroManager {
	CarroDAO carroDao=new CarroDAO();
	ConectarBD conec = new ConectarBD();
	
	public void insertar(CarroDTO carro) throws SQLException{
		carroDao.insertar(carro, conec.ObtenerConnection());
	}

}
