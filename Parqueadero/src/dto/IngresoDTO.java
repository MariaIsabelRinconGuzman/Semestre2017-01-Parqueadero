package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IngresoDTO {
	private String placa;
	private int reserva;
	private String fecha;
	private int hora;
	private int cascos;
	private String llaves;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getReserva() {
		return reserva;
	}
	public void setReserva(int reserva) {
		this.reserva = reserva;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getCascos() {
		return cascos;
	}
	public void setCascos(int cascos) {
		this.cascos = cascos;
	}
	public String getLlaves() {
		return llaves;
	}
	public void setLlaves(String llaves) {
		this.llaves = llaves;
	}

}
