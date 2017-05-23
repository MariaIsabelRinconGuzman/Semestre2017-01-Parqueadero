package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class FacturaDTO {
	private String placa;
	private String lavado;
	private Double horas;
	private String fecha_fin;
	private String fecha_inicio;
	private Double total;
	private String cascos;
	private String llaves;
	private int anio;
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getLavado() {
		return lavado;
	}
	public void setLavado(String lavado) {
		this.lavado = lavado;
	}
	public Double getHoras() {
		return horas;
	}
	public void setHoras(Double horas) {
		this.horas = horas;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getCascos() {
		return cascos;
	}
	public void setCascos(String cascos) {
		this.cascos = cascos;
	}
	public String getLlaves() {
		return llaves;
	}
	public void setLlaves(String llaves) {
		this.llaves = llaves;
	}
	
}
