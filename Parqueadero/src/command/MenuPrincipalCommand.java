package command;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
}
