package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean 
public class CarroDTO extends VehiculoDTO{
	private String combustible;
	private String tipo;

	public String getCombustible() {
		return combustible;
	}
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
