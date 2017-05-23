package command;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.CarroDTO;
import manager.CarroManager;

@ManagedBean
public class CarroCommand {
	CarroManager carroManager=new CarroManager();
	
	public void insertar(CarroDTO carro) throws SQLException{
		carroManager.insertar(carro);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingresado correctamente", "El carro "+carro.getPlaca());
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
