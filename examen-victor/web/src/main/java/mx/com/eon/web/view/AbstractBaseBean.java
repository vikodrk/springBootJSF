package mx.com.eon.web.view;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public abstract class AbstractBaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3791434133119846139L;

	protected HttpSession getHttpSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		return session;
	}

	protected Object objectFromSession(String key) {
		return getHttpSession().getAttribute(key);
	}

	protected void setObjectToSession(String key, Object obj) {
		HttpSession session = getHttpSession();
		session.setAttribute(key, obj);
	}
	
	protected void removeObjectFromSession(String key) {
		HttpSession session = getHttpSession();
		session.removeAttribute(key);
	}
	
	public void redirectToHome() throws IOException {
		redirect("index");
	}

	protected void redirect(String page) throws IOException {
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
	      ctx.redirect( ctx.getRequestContextPath() +"/"+ page+".xhtml" );
	}

	protected void sendMessage(FacesMessage.Severity severity, String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, title, message));
	}
	
	protected void sendMessage(FacesMessage.Severity severity, String message) {
		sendMessage(severity,"",message);
	}
	
	protected void sendMessage(String message) {
		sendMessage(FacesMessage.SEVERITY_INFO, message);
	}

}
