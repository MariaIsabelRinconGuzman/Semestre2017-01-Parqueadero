package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import manager.CuposManager;

@ManagedBean
public class MenuPrincipalCommand {
	public void ingresarPropietario() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/IngresarPropietario.xhtml");
	}
	public void ingresarMoto() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/IngresoMoto.xhtml");
	}
	public void ingresarCarro() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/IngresoCarro.xhtml");
	}
	public void ingresarReserva() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/Reserva.xhtml");
	}
	public void actualizarPropietario() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/ActualizarPropietario.xhtml");
	}
	public void actualizarCostos() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/Costo.xhtml");
	}
	public void crearCarro() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/Carro.xhtml");
	}
	public void crearMoto() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/Moto.xhtml");
	}
	public void generarFactura() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/Factura.xhtml");
	}
	public void generarFacturaMensualidad() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/Mensualidad.xhtml");
	}
	public void generarFacturaSemanal() throws Exception{
		ExternalContext contex = FacesContext.getCurrentInstance().getExternalContext();
        contex.redirect(contex.getRequestContextPath()+"/faces/Semanal.xhtml");
	}
	public int consultarCupos() throws Exception{
		CuposManager cuposManager=new CuposManager();
		int cupos=cuposManager.consultarCupos();
		if(cupos>=15){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hay: "+cupos+" vehiculos en el parqueadero");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		return cuposManager.consultarCupos();
	}
}
