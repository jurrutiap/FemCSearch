package businessLogic;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;

import data.Administrador;
import data.Base_Personas;
import data.Book;
import data.Estudiante;
import data.Journal;
import data.Paper;
import data.Persona;
import data.Profesor;
import data.Repository;
import data.Resources;
import ui.AddBookFrame;
import ui.LoginFrame;
import ui.RegisterFrame;
import ui.SearchFrame;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class Controller {

	private static FileWriter fl;
	private static FileWriter fr;

	// LOGIN FRAME
	public static void loginMethod(LoginFrame f, VerificadorIdentidad v, Base_Personas usuarios) {
		String id = f.getIdBox().getText();
		String password = f.getPassBox().getText();
		v.verificarIdentidad(id, password, usuarios.getUsuarios());
	}
	
	public static boolean verificador(RegisterFrame f) {
		boolean correctness = true;
		if(!checkText(f.getname().getText())){
			f.getLabel1().setForeground(Color.red);
			correctness = false;
		}
		if(!checkMail(f.getcorreo().getText())){
			f.getLabel2().setForeground(Color.red);
			correctness = false;
		}
		if(f.getcontrasena().getText().isEmpty()){
			f.getLabel3().setForeground(Color.red);
			correctness = false;
		}
		if(!checkNumbers(f.getid().getText())){
			f.getLabel4().setForeground(Color.red);
			correctness = false;
		}
		if(!checkNumbers(f.getidUniversitario().getText())){
			f.getLabel6().setForeground(Color.red);
			correctness = false;
		}
		return correctness;
	}

	public static Persona addUserMethod(RegisterFrame f) {
		Persona p = null;
		String categoria = (String)f.getcategoria();
		String nombre = f.getname().getText();
		String correoElectronico = f.getcorreo().getText();
		String contrasena = f.getcontrasena().getText();
		String id = f.getid().getText();
		String pic = "image1";
		String idUniversitario = f.getidUniversitario().getText();
		switch (categoria) {
		case "Administrator":
			String dependencia = f.getdependencia().getText();
			p = new Administrador(nombre, id, contrasena, correoElectronico, pic, dependencia, idUniversitario);
			break;
		case "Student":
			String carrera = f.getcarrera().getText();
			p = new Estudiante(nombre, id, contrasena, correoElectronico, pic, carrera, idUniversitario);
			break;
		case "Teacher":
			String departamento = f.getdepartamento().getText();
			String tipo = f.gettipo().getText();
			p = new Profesor(nombre, id, contrasena, correoElectronico, pic, departamento, tipo, idUniversitario);
			break;
		default:
			
			break;
		}
		return p;
	}
	
	private static boolean checkNumbers(String s) {
		if (s.isEmpty()) {
			return false;
		}
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if ((Character.isDigit(s.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkText(String s) {
		if (s.isEmpty()) {
			return false;
		}
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if ((Character.isLetter(s.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkMail(String line) {
		int arroba = 0, aFail = 0, punto = 0, pFail = 0, lFail = 0;
		int len = line.length();
		for (int i = 0; i < len; i++) {
			if (line.charAt(i) == '@') {
				arroba++;
			}
		}
		if (arroba != 1) {
			aFail++;
		}
		for (int i = 0; i < len; i++) {
			if (line.charAt(i) == '.') {
				punto++;
			}
		}
		if (punto < 1) {
			pFail++;
		}
		if (aFail != 0 || pFail != 0 || lFail != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	private static boolean checkBoolean(String line) {
		if(line.equalsIgnoreCase("yes") || line.equalsIgnoreCase("no")) {
			return true;
		}else return false;
	}
	
	public static boolean registerVerify(AddBookFrame f) {
		boolean correctness = true;
		if(!checkText(f.getAuthor().getText())) {
			correctness = false;
			f.getLabel2AddBook().setForeground(Color.red);
		}
		if(!checkNumbers(f.getpDate().getText())) {
			correctness = false;
			f.getLabel3AddBook().setForeground(Color.red);
		}
		if(!checkText(f.getLicence().getText())) {
			correctness = false;
			f.getLabel6AddBook().setForeground(Color.red);
		}
		if(!checkNumbers(f.getNumeroEjemplares().getText())) {
			correctness = false;
			f.getLabel8AddBook().setForeground(Color.red);
		}
		if(!checkBoolean(f.getOnline().getText())) {
			correctness = false;
			f.getLabel9AddBook().setForeground(Color.red);
		}
		if(!checkBoolean(f.getStatus().getText())) {
			correctness = false;
			f.getLabel10AddBook().setForeground(Color.red);
		}
		return correctness;
	}
	

	// MENU FRAME
	public static Resources addResource(AddBookFrame f) {
		Resources r = null;
		String categoria = (String)f.getcategoria();
		String author = f.getAuthor().getText();
		String date = f.getpDate().getText();
		String licence = f.getLicence().getText();
		String issbn = f.getIssbn().getText();
		String name = f.getNam().getText();
		boolean status;
		boolean online;
		String pic = "standardbook";
		int items = Integer.parseInt(f.getNumeroEjemplares().getText());
		if(f.getStatus().getText().equalsIgnoreCase("yes")) {
			status = true;
		}else {
			status = false;
		}
		if(f.getOnline().getText().equalsIgnoreCase("yes")) {
			online = true;
		}else {
			online = false;
		}
		switch (categoria) {
		case "Book":
			String subject = f.getSubject().getText();
			String recommended = f.getRecommended().getText();
			String link = f.getStringAttached().getText();
			r = new Book(author, date, licence, issbn, name, items, status, online, pic, subject, recommended, link);
			break;
		case "Paper":
			link = f.getStringAttached().getText();
			r = new Paper(author, date, licence, issbn, name, items, status, online, pic, link);
			break;
		case "Journal":
			String department = f.getDepartment().getText();
			String volume = f.getDepartment().getText();
			r = new Journal(author, date, licence, issbn, name, items, status, online, pic, department, volume);
			break;
		default:
			break;
		}
		return r;
	}
	
	// SEARCH FRAME
	public static Vector<Resources> searchMethod(SearchFrame f, Repository cb) {
		String filter = f.getFilter().getText();
		String aut = f.getByAuthor().getText();
		String na = f.getByName().getText();

		ArrayList<Resources> a = Resources.search(filter, na, aut, cb);
		Vector<Resources> items = new Vector<>();
		for (Resources entry : a) {
			items.add(entry);
		}
		return items;
	}

	public static Vector<Resources> upMyResources(Persona p) {
		ArrayList<Resources> a = p.getPersonResources();
		Vector<Resources> items = new Vector<>();
		for (Resources entry : a) {
			items.add(entry);
		}
		return items;
	}

	// GENERAL
	public static void changeView(JFrame remove, JFrame show) {
		remove.dispose();
		show.setVisible(true);
	}

	public static void updateRepository(ArrayList<Resources> updated) throws IOException {

		fr = new FileWriter("Repository.txt");
		PrintWriter outR = new PrintWriter(fr);
		String type;

		for (int i = 0; i < updated.size(); i++) {

			type = updated.get(i).getClass().getName().toLowerCase();

			switch (type) {

			case "data.book":
				outR.print("Book,");
				outR.print(updated.get(i).getAuthor() + ",");
				outR.print(updated.get(i).getPublicationDate() + ",");
				outR.print(updated.get(i).getLicence() + ",");
				outR.print(updated.get(i).getId() + ",");
				outR.print(updated.get(i).getName() + ",");
				outR.print(updated.get(i).getNumberItems() + ",");
				outR.print(updated.get(i).isStatus() + ",");
				outR.print(updated.get(i).isOnline() + ",");
				outR.print(updated.get(i).getImage() + ",");
				outR.print(((Book) updated.get(i)).getRecommendedSubject() + ",");
				outR.print(((Book) updated.get(i)).getComments() + ",");
				outR.println(((Book) updated.get(i)).getStringAttached() + ",");
				break;

			case "data.journal":
				outR.print("Journal,");
				outR.print(updated.get(i).getAuthor() + ",");
				outR.print(updated.get(i).getPublicationDate() + ",");
				outR.print(updated.get(i).getLicence() + ",");
				outR.print(updated.get(i).getId() + ",");
				outR.print(updated.get(i).getName() + ",");
				outR.print(updated.get(i).getNumberItems() + ",");
				outR.print(updated.get(i).isStatus() + ",");
				outR.print(updated.get(i).isOnline() + ",");
				outR.print(updated.get(i).getImage() + ",");
				outR.print(((Journal) updated.get(i)).getDepartment() + ",");
				outR.println(((Journal) updated.get(i)).getVolume() + ",");
				break;

			case "data.paper":
				outR.print("Paper,");
				outR.print(updated.get(i).getAuthor() + ",");
				outR.print(updated.get(i).getPublicationDate() + ",");
				outR.print(updated.get(i).getLicence() + ",");
				outR.print(updated.get(i).getId() + ",");
				outR.print(updated.get(i).getName() + ",");
				outR.print(updated.get(i).getNumberItems() + ",");
				outR.print(updated.get(i).isStatus() + ",");
				outR.print(updated.get(i).isOnline() + ",");
				outR.print(updated.get(i).getImage() + ",");
				outR.println(((Paper) updated.get(i)).getStringAttached() + ",");
				break;
			default:
				break;
			}
		}
		outR.close();
	}

	public static void updateUsers(ArrayList<Persona> users) throws IOException {
		fl = new FileWriter("Persons.txt");
		PrintWriter out = new PrintWriter(fl);

		for (Persona i : users) {
			char identifier = i.whoAmI();
			switch (identifier) {
			case '1':
				out.print("admin,");
				out.print(i.getNombre() + ",");
				out.print(i.getCorreoElectronico() + ",");
				out.print(i.getContrasena() + ",");
				out.print(i.getId() + ",");
				out.print(i.getPicturePath() + ",");
				out.print(((Administrador) i).getDependencia() + ",");
				out.println(((Administrador) i).getIdUniversitario());
				System.out.println("I'm Tyrone!");
				break;
			case '2':
				out.print("estudiante,");
				out.print(i.getNombre() + ",");
				out.print(i.getCorreoElectronico() + ",");
				out.print(i.getContrasena() + ",");
				out.print(i.getId() + ",");
				out.print(i.getPicturePath() + ",");
				out.print(((Estudiante) i).getCarrera() + ",");
				out.println(((Estudiante) i).getIdUniversitario());
				System.out.println("I'm Tasha!");
				break;
			case '3':
				out.print("profesor,");
				out.print(i.getNombre() + ",");
				out.print(i.getCorreoElectronico() + ",");
				out.print(i.getContrasena() + ",");
				out.print(i.getId() + ",");
				out.print(i.getPicturePath() + ",");
				out.print(((Profesor) i).getDepartamento() + ",");
				out.print(((Profesor) i).getTipo() + ",");
				out.println(((Profesor) i).getIdUniversitario());
				System.out.println("I'm Uniqua!");
				break;
			default:
				System.out.println("I'm Pablo!");
				break;
			}
		}
		out.close();
	}

	public static boolean openWebpage(String path) {
		URI uri = URI.create(convertToFileURL(path));
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private static String convertToFileURL(String filename) {

		String path = new File(filename).getAbsolutePath();
		if (File.separatorChar != '/') {
			path = path.replace(File.separatorChar, '/');
		}
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		String retVal = "file:" + path;

		return retVal;
	}
}
