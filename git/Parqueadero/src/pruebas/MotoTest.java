package pruebas;

import org.junit.Assert;
import org.junit.Test;


import dao.Conexion;
import dao.MotoDAO;
import dto.MotoDTO;

public class MotoTest {

	@Test
	public void test() throws Exception {
		MotoDTO motoD= new MotoDTO();
		motoD.setPropietario(2);
		motoD.setPlaca("w33uu");
		motoD.setModelo(1995);
		motoD.setCombustible("gas");
		motoD.setCilindraje("150");
		motoD.setMarca("sdsd");
		MotoDAO moto = new MotoDAO();
		Conexion conec = new Conexion();
		Assert.assertEquals(true, moto.insertar(motoD, conec.obtenerConexion()));
	}
	}


