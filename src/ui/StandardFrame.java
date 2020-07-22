package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 */

public class StandardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	protected CJButton backButton = new CJButton("Back");
	protected Color blanco = new Color(252, 254, 255);
	ImageIcon icon = new ImageIcon("resources/Small logo.jpg");

	// DISPOSICION BASICA DE CADA FRAME DEL PROGRAMA
	public StandardFrame(String name) {
		this.setSize(500, 500);
		this.setTitle(name);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected GridBagConstraints makeGbc(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.anchor = (x == 0) ? GridBagConstraints.LINE_START : GridBagConstraints.LINE_END;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		return gbc;
	}

	public CJButton getBackButton() {
		return backButton;
	}

	public void setBackButton(CJButton backButton) {
		this.backButton = backButton;
	}

}
