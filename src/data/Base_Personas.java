package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class Base_Personas {

	private HashMap<String, Persona> usuarios;

	public Base_Personas(HashMap<String, Persona> usuarios) {
		this.usuarios = usuarios;
	}

	public HashMap<String, Persona> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, Persona> usuarios) {
		this.usuarios = usuarios;
	}
	
	public ArrayList<Persona> toArrayList(){
		Collection<Persona> values = usuarios.values();
		ArrayList<Persona> buffer = new ArrayList<Persona>(values);
		return buffer;
	}

}
