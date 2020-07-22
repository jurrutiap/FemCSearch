package data;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class Profesor extends Persona {

	private String departamento;
	private String tipo;
	private String idUniversitario;

	public Profesor(String nombre, String id, String contrasena, String correoElectronico, String pic, String departamento,
			String tipo, String idUniversitario) {
		super(nombre, id, contrasena, correoElectronico, pic);
		this.departamento = departamento;
		this.tipo = tipo;
		this.idUniversitario = idUniversitario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return '3';
	}

}
