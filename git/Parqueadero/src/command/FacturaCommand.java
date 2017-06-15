package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.FacturaDTO;
import manager.FacturaManager;

@ManagedBean
public class FacturaCommand {
	FacturaManager facturaManager=new FacturaManager();
	
	public FacturaDTO consultar(FacturaDTO factura) throws Exception{
		FacturaDTO facturaRetorno=facturaManager.consultar(factura);
		if(facturaRetorno.getFecha_inicio()!=null){
		return facturaRetorno;	
		}else{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No existe el vehiculo", null);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		return factura;		
	}
	public void pagar(FacturaDTO factura) throws Exception{
		facturaManager.pagar(factura);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pago Exitoso", null);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
