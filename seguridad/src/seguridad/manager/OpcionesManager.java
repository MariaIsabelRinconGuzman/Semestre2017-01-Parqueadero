package seguridad.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import seguridad.dao.Comunes.ConectarMySQL;
import seguridad.dao.Comunes.OpcionesDAO;
import seguridad.dto.AplicacionesDTO;
import seguridad.dto.ErrorDTO;
import seguridad.dto.ListasDTO;
import seguridad.dto.OpcionesDTO;
import seguridad.dto.OpcionesTablaDTO;
import seguridad.dto.UsuariosDTO;

/**
 * OpcionesManager
 * 
 * Verifica la Conexion con la base de datos y le mando los datos a la clase DAO para hacer la consulta y ya esta le manda a la clase commaand se se genero bien la consulta
 * 
 *@author John Alxander Gutierrez
 */

@SuppressWarnings("static-access")
public class OpcionesManager {
	//esta clase varifica la conexion a la base de datos y le mando los datos a la clase dao para que haga la consulta y retorna la consulta
	
	private ConectarMySQL conectar = new ConectarMySQL();
	private OpcionesDAO opcionesDao = new OpcionesDAO();
	private ErrorDTO error = new ErrorDTO();
	
	/**
	 * El metodo revisa si hay conexion y manda los datos a la clase DAO para que  ingrese	
	 * 
	 * @param OpcionesDTO
	 * @return Si se genero correctamente la consulta ingresar en la clase DAO
	 */
	public ErrorDTO ingresar(OpcionesDTO opcionesDTO) throws SQLException{
		//Recibe un objeto de tipo opcionesDTO y retorna si la consulta actualizar se hizo correctamente
		Connection conexion =  conectar.performConnection();
		
		if (conexion == null){
			error.setSNOperacion(false);//Si la conexion no se genero
			error.setMensajeUsuario("No se pudo conectar a la Base de datos");
			error.setMensajeTecnico("Falla la conexión");
		}
		else {
			opcionesDao.ingresar(opcionesDTO, conexion,error);//si la Conexion se hizo, manda los datos a la Clase DAO
		}
		
		return error;
	}//Termina el Metodo ingresar
	
	/**
	 * El metodo revisa si hay conexion y manda los datos a la clase DAO para que  actualice	
	 * 
	 * @param OpcionesDTO
	 * @return Si se genero correctamente la consulta actualizar en la clase DAO
	 */
	public Boolean actualizar(OpcionesDTO opcionesDTO) throws SQLException{
		//Recibe un objeto de tipo opcionesDTO y retorna si la consulta actualizar se hizo correctamente
		Connection conexion =  conectar.performConnection();
		if (conexion == null){
			return false;//no hubo conexcion en la base de datos
		}
		else {
			return opcionesDao.actualizar(opcionesDTO, conexion);//Se genero la conexion y retorna la consulta Actualizar que hizo la clase DAO
		}
		
	}//Fin del Metodo Actualizar
	
	/**
	 * El metodo revisa si hay conexion y manda los datos a la clase DAO para que Elimine	
	 * 
	 * @param OpcionesDTO
	 * @return Si se genero correctamente la consulta Eliminar en la clase DAO
	 */
	public Boolean eliminar(OpcionesDTO opcionesDTO) throws SQLException{
		//Recibe un objeto de tipo opcionesDTO y retorna si la consulta eliminar se genero Correctamente
		Connection conexion =  conectar.performConnection();
		if (conexion == null){
			return false;//No hubo Conexion en la base de datos
		}
		else {
			return opcionesDao.eliminar(opcionesDTO, conexion);//Hubo conexion en la base de datos y retorna que se genero correctamente la consulta Eliminar
		}	
	}//Fin del metodo Eliminar
	
	/**
	 * El metodo revisa si hay conexion y manda los datos a la clase DAO para que Elimine	
	 * 
	 * @param OpcionesDTO
	 * @return Si se genero correctamente la Consulta Select en la clase DAO
	 */
	public boolean consultar(OpcionesTablaDTO opcionesconsultar) throws SQLException {
		//Recibe un objeto de tipo opcionesDTO y retorna si se genero la consulta Select correctamente
		
			opcionesDao.consultar(opcionesconsultar, conectar.performConnection());
			return true;
			//Si se genero Correctamente la Consulta
		
	}//Fin del metodo Consultar
	
	public ListasDTO consultaropciones() throws SQLException {
		//Recibe un objeto de tipo opcionesDTO y retorna si se genero la consulta Select correctamente
		Connection conexion =  conectar.performConnection();
		if (conexion == null){
			return null;//no hubo Conexion En la Base de Datos
		}
		else {
			ListasDTO opcioneslista=opcionesDao.consultaropciones(conexion); 
			return opcioneslista;//Si se genero Correctamente la Consulta
		}	
	}
	
	public OpcionesDTO consultaropcion(Integer opcion) throws SQLException {
		//Recibe un objeto de tipo opcionesDTO y retorna si se genero la consulta Select correctamente
		Connection conexion =  conectar.performConnection();
		if (conexion == null){
			return null;//no hubo Conexion En la Base de Datos
		}
		else {
			OpcionesDTO opcioneslista=opcionesDao.consultaropcion(conexion,opcion); 
			return opcioneslista;//Si se genero Correctamente la Consulta
		}	
	}
	
	public List<OpcionesDTO> consultarOpcionesPorAplicacion(AplicacionesDTO aplicacion, UsuariosDTO usuario){
		Connection conexion = conectar.performConnection();
		if(conexion ==null){
			return null;
		}
		else{
			return opcionesDao.consultarOpcionesPorAplicacion(aplicacion, usuario, conexion);
		}
	}

	public Boolean borrar(OpcionesDTO opcionesDTO) {
		Connection conexion = conectar.performConnection();
		if (conexion == null) {
			return false;
		} else {
			try {
				return OpcionesDAO.eliminar(opcionesDTO, conexion);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

}//Fin de la Clase OpcionesManager
