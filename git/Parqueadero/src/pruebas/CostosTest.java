package pruebas;



import org.junit.Assert;
import org.junit.Test;

import dao.Conexion;
import dao.CostoDAO;
import dto.CostoDTO;

public class CostosTest {

	@Test
	public void test() throws Exception {
		CostoDTO costoD = new CostoDTO();
		costoD.setAnio(2018);
		costoD.setDia_carro(8000.0);
		costoD.setDia_moto(6000.0);
		costoD.setHora_carro(2000.0);
		costoD.setHora_moto(500.0);
		costoD.setLavado_carro(20000.0);
		costoD.setLavado_moto(12000.0);
		costoD.setMes_carro(80000.0);
		costoD.setMes_moto(60000.0);
		costoD.setSemana_carro(20000.0);
		costoD.setSemana_moto(15000.0);
		CostoDAO costo = new CostoDAO();
		Conexion conec = new Conexion();
		Assert.assertEquals(true, costo.insertar(costoD, conec.obtenerConexion()));
	
	}

}
