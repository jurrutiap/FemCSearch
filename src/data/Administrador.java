package data;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class Administrador extends Persona {

	private String dependencia;
	private String idUniversitario;

	public Administrador(String nombre, String id, String contrasena, String correoElectronico, String pic,
			String dependencia, String idUniversitario) {
		super(nombre, id, contrasena, correoElectronico, pic);
		this.dependencia = dependencia;
		this.idUniversitario = idUniversitario;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getIdUniversitario() {
		return idUniversitario;
	}

	public void setIdUniversitario(String idUniversitario) {
		this.idUniversitario = idUniversitario;
	}

	@Override
	public boolean isAdmin() {
		return true;
	}

	@Override
	public char whoAmI() {
		return '1';
	}

}
