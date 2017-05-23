package dto;

import javax.faces.bean.ManagedBean;

import sun.util.calendar.BaseCalendar.Date;

@ManagedBean
public class ReservaDTO {
	private String fecha;
	private String hora;
	private String placa;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
