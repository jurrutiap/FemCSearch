package businessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import data.*;
import data.Resources;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 */

public class ContentsReader {
	private String fileName;
	private HashMap<String, Resources> colections;

	public ContentsReader(String fileName) {
		this.fileName = fileName;
		this.colections = new HashMap<String, Resources>();
		this.readingData();
	}

	private Resources processLine(String line) throws FileFormatException, NumberFormatException {
		StringTokenizer st = new StringTokenizer(line, ",");
		int numTokens = st.countTokens();
		Scanner sc = new Scanner(line);
		sc.useDelimiter(",");

		Resources it = null;

		String category = sc.next().trim().toLowerCase();
		String author = sc.next().trim();
		String dateOfPublication = sc.next().trim();
		String licence = sc.next().trim();
		String id = sc.next().trim();
		String name = sc.next().trim();
		int items = Integer.parseInt(sc.next().trim());
		boolean status = Boolean.parseBoolean(sc.next().trim());
		boolean online = Boolean.parseBoolean(sc.next().trim());
		String image = sc.next().trim();

		switch (category) {
		case "book":
			if (numTokens != 13) {
				sc.close();
				throw new FileFormatException("Incomplete number of tokens --   " + line);
			}
			String recommendedSubject = sc.next().trim();
			String comments = sc.next().trim();
			String linkDocAttached = sc.next().trim();

			it = new Book(author, dateOfPublication, licence, id, name, items, status, online, image,
					recommendedSubject, comments, linkDocAttached);

			break;
		case "journal":
			if (numTokens != 12) {
				sc.close();
				throw new FileFormatException("Incomplete number of tokens --   " + line);
			}
			String department = sc.next().trim();
			String volume = sc.next().trim();
			it = new Journal(author, dateOfPublication, licence, id, name, items, status, online, image,
					department, volume);
			break;
		case "paper":
			if (numTokens != 11) {
				sc.close();
				throw new FileFormatException("Incomplete number of tokens --   " + line);
			}
			String attached = sc.next().trim();
			it = new Paper(author, dateOfPublication, licence, id, name, items, status, online, image, attached);
			break;
		default:
			System.out.println("Category " + category + " unknown");
		}
		sc.close();
		return it;
	}

	public void readResources(Scanner sc) {
		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.trim().isEmpty()) {
				continue;
			}
			String category = line.substring(0, line.indexOf(',')).toLowerCase();
			if (!category.equalsIgnoreCase("book") && !category.equalsIgnoreCase("journal")
					&& !category.equalsIgnoreCase("paper")) {
				System.out.println("Category '" + category + "' unknown --   " + line);
				continue;
			} else {
				Resources it;
				try {
					it = processLine(line);
					colections.put(it.getId(), it);
				} catch (FileFormatException e) {
					System.out.println(e.getMessage());
				} catch (NumberFormatException e) {
					String errMsg = e.getMessage();
					StringTokenizer st = new StringTokenizer(errMsg, ":");
					st.nextToken();
					System.out.println("Incorrect numeric token " + st.nextToken() + " --   " + line);
				}
			}

		}

	}

	public void readingData() {
		fileName = checkFileName(fileName);
		File inFile = new File(fileName);
		try {
			Scanner in = new Scanner(inFile);
			readResources(in);
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found - " + fileName);
			System.exit(0);
		}
	}

	public String checkFileName(String fileName) {
		if (fileName.contains(".") == false)
			fileName = fileName + ".txt";
		else if (fileName.contains(".txt") == false)
			fileName = fileName.substring(0, fileName.indexOf('.')) + ".txt";
		return fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public HashMap<String, Resources> getColections() {
		return colections;
	}

	public void setColections(HashMap<String, Resources> colections) {
		this.colections = colections;
	}

}
