package pruebas;

import org.junit.Assert;
import org.junit.Test;

import dao.CarroDAO;
import dao.Conexion;
import dto.CarroDTO;

public class CarroTest {

	@Test
	public void test() throws Exception {
		CarroDTO carroDto = new CarroDTO();
		carroDto.setPropietario(1);
		carroDto.setPlaca("AAE");
		carroDto.setModelo(2016);
		carroDto.setCombustible("Diesel");
		carroDto.setMarca("efmn");
		carroDto.setTipo("Camioneta");
		CarroDAO carro= new CarroDAO();
		Conexion conec = new Conexion();
		Assert.assertEquals(true, carro.insertar(carroDto, conec.obtenerConexion()));
	}

}
