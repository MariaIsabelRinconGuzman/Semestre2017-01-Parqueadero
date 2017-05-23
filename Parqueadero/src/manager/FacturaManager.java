package manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.ConectarBD;
import dao.CostoDAO;
import dao.FacturaDAO;
import dao.VehiculoDAO;
import dto.FacturaDTO;

public class FacturaManager {
	FacturaDAO facturaDao=new FacturaDAO();
	CostoDAO costoDao=new CostoDAO();
	VehiculoDAO vehiculoDao=new VehiculoDAO();
	ConectarBD conec=new ConectarBD();
	
	public FacturaDTO consultar(FacturaDTO factura) throws Exception {
		facturaDao.consultar(factura, conec.ObtenerConnection());		
			Calendar c=Calendar.getInstance();
			SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm");
			SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
			formatDate.format(c.getTime());		
			int horaActual= c.getTime().getHours();
			int horaIngreso=Integer.parseInt(factura.getFecha_inicio().substring(11,13));
			double calculoHoras=horaActual-horaIngreso;			
			String anio=formatYear.format(c.getTime());
			costoDao.consultarPorAnio(anio, conec.ObtenerConnection());
			double costoHora;
			double totalParqueo=0;
			double costoLavado=0;
			String tipoVehiculo=vehiculoDao.consultarTipoVehiculo(factura.getPlaca(), conec.ObtenerConnection());
			if (tipoVehiculo.equals("moto")){
				costoHora=costoDao.consultarPorAnio(anio, conec.ObtenerConnection()).getHora_moto();
				costoLavado=costoDao.consultarPorAnio(anio, conec.ObtenerConnection()).getLavado_moto();
				if(calculoHoras>=6){
					totalParqueo=costoDao.consultarPorAnio(anio, conec.ObtenerConnection()).getDia_moto();
				}else{
					totalParqueo=calculoHoras*costoHora;
				}
			}else{
				costoHora=costoDao.consultarPorAnio(anio, conec.ObtenerConnection()).getHora_carro();
				costoLavado=costoDao.consultarPorAnio(anio, conec.ObtenerConnection()).getLavado_carro();
				if(calculoHoras>=6){
					totalParqueo=costoDao.consultarPorAnio(anio, conec.ObtenerConnection()).getHora_carro();
				}else{
					totalParqueo=calculoHoras*costoHora;
				}
			}
			double totalFactura=totalParqueo;		
			if(factura.getLavado()==""){
				factura.setLavado("f");
			}else{
				totalFactura=totalParqueo+costoLavado;
			}
			factura.setFecha_fin(c.getTime().toString());
			factura.setHoras(calculoHoras);
			factura.setTotal(totalFactura);
			facturaDao.actualizar(factura, conec.ObtenerConnection());
			return factura;
		}		
	}
