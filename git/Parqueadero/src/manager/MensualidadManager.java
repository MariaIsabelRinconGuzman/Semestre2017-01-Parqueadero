package manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.ConectarBD;
import dao.CostoDAO;
import dao.MensualidadDAO;
import dao.VehiculoDAO;
import dto.FacturaDTO;

public class MensualidadManager {
	MensualidadDAO mensualidadDao=new MensualidadDAO();
	CostoDAO costoDao=new CostoDAO();
	VehiculoDAO vehiculoDao=new VehiculoDAO();
	ConectarBD conec=new ConectarBD();
	
	public String consultarAnio(){
		SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
		Calendar c=Calendar.getInstance();
		String anio=formatYear.format(c.getTime());
		return anio;
	}
	public String consultarFecha(){
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c=Calendar.getInstance();
		String fechaActual=formatDate.format(c.getTime());		
		return fechaActual;
	}
	public FacturaDTO consultarMensualidad(FacturaDTO factura) throws Exception {
		factura.setAnio(Integer.parseInt(consultarAnio()));
		String tipoVehiculo=vehiculoDao.consultarTipoVehiculo(factura.getPlaca(), conec.ObtenerConnection());
		if (tipoVehiculo.equals("moto")){
			factura.setTotal(costoDao.consultarPorAnio(consultarAnio(), conec.ObtenerConnection()).getMes_moto());
		}else{
			factura.setTotal(costoDao.consultarPorAnio(consultarAnio(), conec.ObtenerConnection()).getMes_carro());
		}		
		factura.setFecha_inicio(consultarFecha());
		int mesSiguiente=Integer.parseInt(factura.getFecha_inicio().substring(3, 5))+1;
		factura.setFecha_fin(consultarFecha().replaceFirst(factura.getFecha_inicio().substring(3, 5), String.valueOf(mesSiguiente)));
		return factura;
	}
	public void pagarMensualidad(FacturaDTO factura) throws Exception{
		mensualidadDao.pagarMensualidad(factura, conec.ObtenerConnection());
	}
	public FacturaDTO consultarSemanal(FacturaDTO factura) throws Exception {
		factura.setAnio(Integer.parseInt(consultarAnio()));
		String tipoVehiculo=vehiculoDao.consultarTipoVehiculo(factura.getPlaca(), conec.ObtenerConnection());
		if (tipoVehiculo.equals("moto")){
			factura.setTotal(costoDao.consultarPorAnio(consultarAnio(), conec.ObtenerConnection()).getSemana_moto());
		}else{
			factura.setTotal(costoDao.consultarPorAnio(consultarAnio(), conec.ObtenerConnection()).getSemana_carro());
		}		
		factura.setFecha_inicio(consultarFecha());
		int dia=Integer.parseInt(factura.getFecha_inicio().substring(0, 2));
		int semanaSiguiente=0;
		int mesSiguiente=Integer.parseInt(factura.getFecha_inicio().substring(3, 5))+1;
		if (dia>=24){
			semanaSiguiente=7-(30-dia);
			factura.setFecha_fin(consultarFecha().replaceFirst(factura.getFecha_inicio().substring(0, 2), String.valueOf(semanaSiguiente)));
			factura.setFecha_fin(consultarFecha().replaceFirst(factura.getFecha_inicio().substring(3, 5), String.valueOf(mesSiguiente)));			
		}else{
			semanaSiguiente=dia+7;
			factura.setFecha_fin(consultarFecha().replaceFirst(factura.getFecha_inicio().substring(0, 2), String.valueOf(semanaSiguiente)));
		}
		return factura;
	}
}
