package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.MotoDTO;
import manager.VehiculoManager;

@ManagedBean
public class VehiculoCommand {
	VehiculoManager vehiculoManager=new VehiculoManager();
	
	public void actualizarPropietario(MotoDTO vehiculo) throws Exception{		
		vehiculoManager.actualizarPropietario(vehiculo);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado correctamente", "El propietario del Vehiculo "+ vehiculo.getPlaca());
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
