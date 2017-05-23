package command;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.MotoDTO;
import manager.MotoManager;

@ManagedBean
public class MotoCommand {
	MotoManager motoManager=new MotoManager();
	
	public void insertar(MotoDTO moto) throws SQLException{
		motoManager.insertar(moto);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingresado correctamente", "La moto "+moto.getPlaca());

		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
