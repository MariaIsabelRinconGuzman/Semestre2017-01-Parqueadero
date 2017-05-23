package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean 
public class CarroDTO extends VehiculoDTO{
	private String tipo;

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
