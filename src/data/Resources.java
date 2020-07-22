package data;

import java.io.File;
import java.util.ArrayList;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 */

public class Resources {
	protected String publicationDate;// Check, Date variable!!
	protected String id, name, licence, author, image;
	protected int numberItems;
	protected boolean status, online;
	protected File commentsFile;

	public Resources(String author, String publicationDate, String licence, String id, String name, int numberItems,
			boolean status, boolean online, String image) {
		this.publicationDate = publicationDate;
		this.id = id;
		this.name = name;
		this.licence = licence;
		this.author = author;
		this.numberItems = numberItems;
		this.status = status;
		this.online = online;
		this.image = image;
	}

	public Resources(String author, String publicationDate, String licence, String id, String name, int numberItems,
			boolean status, boolean online) {
		this.publicationDate = publicationDate;
		this.id = id;
		this.name = name;
		this.licence = licence;
		this.author = author;
		this.numberItems = numberItems;
		this.status = status;
		this.online = online;
	}

	public static ArrayList<Resources> search(String filter, String name, String author, Repository repo) {

		ArrayList<Resources> col = repo.getCol();
		ArrayList<Resources> found = new ArrayList<Resources>();
		for (Resources l : col) {
			if ((!name.isEmpty() && l.getName().contains(name.toLowerCase()))
					|| (!author.isEmpty() && l.getAuthor().contains(author.toLowerCase()))
					|| (!filter.isEmpty() && l.toString().contains(filter.toLowerCase()))) {
				found.add(l);
			}
		}
		return found;
	}

	public File getCommentsFile() {
		return commentsFile;
	}

	public void setCommentsFile(File commentsFile) {
		this.commentsFile = commentsFile;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void numItemsMinusOne() {
		numberItems--;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberItems() {
		return numberItems;
	}

	public void setNumberItems(int numberItems) {
		this.numberItems = numberItems;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	@Override
	public String toString() {
		return name + ", " + author + ", Items: " + numberItems + " -- Available Online: " + online;
	}

}
