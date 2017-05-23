package dto;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MotoDTO extends VehiculoDTO{
	private String cilindraje;

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}	
}
