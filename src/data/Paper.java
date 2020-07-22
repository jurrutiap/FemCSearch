package data;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 */

public class Paper extends Resources {

	private String stringAttached;

	public Paper(String author, String publicationDate, String licence, String id, String name, int numberItems,
			boolean status, boolean online, String image, String stringAttached) {
		super(author, publicationDate, licence, id, name, numberItems, status, online, image);
		this.stringAttached = stringAttached;
	}

	public String getStringAttached() {
		return stringAttached;
	}

	public void setStringAttached(String stringAttached) {
		this.stringAttached = stringAttached;
	}

}
