package pruebas;

import org.junit.Assert;
import org.junit.Test;

import dao.Conexion;
import dao.PropietarioDAO;
import dto.PropietarioDTO;

public class PropietarioTest {

	@Test
	public void test() throws Exception {
		PropietarioDTO propietarioD = new PropietarioDTO();
		propietarioD.setId(15);
		propietarioD.setNombre("Fernando");
		propietarioD.setTelefono("5622455");
		PropietarioDAO propietario = new PropietarioDAO();
		Conexion conec = new Conexion();
		Assert.assertEquals(true, propietario.insertar(propietarioD, conec.obtenerConexion()));
	}
	}


