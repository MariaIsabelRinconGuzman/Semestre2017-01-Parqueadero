package command;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import dto.ReservaDTO;
import manager.ReservaManager;
import manager.VehiculoManager;

import java.util.Date;

@ManagedBean
public class ReservaCommand {
	ReservaManager reservaManager=new ReservaManager();
	VehiculoManager vehiculoManager=new VehiculoManager();
	private Date calendar;
	private Date hour;
	public Date getHour() {
		return hour;
	}
	public void setHour(Date hour) {
		this.hour = hour;
	}
	public Date getCalendar() {
		return calendar;
	}
	public void setCalendar(Date calendar) {
		this.calendar = calendar;
	}	
	public void onDateSelect(SelectEvent event) throws Exception {
		FacesContext facesContext = FacesContext.getCurrentInstance();
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha seleccionada", format.format(event.getObject())));
	  }
	public void reservar(ReservaDTO reserva) throws ParseException, Exception{
		if(vehiculoManager.consultarVehiculo(reserva.getPlaca())==true){
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm");
		reserva.setFecha(formatDate.format(this.calendar));
		reserva.setHora(formatHour.format(this.hour));
		reservaManager.reservar(reserva);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingresado correctamente", "La reserva para el vehiculo: "+reserva.getPlaca()+", fecha: "+reserva.getFecha()+", hora: "+reserva.getHora());
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "El vehiculo "+ reserva.getPlaca()+" no existe en la base de datos");
			RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		
	}
}
