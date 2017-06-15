package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CostoDTO {
	private Integer anio;
	private Double hora_carro;
	private Double hora_moto;
	private Double dia_carro;
	private Double dia_moto;
	private Double lavado_carro;
	private Double lavado_moto;
	private Double semana_carro;
	private Double semana_moto;
	private Double mes_carro;
	private Double mes_moto;
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Double getHora_carro() {
		return hora_carro;
	}
	public void setHora_carro(Double hora_carro) {
		this.hora_carro = hora_carro;
	}
	public Double getHora_moto() {
		return hora_moto;
	}
	public void setHora_moto(Double hora_moto) {
		this.hora_moto = hora_moto;
	}
	public Double getDia_carro() {
		return dia_carro;
	}
	public void setDia_carro(Double dia_carro) {
		this.dia_carro = dia_carro;
	}
	public Double getDia_moto() {
		return dia_moto;
	}
	public void setDia_moto(Double dia_moto) {
		this.dia_moto = dia_moto;
	}
	public Double getLavado_carro() {
		return lavado_carro;
	}
	public void setLavado_carro(Double lavado_carro) {
		this.lavado_carro = lavado_carro;
	}
	public Double getLavado_moto() {
		return lavado_moto;
	}
	public void setLavado_moto(Double lavado_moto) {
		this.lavado_moto = lavado_moto;
	}
	public Double getSemana_carro() {
		return semana_carro;
	}
	public void setSemana_carro(Double semana_carro) {
		this.semana_carro = semana_carro;
	}
	public Double getSemana_moto() {
		return semana_moto;
	}
	public void setSemana_moto(Double semana_moto) {
		this.semana_moto = semana_moto;
	}
	public Double getMes_carro() {
		return mes_carro;
	}
	public void setMes_carro(Double mes_carro) {
		this.mes_carro = mes_carro;
	}
	public Double getMes_moto() {
		return mes_moto;
	}
	public void setMes_moto(Double mes_moto) {
		this.mes_moto = mes_moto;
	}
}
