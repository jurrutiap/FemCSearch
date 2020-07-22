package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import data.Resources;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class ProfileFrame extends StandardFrame {

	private static final long serialVersionUID = 1L;

	// PROFILE FRAME
	private JLabel personalInformation;
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel bookLabel;
	private JLabel readerScoreLabel;
	private JLabel labelVacia;
	private JLabel picLabel;
	@SuppressWarnings("rawtypes")
	private JList myElements;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ProfileFrame(String name, String username, String id, String picturePath, Vector<Resources> items) {
		super(name);

		// PANEL
		JPanel superiorPanel = new JPanel();
		superiorPanel.setBackground(blanco);
		superiorPanel.setPreferredSize(new Dimension(350, 10));

		JPanel datosPanel = new JPanel();
		datosPanel.setBackground(blanco);
		datosPanel.setLayout(new GridBagLayout());

		JPanel puntajePanel = new JPanel();
		puntajePanel.setBackground(blanco);
		puntajePanel.setLayout(new GridBagLayout());

		// COMPONENTES
		myElements = new JList(items);
		myElements.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		myElements.setLayoutOrientation(JList.VERTICAL);
		myElements.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(myElements);
		listScroller.setPreferredSize(new Dimension(250, 100));
		listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		personalInformation = new JLabel("Datos personales", SwingConstants.CENTER);
		personalInformation.setFont(new Font("Serif", Font.BOLD, 23));
		nameLabel = new JLabel("Name: " + username, SwingConstants.CENTER);
		idLabel = new JLabel("ID: " + id, SwingConstants.CENTER);
		readerScoreLabel = new JLabel("Reader Score: 0", SwingConstants.CENTER);
		backButton.setPreferredSize(new Dimension(230, 25));
		labelVacia = new JLabel(" ");
		bookLabel = new JLabel("Reserved Books:");

		try {
			BufferedImage myPicture = ImageIO.read(new File("resources/" + picturePath + ".png"));
			picLabel = new JLabel(new ImageIcon(myPicture));
		} catch (IOException e) {
			System.out.println("Img not found");
		}

		// ADD COMPONENTS
		datosPanel.add(picLabel, makeGbc(0, 0));
		datosPanel.add(personalInformation, makeGbc(0, 1));
		datosPanel.add(labelVacia, makeGbc(0, 2));
		datosPanel.add(nameLabel, makeGbc(0, 3));
		datosPanel.add(idLabel, makeGbc(0, 4));
		// datosPanel.add(careerLabel, makeGbc(0, 5));
		datosPanel.add(labelVacia, makeGbc(0, 5));

		if (myElements.getModel().getSize() > 0) {
			datosPanel.add(bookLabel, makeGbc(0, 6));
			datosPanel.add(listScroller, makeGbc(0, 7));
		}

		datosPanel.add(readerScoreLabel, makeGbc(0, 8));
		puntajePanel.add(backButton, makeGbc(0, 0));

		this.add(superiorPanel, BorderLayout.NORTH);
		this.add(datosPanel, BorderLayout.CENTER);
		this.add(puntajePanel, BorderLayout.SOUTH);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}

	@SuppressWarnings("rawtypes")
	public JList getMyElements() {
		return myElements;
	}

	@SuppressWarnings("rawtypes")
	public void setMyElements(JList myElements) {
		this.myElements = myElements;
	}
}
