package seguridad.dao.Comunes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seguridad.dto.AplicacionesDTO;
import seguridad.dto.ErrorDTO;
import seguridad.dto.ListasDTO;
import seguridad.dto.OpcionesDTO;
import seguridad.dto.OpcionesTablaDTO;
import seguridad.dto.UsuariosDTO;

/**
 * OpcionesDAO
 * 
 * Me hace la consulta y le retorna a la clase manager si se genero correctamente
 * 
 *@author John Alxander Gutierrez
 */

public class OpcionesDAO {
	/* Esta Clase contiene los metodos ingresar, actualizar, eliminar y consultar la cual recibe los datos y hace la consulta y se la retorna a la clase manager */
	
	/**
	 * El metodo genera el SQL ingresar(INSERT INTO)
	 * 
	 * @param OpcionesDTO, Connection de tipo java.sql.Connection
	 * @return retorna true si el SQL se genero correctamente, de lo contrario false
	 */
	public void ingresar(OpcionesDTO opcionesDTO, Connection conection, ErrorDTO error) throws SQLException {
	//Recibe un objeto de tipo Connecion y me dice si la conexion esta correcta y objeto OpcionesDTO el cual con los datos hace el SQL insertar y retorna si se hizo correctamente la consulta
		PreparedStatement instruccion = null;  
	     try{
	    	 if (opcionesDTO.getIdOpcionPadre().compareTo("0")!=0){ 
	            String ingresar ="INSERT INTO opciones (`opcNombre`,`opcDescripcion`,`opcIconoUrlLink`,`opcEstado`,`idOpcionPadre`)";
	            ingresar+="VALUES(?,?,?,?,?)";
	            instruccion = conection.prepareStatement(ingresar);
	            instruccion.setString(1, opcionesDTO.getOpcNombre());
	            instruccion.setString(2, opcionesDTO.getOpcDescripcion());
	            instruccion.setString(3, opcionesDTO.getOpcIconoUrlLink());
	            instruccion.setString(4, opcionesDTO.getIdEstado());
            	instruccion.setString(5, opcionesDTO.getIdOpcionPadre());
            	
	    	 }
	    	 else
	    	 {
	    		 String ingresar ="INSERT INTO opciones (`opcNombre`,`opcDescripcion`,`opcIconoUrlLink`,`opcEstado`)";
		            ingresar+="VALUES(?,?,?,?)";
		            instruccion = conection.prepareStatement(ingresar);
		            instruccion.setString(1, opcionesDTO.getOpcNombre());
		            instruccion.setString(2, opcionesDTO.getOpcDescripcion());
		            instruccion.setString(3, opcionesDTO.getOpcIconoUrlLink());
		            instruccion.setString(4, opcionesDTO.getIdEstado());
		            
	    	 }
	                
	    	 instruccion.executeUpdate();   
	            error.setSNOperacion(true);//Si la conexion no se genero
				error.setMensajeUsuario("Opción Ingresada");
				error.setMensajeTecnico("el proceso de inserción OPCIONES:  "+instruccion);//Si Ingresar de Genero Correctamente
	     	}
	     catch (Exception e){
	    	    error.setSNOperacion(false);//Si la conexion no se genero
				error.setMensajeUsuario("Opción No ingresada");
				error.setMensajeTecnico("Error al ingresar en OPCIONES:  "+e.getMessage());//Error al ingresar los datos
	     	}
	}//Cierre del Metodo Ingresar
	
	/**
	 * El metodo genera el SQL Actualizar(UPDATE)
	 * 
	 * @param OpcionesDTO, Connection de tipo java.sql.Connection
	 * @return retorna true si el SQL se genero correctamente, de lo contrario false
	 */
	public boolean actualizar(OpcionesDTO actualizarDTO, Connection conection) throws SQLException{
		//Recibe un objeto de tipo Connecion y me dice si la conexion esta correcta y objeto OpcionesDTO el cual con los datos hace el SQL actualizar y retorna si se hizo correctamente la consulta
		
			String actualiza = "UPDATE `opciones` SET `opcNombre`=?, `opcDescripcion`=?, `opcIconoUrlLink`=?, `opcEstado`=?, `idOpcionPadre`=? WHERE `idOpcion`=?;";
			PreparedStatement instruccion = conection.prepareStatement(actualiza);
			instruccion.setString(1, actualizarDTO.getOpcNombre());
			instruccion.setString(2, actualizarDTO.getOpcDescripcion());
			instruccion.setString(3, actualizarDTO.getOpcIconoUrlLink());
			instruccion.setString(4, actualizarDTO.getIdEstado());
			instruccion.setString(5, actualizarDTO.getIdOpcionPadre());
			instruccion.setString(6, actualizarDTO.getIdOpcion());
			instruccion.executeUpdate();
			System.out.println(" dao");

			if (instruccion.executeUpdate() >= 1) {
				return true;//Si se actualizo Correctamente
			}
			else {
				return false;//No se Actualizo Correctamnete
			}
		}//Cierre del metodo Actualizar
	
