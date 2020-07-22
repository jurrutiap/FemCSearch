package ui;

import java.awt.BorderLayout;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 */

public class LoginFrame extends StandardFrame {

	private static final long serialVersionUID = 1L;

	private String id, password;
	private boolean action;

	// LOGIN FRAME
	private JTextField idBox;
	private JPasswordField passBox;
	private CJButton login;
	private JLabel label1Login;
	private CJButton register;
	private JLabel label2Login;
	private CJButton exitButton;
	private JLabel wrongUserLabel;
	private JLabel picLabel;

	public LoginFrame(String name) {
		super(name);
		this.action = false;
		// PANEL
		this.setLayout(new GridLayout(3, 1));

		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new GridBagLayout());
		boxPanel.setBackground(blanco);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBackground(blanco);

		JPanel superiorPanel = new JPanel();
		superiorPanel.setBackground(blanco);
		
		JPanel mainIcon = new JPanel();
		mainIcon.setPreferredSize(new Dimension(400, 140));
		mainIcon.setBackground(blanco);

		JPanel interiorPanel = new JPanel();
		interiorPanel.setBackground(blanco);

		// COMPONENTS
		idBox = new JTextField(15);
		label1Login = new JLabel("ID: ");
		passBox = new JPasswordField();
		label2Login = new JLabel("Password: ");
		login = new CJButton("Login");
		login.setPreferredSize(new Dimension(230, 25));
		wrongUserLabel = new JLabel("Invalid User", SwingConstants.CENTER);
		wrongUserLabel.setForeground(Color.red);
		wrongUserLabel.setVisible(false);
		register = new CJButton("Register");
		register.setPreferredSize(new Dimension(290, 25));
		exitButton = new CJButton("Exit");
		
		try {
			BufferedImage myPicture = ImageIO.read(new File("resources/Artboard 2.jpg"));
			picLabel = new JLabel(new ImageIcon(myPicture));
		} catch (IOException e) {
			System.out.println("Img not found");
		}

		// ADD COMPONENTS
		boxPanel.add(label1Login, makeGbc(0, 1));
		boxPanel.add(idBox, makeGbc(1, 1));
		boxPanel.add(label2Login, makeGbc(0, 2));
		boxPanel.add(passBox, makeGbc(1, 2));
		boxPanel.add(interiorPanel, makeGbc(1, 3));
		interiorPanel.add(login);
		buttonPanel.add(wrongUserLabel, makeGbc(0, 0));
		buttonPanel.add(register, makeGbc(0, 1));
		buttonPanel.add(exitButton, makeGbc(0, 2));
		
		superiorPanel.add(mainIcon, BorderLayout.CENTER);
		
		mainIcon.add(picLabel, BorderLayout.CENTER);

		this.add(superiorPanel, BorderLayout.NORTH);
		this.add(boxPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setVisible(true);

	}
	
	public void wrongUser() {
		wrongUserLabel.setVisible(true);
	}
	
	public void clearFields() {
		idBox.setText("");
		passBox.setText("");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	public JTextField getIdBox() {
		return idBox;
	}

	public void setIdBox(JTextField idBox) {
		this.idBox = idBox;
	}

	public JTextField getPassBox() {
		return passBox;
	}

	public CJButton getLogin() {
		return login;
	}

	public void setLogin(CJButton login) {
		this.login = login;
	}

	public CJButton getregister() {
		return register;
	}

	public void setregister(CJButton register) {
		this.register = register;
	}

	public CJButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(CJButton exitButton) {
		this.exitButton = exitButton;
	}
	
	public JLabel getWrongUserLabel() {
		return wrongUserLabel;
	}

	public void setWrongUserLabel(JLabel wrongUserLabel) {
		this.wrongUserLabel = wrongUserLabel;
	}

}
