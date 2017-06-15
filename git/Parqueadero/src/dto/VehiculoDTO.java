package dto;


public abstract class VehiculoDTO {
	public String placa;
	public Integer modelo;
	public String marca;
	public String combustible;
	public Integer propietario;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public Integer getPropietario() {
		return propietario;
	}

	public void setPropietario(Integer propietario) {
		this.propietario = propietario;
	}	
}
