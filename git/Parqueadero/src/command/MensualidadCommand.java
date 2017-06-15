package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import dto.FacturaDTO;
import manager.MensualidadManager;

@ManagedBean
public class MensualidadCommand {
	MensualidadManager mensualidadManager =new MensualidadManager();
	
	public FacturaDTO consultarMensualidad(FacturaDTO factura) throws Exception{
		FacturaDTO facturaRetorno=mensualidadManager.consultarMensualidad(factura);
		if(facturaRetorno.getFecha_inicio()!=null){
		return facturaRetorno;	
		}else{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No existe el vehiculo", null);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		return facturaRetorno;
	}
	public void pagarMensualidad(FacturaDTO factura) throws Exception{		
		FacturaDTO facturaRetorno=consultarMensualidad(factura);
		mensualidadManager.pagarMensualidad(facturaRetorno);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pago Exitoso", null);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	public FacturaDTO consultarSemanal(FacturaDTO factura) throws Exception{
		FacturaDTO facturaRetorno=mensualidadManager.consultarSemanal(factura);
		if(facturaRetorno.getFecha_inicio()!=null){
		return facturaRetorno;	
		}else{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No existe el vehiculo", null);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		return facturaRetorno;
	}
	public void pagarSemanal(FacturaDTO factura) throws Exception{		
		FacturaDTO facturaRetorno=consultarSemanal(factura);
		mensualidadManager.pagarMensualidad(facturaRetorno);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pago Exitoso", null);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
}
