package command;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import dto.CarroDTO;
import manager.CarroManager;

@ManagedBean
public class CarroCommand {
	CarroManager carroManager=new CarroManager();
	
	public void insertar(CarroDTO carro) throws SQLException{
		carroManager.insertar(carro);
	}

}
