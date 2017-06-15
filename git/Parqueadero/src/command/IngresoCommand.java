package command;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dto.IngresoDTO;
import manager.IngresoManager;
import manager.VehiculoManager;

@ManagedBean
public class IngresoCommand {
	IngresoManager ingresoManager= new IngresoManager();
	VehiculoManager vehiculoManager=new VehiculoManager();
	private int reserva;
	public int getReserva() {
		return reserva;
	}
	public void setReserva(int reserva) {
		this.reserva = reserva;
	}
	public void sinReserva(){
		this.setReserva(0);
	}
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	public void insertarmoto(IngresoDTO ingreso) throws Exception{
		if(vehiculoManager.consultarVehiculo(ingreso.getPlaca())==true){
			ingreso.setReserva(this.getReserva());
			ingresoManager.insertarmoto(ingreso);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingresado correctamente", "La moto "+ ingreso.getPlaca());
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "La moto "+ ingreso.getPlaca()+" no existe en la base de datos");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		
	}
	public void insertarcarro(IngresoDTO ingreso) throws Exception{	
		if(vehiculoManager.consultarVehiculo(ingreso.getPlaca())==true){
		ingreso.setReserva(this.getReserva());
		ingresoManager.insertarcarro(ingreso);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingresado correctamente", "El  carro "+ ingreso.getPlaca());
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "El carro "+ ingreso.getPlaca()+" no existe en la base de datos");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}
}
