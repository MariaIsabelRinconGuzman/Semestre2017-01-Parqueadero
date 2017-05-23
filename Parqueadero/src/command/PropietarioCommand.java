package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.MotoDTO;
import dto.PropietarioDTO;
import manager.PropietarioManager;

@ManagedBean
public class PropietarioCommand {
	PropietarioManager propietarioManager=new PropietarioManager();
	
	public void insertar(PropietarioDTO propietario) throws Exception{
		propietarioManager.insertar(propietario);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingresado correctamente", "El propietario "+propietario.getNombre());
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
