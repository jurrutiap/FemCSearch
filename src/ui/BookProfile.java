package ui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class BookProfile extends StandardFrame {

	private static final long serialVersionUID = 1L;

	// PROFILE FRAME
	private JLabel nameLabel;
	private JLabel authorLabel;
	private JLabel pdateLabel;
	private JLabel codeBookLabel;
	private JLabel picLabel;

	private CJButton getBookButton;
	// private CJButton suggestBookButton;
	private CJButton addCommentButton;
	private CJButton seeCommentsButton;

	public BookProfile(String name, String author, String pdate, String codeBook, String picturePath) {
		super(name);
		this.setLayout(new GridLayout(2, 2));

		// PANEL
		JPanel datosPanel = new JPanel();
		datosPanel.setBackground(blanco);
		datosPanel.setLayout(new GridBagLayout());

		JPanel photoPanel = new JPanel();
		photoPanel.setBackground(blanco);

		JPanel puntajePanel = new JPanel();
		puntajePanel.setBackground(blanco);
		puntajePanel.setLayout(new GridBagLayout());

		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(blanco);

		// COMPONENTES
		nameLabel = new JLabel("Name: " + name);
		authorLabel = new JLabel("Author: " + author);
		pdateLabel = new JLabel("Date of Publication: " + pdate);
		codeBookLabel = new JLabel("ISSBN: " + codeBook);

		getBookButton = new CJButton("Get Book");
		getBookButton.setPreferredSize(new Dimension(230, 25));
		// suggestBookButton = new CJButton("Suggest Book");
		addCommentButton = new CJButton("Add Comment");
		seeCommentsButton = new CJButton("See Comments");
		backButton = new CJButton("Back");

		try {
			BufferedImage myPicture = ImageIO.read(new File("resources/" + picturePath + ".png"));
			picLabel = new JLabel(new ImageIcon(myPicture));
		} catch (IOException e) {
			System.out.println("Img not found");
		}

		// ADD COMPONENTS
		datosPanel.add(nameLabel, makeGbc(0, 2));
		datosPanel.add(authorLabel, makeGbc(0, 3));
		datosPanel.add(pdateLabel, makeGbc(0, 4));
		datosPanel.add(codeBookLabel, makeGbc(0, 5));

		puntajePanel.add(getBookButton, makeGbc(0, 1));
		// puntajePanel.add(suggestBookButton, makeGbc(0, 2));
		puntajePanel.add(addCommentButton, makeGbc(0, 2));
		puntajePanel.add(seeCommentsButton, makeGbc(0, 3));
		puntajePanel.add(backButton, makeGbc(0, 4));

		photoPanel.add(picLabel, BorderLayout.CENTER);

		this.add(datosPanel);
		this.add(photoPanel);
		this.add(puntajePanel);
		this.add(logoPanel);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getAuthorLabel() {
		return authorLabel;
	}

	public void setAuthorLabel(JLabel authorLabel) {
		this.authorLabel = authorLabel;
	}

	public JLabel getPdateLabel() {
		return pdateLabel;
	}

	public void setPdateLabel(JLabel pdateLabel) {
		this.pdateLabel = pdateLabel;
	}

	public JLabel getCodeBookLabel() {
		return codeBookLabel;
	}

	public void setCodeBookLabel(JLabel codeBookLabel) {
		this.codeBookLabel = codeBookLabel;
	}

	public CJButton getGetBookButton() {
		return getBookButton;
	}

	public void setGetBookButton(CJButton getBookButton) {
		this.getBookButton = getBookButton;
	}

	public CJButton getAddCommentButton() {
		return addCommentButton;
	}

	public void setAddCommentButton(CJButton addCommentButton) {
		this.addCommentButton = addCommentButton;
	}

	public CJButton getSeeCommentsButton() {
		return seeCommentsButton;
	}

	public void setSeeCommentsButton(CJButton seeCommentsButton) {
		this.seeCommentsButton = seeCommentsButton;
	}

}