package data;

import java.util.ArrayList;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public abstract class Persona {

	protected String nombre;
	protected String id;
	protected String contrasena;
	protected String correoElectronico;
	protected String picturePath;
	protected ArrayList<Resources> personResources;

	public Persona(String nombre, String id, String contrasena, String correoElectronico, String picture) {
		this.nombre = nombre;
		this.id = id;
		this.contrasena = contrasena;
		this.correoElectronico = correoElectronico;
		this.picturePath = picture;
		this.personResources = new ArrayList<Resources>();
	}
	
	public abstract boolean isAdmin();
	
	public abstract char whoAmI();
	
	public void addResour(Resources e) {
		personResources.add(e);
	}
	
	public ArrayList<Resources> getPersonResources() {
		return personResources;
	}

	public void setPersonResources(ArrayList<Resources> personResources) {
		this.personResources = personResources;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}