	/**
	 * El metodo genera el SQL eliminar(DELETE)
	 * 
	 * @param OpcionesDTO, Connection de tipo java.sql.Connection
	 * @return retorna true si el SQL se genero correctamente, de lo contrario false
	 */
	public static boolean eliminar(OpcionesDTO borrarDTO, Connection conection) throws SQLException{
		//Recibe un objeto de tipo Connecion y me dice si la conexion esta correcta y objeto OpcionesDTO el cual con los datos hace el SQL Eliminar y retorna si se hizo correctamente la consulta
			String borrar = "DELETE FROM `opciones` WHERE `idOpcion` = ?;";
			PreparedStatement instruccion = conection.prepareStatement(borrar);
			instruccion.setString(1, borrarDTO.getIdOpcion());
			instruccion.executeUpdate();
			if  (instruccion.executeUpdate() >= 0) {
				return true;//Registro Eliminado
			}
			else {
				return false;//Error al Eliminar
			}	
	}//Cierre del metodo Eliminar
	
	/**
	 * El metodo genera el SQL Consultar(Select)
	 * 
	 * @param OpcionesDTO, Connection de tipo java.sql.Connection
	 * @return retorna true si el SQL se genero correctamente, de lo contrario false
	 */
public void consultar(OpcionesTablaDTO consultarTabla, Connection conection) throws SQLException{
		
		
		String consul = "SELECT * FROM  `opciones`;";
		List<OpcionesDTO> listaOpcion = new ArrayList<OpcionesDTO>();
		PreparedStatement instruccion = conection.prepareStatement(consul);
		ResultSet rs = instruccion.executeQuery();

		while (rs.next()){
			OpcionesDTO opcion = new OpcionesDTO();
			opcion.setIdOpcion(rs.getString("idOpcion"));
			opcion.setOpcNombre(rs.getString("opcNombre"));
			opcion.setOpcDescripcion(rs.getString("opcDescripcion"));
			opcion.setOpcIconoUrlLink(rs.getString("opcIconoUrlLink"));
			opcion.setIdEstado(rs.getString("opcEstado"));
			opcion.setIdOpcionPadre(rs.getString("idOpcionPadre"));
			
			listaOpcion.add(opcion);
		}

		rs.close();
		consultarTabla.setOpciones(listaOpcion);
		
	
	
	}//Cierre del Metodo Consultar
	
	/**
	 * Consulta las opciones filtrando por aplicacion.
	 * @param aplicacion
	 * @param conection
	 * @return
	 * @throws SQLException
	 */
	public List<OpcionesDTO> consultarOpcionesPorAplicacion(AplicacionesDTO aplicacion,UsuariosDTO usuario,Connection conection){
		try{
			String consul = "SELECT opciones.idOpcion,opcNombre,opcDescripcion,opcIconoUrlLink,opcEstado,idOpcionPadre FROM (SELECT idUsuario,A.idPerfil,idOpcion FROM (SELECT usuarios.idUsuario,perfilesusuarios.idPerfil FROM usuarios INNER JOIN perfilesusuarios ON usuarios.idUsuario = perfilesusuarios.idUsuario ) AS A INNER JOIN derechos ON A.idPerfil=derechos.idPerfil) AS B INNER JOIN opciones ON B.idOpcion = opciones.idOpcion where idUsuario = ? and idAplicacion = ?";
			List<OpcionesDTO> listaOpcion = new ArrayList<OpcionesDTO>();
			PreparedStatement instruccion = conection.prepareStatement(consul);
			int index = 0;
			instruccion.setLong(++index, usuario.getIdUsuario());
			instruccion.setInt(++index, aplicacion.getId());
			ResultSet rs = instruccion.executeQuery();
	
			while (rs.next()){
				OpcionesDTO opcion = new OpcionesDTO();
				opcion.setIdOpcion(rs.getString("idOpcion"));
				opcion.setOpcNombre(rs.getString("opcNombre"));
				opcion.setOpcDescripcion(rs.getString("opcDescripcion"));
				opcion.setOpcIconoUrlLink(rs.getString("opcIconoUrlLink"));
				opcion.setIdEstado(rs.getString("opcEstado"));
				opcion.setIdOpcionPadre(rs.getString("idOpcionPadre"));
				
				listaOpcion.add(opcion);
			}
			rs.close();
			return listaOpcion;
		}
		catch(Exception e){
			return null;
			
		}
	
	}
	public ListasDTO consultaropciones( Connection conection) throws SQLException{
			
			
			String consul = "SELECT `idOPcion`,`opcNombre` FROM `opciones`;";
			ListasDTO	opclista = new ListasDTO();
			
			Map<String,String> listaopciones = new HashMap<String, String>();
			PreparedStatement instruccion = conection.prepareStatement(consul);
			ResultSet rs = instruccion.executeQuery();
			//cities = new HashMap<String, String>();
			
	
			while (rs.next()){
				OpcionesDTO opcion = new OpcionesDTO();
				opcion.setIdOpcion(rs.getString("idOpcion"));
				opcion.setOpcNombre(rs.getString("opcNombre"));
			
				listaopciones.put(rs.getString("opcNombre"),rs.getString("opcNombre"));
			}
	
			rs.close();
		    opclista.setListaopciones(listaopciones);//Retorna la lista Consultar
		    return opclista;
		
	}

	public OpcionesDTO consultaropcion(Connection conexion, Integer opcion) {
		// TODO Auto-generated method stub
		return null;
	}

}//Fin de la Clase OpciondesDAO
