package businessLogic;

import java.util.HashMap;
import data.Persona;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class VerificadorIdentidad {
	private boolean loginStatus;
	private Persona usuarioActivo;
	private boolean overrided;

	public void verificarIdentidad(String id, String contrasena, HashMap<String, Persona> usuarios) {
		if (usuarios.containsKey(id)) {
			Persona p = usuarios.get(id);
			if (p.getContrasena().equals(contrasena)) {
				this.loginStatus = true;
				this.usuarioActivo = p;
			}
		} else {
			this.loginStatus = false;
		}
	}

	public VerificadorIdentidad() {
		this.loginStatus = false;
		this.usuarioActivo = null;
	}

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Persona getUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(Persona usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

	public boolean isOverrided() {
		return overrided;
	}

	public void setOverrided(boolean overrided) {
		this.overrided = overrided;
	}

}
