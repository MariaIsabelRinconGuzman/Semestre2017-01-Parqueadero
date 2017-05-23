package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dto.CostoDTO;
import manager.CostoManager;

@ManagedBean
public class CostoCommand {
	CostoManager costoManager=new CostoManager();

	public void insertar(CostoDTO costo) throws Exception{
		costoManager.insertar(costo);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingresado correctamente", "Los costos para el año "+costo.getAnio());
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
