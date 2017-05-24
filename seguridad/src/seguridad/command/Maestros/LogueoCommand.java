package seguridad.command.Maestros;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import seguridad.command.Comunes.MessagesController;
import seguridad.dto.LogueoDTO;
import seguridad.dto.UsuariosDTO;
import seguridad.manager.LogueoManager;

@ManagedBean
@SessionScoped
public class LogueoCommand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7961687019004774779L;
	Boolean logeado = false;
    
	public boolean estaLogeado() {
		return logeado;
	}
	public void logueo(LogueoDTO usuario) throws Exception{

		LogueoManager logueoManager = new LogueoManager();
		MessagesController ms= new MessagesController();
		RequestContext context = RequestContext.getCurrentInstance();
		
	
		FacesMessage msg = null;
		
		if (usuario.getUsuario().getUsuNombre() != "" && usuario.getUsuario().getUsuPassword()!= "")
		{
			UsuariosDTO usuarioLogueado = logueoManager.loguear(usuario);
			if(usuarioLogueado!=null){
			    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuarioLogueado.getUsuNombre());
			    HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("logeado", true);
                httpSession.setAttribute("usuario", usuarioLogueado);
                usuario.setUsuario(usuarioLogueado);
			    logeado=true;
			 
			  } else {
			      msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas");
			  }
			    FacesContext.getCurrentInstance().addMessage(null, msg);
			    context.addCallbackParam("estaLogeado", logeado);
			    if (logeado) {
			      HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			      String url = (String) httpSession.getAttribute("menu.xhtml");
			      context.addCallbackParam("view", url);
			  }
		}
		else{
			ms.addError(null,"Intentar nuevamente");
		}
/*
 * Correccion error Ingreso al menù, reportado por camilo17746 23/05/17 Por:Maria Isabel Rincon
 * Ahora cuando el usuario inicia sesion, se redirige a menu.xhtml
 */
	     FacesContext contex = FacesContext.getCurrentInstance();
         contex.getExternalContext().redirect( "/seguridad/faces/menu.xhtml" );
	}

	public void logout() {
	    HttpSession session = (HttpSession) FacesContext.getCurrentInstance() .getExternalContext().getSession(false);
	    session.invalidate();
	    HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	    httpSession.setAttribute("logeado", true);
	    logeado = false;
	  }	
}