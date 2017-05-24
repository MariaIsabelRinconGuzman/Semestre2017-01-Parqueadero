/**
 * 
 */
package seguridad.command.Maestros;


import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import seguridad.command.Comunes.GeneradorLog;
import seguridad.command.Comunes.MessagesController;
import seguridad.dto.ErrorDTO;
import seguridad.dto.ListasDTO;
import seguridad.dto.OpcionesDTO;
import seguridad.dto.OpcionesTablaDTO;
import seguridad.manager.OpcionesManager;

/**
 * OpcionesCommand
 * 
 * Recibe lo que tiene la clase DTO y verifica que esten los datos bien y se los manda a la clase manager. 
 * Imprime si la consulta se genero correctamente
 * 
 *@author John Alxander Gutierrez
 */
@ManagedBean
public class OpcionesCommand {
	/* Esta Clase contiene los metodos ingresar, actualizar, eliminar y consultar los cuales reciben los datos, verifica los datos y se lo manda a la clase Manager */
	
	/**
	 * El metodo devuelve Si se genero bien la consulta ingresar
	 * 
	 * @param OpcionesDTO
	 * @return Mensaje de exito o error en la consulta Ingresar
	 */
	
	private GeneradorLog log = new GeneradorLog();
	

	//ListasDTO lista = new ListasDTO();
	public void ingresar(OpcionesDTO opcionesDTO) throws SQLException{ 
		//Recibe un objeto de tipo OpcionesDTO el cual verifica que los datos esten correctos y se lo manda a la clase Manager
		MessagesController ms = new MessagesController(); 
		
		if (opcionesDTO != null){
			if(opcionesDTO.getIdEstado()!=""){
				OpcionesManager opcionesManager = new OpcionesManager();
				ErrorDTO errorDTO = opcionesManager.ingresar(opcionesDTO);
				ms.addInfo(null, errorDTO.getMensajeUsuario());
				if (errorDTO.getSNOperacion()){
					log.generadorLogINFO(errorDTO.getMensajeTecnico());
				}
				else {
					log.generadorLogERROR(errorDTO.getMensajeTecnico());//Cuando no genera la Conexion o no se hace la Consulta
				}
			}
			else{
				ms.addError(null, "Debes Ingresar Los Datos Requeridos");//Cuando los datos requeridos no los cumple
				
			}
		}	
	}//Cierre del Metodo Ingresar
	
	 /**
	 * El metodo devuelve Si se Actualizo el registro
	 * 
	 * @param OpcionesDTO
	 * @return Mensaje de exito o error en la consulta Actualizar
	 */
	public void actualizar(OpcionesDTO opcionesDTO) throws SQLException{
		//Recibe un objeto de tipo OpcionesDTO el cual verifica que los datos esten correctos y se lo manda a la clase Manager
		MessagesController ms = new MessagesController(); 
		if (opcionesDTO != null){
			if(opcionesDTO.getIdEstado()!=""){
				OpcionesManager opcionesManager = new OpcionesManager();
				Boolean resp = opcionesManager.actualizar(opcionesDTO);
				if (resp){
					ms.addInfo(null, "Actualizado Correctamente");//Actualizado Correctamente
				}
				else {
					ms.addError(null, "Error al Actualizar");//Cuando hay error en la conexcion con la base de datos ó No genera la consulta
				}
			}
			else{
				ms.addError(null, "Debes Ingresar Los Datos Requeridos");//Datos no validos para generar la consulta
				
			}
		}
		
	}//Cierre del MetodoActualizar
	 
	/**
	 * El metodo devuelve Si se Elimino el registro
	 * 
	 * @param OpcionesDTO
	 * @return Mensaje de exito o error en la consulta Eliminar
	 */
	public void eliminar(OpcionesDTO opcionesDTO) throws SQLException{
		//Recibe un objeto de tipo OpcionesDTO el cual verifica que los datos esten correctos y se lo manda a la clase Manager
		MessagesController ms = new MessagesController(); 
		if (opcionesDTO != null){
			if (opcionesDTO.getIdOpcion() != ""){
				OpcionesManager opcionesManager = new OpcionesManager();
				Boolean resp = opcionesManager.eliminar(opcionesDTO);
				if (resp){
					ms.addInfo(null, "Registro Eliminado");//Cuando Se Elimina Correctamente
				}
				else {
					ms.addError(null, "Error al Eliminar");//Error en la conexion con la base de datos ó error al Eliminar
				}
			}
			else{
				ms.addError(null, "Debes Ingresar Los Datos Requeridos");//Datos no validos para hacer la consulta
				
			}
		}	
	}//Cierre del Metodo Eliminar
	
	/**
	 * El metodo devuelve Si se Seleccionaron los datos de la Tabla opciones
	 * 
	 * @param OpcionesTablaDTO
	 * @return Mensaje de exito o error en la consulta Select
	 */
	
	/*
	 * Correccion error Cargar lista Opciones, reportado por camilo17746 23/05/17 Por:Veronica Zapata
	 */
	public void consultar(OpcionesTablaDTO opcionestablaDTO) throws SQLException{
		//Recibe un objeto de tipo OpcionesTablaDTO el cual verifica que los datos esten correctos y se lo manda a la clase Manager
		MessagesController ms = new MessagesController(); 
		OpcionesManager opcionesManager = new OpcionesManager();
		boolean res= opcionesManager.consultar(opcionestablaDTO);
		if (!res){
			ms.addInfo(null, "Error en la consulta");//Si la consulta no se realizo correctamente, o hay un error en la conexion en la base de datos
		}
		
	}//Cierre del Metodo Consultar
	
	public void consultaropciones(ListasDTO lista) throws SQLException{
		//Recibe un objeto de tipo OpcionesTablaDTO el cual verifica que los datos esten correctos y se lo manda a la clase Manager
		OpcionesManager opcionesManager = new OpcionesManager();
		lista= opcionesManager.consultaropciones();
		//return lista;
	}
	
}//Cierre de la Clase OpcioncesCommand
