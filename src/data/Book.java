package data;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 */

public class Book extends Resources {

	private String recommendedSubject;
	private String comments;
	private String stringAttached;

	public Book(String author, String publicationDate, String licence, String id, String name, int numberItems,
			boolean status, boolean online, String image, String recommendedSubject, String comments,
			String stringAttached) {
		super(author, publicationDate, licence, id, name, numberItems, status, online, image);
		this.recommendedSubject = recommendedSubject;
		this.comments = comments;
		this.stringAttached = stringAttached;
	}

	public String getRecommendedSubject() {
		return recommendedSubject;
	}

	public void setRecommendedSubject(String recommendedSubject) {
		this.recommendedSubject = recommendedSubject;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStringAttached() {
		return stringAttached;
	}

	public void setStringAttached(String stringAttached) {
		this.stringAttached = stringAttached;
	}

}
