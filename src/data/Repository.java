package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 */

public class Repository {
	private HashMap<String, Resources> colection;
	
	public Repository(HashMap<String, Resources> colection) {
		this.colection = colection;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<Resources> getCol() {
		Iterator it1 = colection.entrySet().iterator();
		ArrayList<Resources> print = new ArrayList<Resources>();
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry) it1.next();
			String k = (String) pair.getKey();
			Resources te = colection.get(k);
			print.add(te);
		}
		return print;
	}

	public void addToColection(Resources r) {
		colection.put(r.getId(), r);
	}
	
	public HashMap<String, Resources> getColection() {
		return colection;
	}

	public void setColection(HashMap<String, Resources> colection) {
		this.colection = colection;
	}

}
