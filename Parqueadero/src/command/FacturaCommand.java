package command;

import javax.faces.bean.ManagedBean;

import dto.FacturaDTO;
import manager.CostoManager;
import manager.FacturaManager;

@ManagedBean
public class FacturaCommand {
	FacturaManager facturaManager=new FacturaManager();
	
	public FacturaDTO consultar(FacturaDTO factura) throws Exception{
		FacturaDTO facturaRetorno=facturaManager.consultar(factura);
		return facturaRetorno;		
	}
}
