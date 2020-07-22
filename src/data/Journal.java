package data;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 */

public class Journal extends Resources {
	// private ArrayList<String> department;
	private String department, volume;

	public Journal(String author, String publicationDate, String licence, String id, String name, int numberItems,
			boolean status, boolean online, String image, String department, String volume) {
		super(author, publicationDate, licence, id, name, numberItems, status, online, image);
		this.department = department;
		this.volume = volume;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
