package data;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class Estudiante extends Persona {

	private String carrera;
	private String idUniversitario;

	public Estudiante(String nombre, String id, String contrasena, String correoElectronico, String pic, String carrera,
			String idUniversitario) {
		super(nombre, id, contrasena, correoElectronico, pic);
		this.carrera = carrera;
		this.idUniversitario = idUniversitario;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getIdUniversitario() {
		return idUniversitario;
	}

	public void setIdUniversitario(String idUniversitario) {
		this.idUniversitario = idUniversitario;
	}

	@Override
	public boolean isAdmin() {
		return false;
	}

	@Override
	public char whoAmI() {
		return '2';
	}

}
