package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class MenuFrame extends StandardFrame {

	private static final long serialVersionUID = 1L;

	// EMERGENT FRAME
	private CJButton profile;
	private CJButton search;
	private CJButton addBook;
	private CJButton endSession;

	public MenuFrame(String name) {
		super(name);
		this.setLayout(new GridLayout(3, 1));

		// PANEL
		JPanel superiorPanel = new JPanel();
		superiorPanel.setBackground(blanco);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBackground(blanco);

		JPanel inferiorPanel = new JPanel();
		inferiorPanel.setBackground(blanco);

		// COMPONENTS
		profile = new CJButton("Profile");
		profile.setPreferredSize(new Dimension(230, 25));
		search = new CJButton("Search");
		addBook = new CJButton("Add Book");
		endSession = new CJButton("Sign Out");

		// ADD COMPONENTS
		buttonPanel.add(profile, makeGbc(0, 0));
		buttonPanel.add(search, makeGbc(0, 1));
		buttonPanel.add(addBook, makeGbc(0, 2));
		buttonPanel.add(endSession, makeGbc(0, 3));

		this.add(superiorPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.add(inferiorPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public CJButton getProfile() {
		return profile;
	}

	public void setProfile(CJButton profile) {
		this.profile = profile;
	}

	public CJButton getSearch() {
		return search;
	}

	public void setSearch(CJButton search) {
		this.search = search;
	}

	public CJButton getAddBook() {
		return addBook;
	}

	public void setAddBook(CJButton addBook) {
		this.addBook = addBook;
	}

	public CJButton getEndSession() {
		return endSession;
	}

	public void setEndSession(CJButton endSession) {
		this.endSession = endSession;
	}

	public void notAdminUser() {
		addBook.setEnabled(false);
	}

}
