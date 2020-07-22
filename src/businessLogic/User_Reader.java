package businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import data.Administrador;
import data.Estudiante;
import data.Persona;
import data.Profesor;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class User_Reader {

	private String fileName;
	private HashMap<String, Persona> usuarios;
	private ArrayList<Persona> rawList;

	public User_Reader(String inputFile) {
		this.fileName = inputFile;
		this.usuarios = new HashMap<String, Persona>();
		this.readUserData();
	}

	public void readUserData() {
		fileName = checkFileName(fileName);
		File inFile = new File(fileName);
		try {
			Scanner in = new Scanner(inFile);
			readUser(in);
			in.close();
			rawList = toArrayList(usuarios);
		} catch (FileNotFoundException e) {
			// INTERFAZ GRAFICA: IMPRIME QUE NO ENCONTRO EL ARCHIVO
		}
	}

	public String checkFileName(String fileName) {
		if (fileName.contains(".") == false)
			fileName = fileName + ".txt";
		else if (fileName.contains(".txt") == false)
			fileName = fileName.substring(0, fileName.indexOf('.')) + ".txt";
		return fileName;
	}

	private void readUser(Scanner in) {
		while (in.hasNext()) {
			String line = in.nextLine();
			Persona p = processUserData(line);
			addUser(p);
		}
	}

	private Persona processUserData(String line) {
		Scanner sc = new Scanner(line);
		sc.useDelimiter(",");
		Persona p = null;
		String categoria = sc.next().trim().toLowerCase();
		String nombre = sc.next().trim();
		String correoElectronico = sc.next().trim();
		String contrasena = sc.next().trim();
		String id = sc.next().trim();
		String pic = sc.next().trim();
		switch (categoria) {
		case "admin":
			String dependencia = sc.next().trim();
			String idUniversitario = sc.next().trim();
			p = new Administrador(nombre, id, contrasena, correoElectronico, pic, dependencia, idUniversitario);
			break;
		case "estudiante":
			String carrera = sc.next().trim();
			idUniversitario = sc.next().trim();
			p = new Estudiante(nombre, id, contrasena, correoElectronico, pic, carrera, idUniversitario);
			break;
		case "profesor":
			String departamento = sc.next().trim();
			String tipo = sc.next().trim();
			idUniversitario = sc.next().trim();
			p = new Profesor(nombre, id, contrasena, correoElectronico, pic, departamento, tipo, idUniversitario);
			break;
		default:
			
			break;
		}
		sc.close();
		return p;
	}

	public ArrayList<Persona> toArrayList(HashMap<String, Persona> c) {
		Collection<Persona> values = c.values();
		ArrayList<Persona> buffer = new ArrayList<Persona>(values);
		return buffer;
	}

	private void addUser(Persona p) {
		usuarios.put(p.getId(), p);
	}

	public HashMap<String, Persona> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(HashMap<String, Persona> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Persona> getRawList() {
		return rawList;
	}

	public void setRawList(ArrayList<Persona> rawList) {
		this.rawList = rawList;
	}

}
