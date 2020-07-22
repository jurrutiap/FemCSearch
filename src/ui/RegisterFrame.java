package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class RegisterFrame extends StandardFrame {

	private static final long serialVersionUID = 1L;

	// ADD BOOK FRAME
	private CJButton add;
	private JTextField name;
	private JComboBox<String> categoria;
	private JTextField correo;
	private JTextField contrasena;
	private JTextField id;
	private JTextField dependencia;
	private JTextField idUniversitario;
	private JTextField carrera;
	private JTextField departamento;
	private JTextField tipo;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel wrongLabel;

	public RegisterFrame(String namee) {
		super(namee);

		// PANEL
		// this.setLayout(new GridLayout(4, 1));
		JPanel superiorPanel = new JPanel();
		superiorPanel.setBackground(blanco);

		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new GridBagLayout());
		fieldsPanel.setBackground(blanco);

		JPanel buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setBackground(blanco);
		buttonPanel.setPreferredSize(new Dimension(230, 29));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JPanel inferiorPanel = new JPanel();
		inferiorPanel.setBackground(blanco);

		// COMPONENTS
		categoria = new JComboBox<String>();
		categoria.addItem("--- Select an option ---");
		categoria.addItem("Administrator");
		categoria.addItem("Student");
		categoria.addItem("Teacher");

		label1 = new JLabel("Name: ");
		name = new JTextField(15);

		label2 = new JLabel("E-mail: ");
		correo = new JTextField(15);

		label3 = new JLabel("Password: ");
		contrasena = new JTextField(15);

		label4 = new JLabel("ID: ");
		id = new JTextField(15);

		label5 = new JLabel("Dependency: ");
		dependencia = new JTextField(15);

		label6 = new JLabel("College ID: ");
		idUniversitario = new JTextField(15);

		label7 = new JLabel("Career: ");
		carrera = new JTextField(15);

		label8 = new JLabel("School: ");
		departamento = new JTextField(15);

		label9 = new JLabel("Type: ");
		tipo = new JTextField(15);

		wrongLabel = new JLabel("Wrong Fields!", SwingConstants.CENTER);
		wrongLabel.setForeground(Color.red);
		wrongLabel.setVisible(false);

		resetVisibility();

		add = new CJButton("Register");
		add.setPreferredSize(new Dimension(230, 25));

		categoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("Administrator".equals((String) categoria.getSelectedItem())) {
					resetVisibility();
					label5.setVisible(true);
					dependencia.setVisible(true);
					label6.setVisible(true);
					idUniversitario.setVisible(true);
				} else if ("Student".equals((String) categoria.getSelectedItem())) {
					resetVisibility();
					label7.setVisible(true);
					carrera.setVisible(true);
					label6.setVisible(true);
					idUniversitario.setVisible(true);
				} else if ("Teacher".equals((String) categoria.getSelectedItem())) {
					resetVisibility();
					label6.setVisible(true);
					idUniversitario.setVisible(true);
					label8.setVisible(true);
					departamento.setVisible(true);
					label9.setVisible(true);
					tipo.setVisible(true);
				} else if ("--- Select an option ---".equals((String) categoria.getSelectedItem())) {
					resetVisibility();
				}
			}
		});

		// ADD COMPONENTS
		fieldsPanel.add(categoria, makeGbc(1, 1));
		fieldsPanel.add(name, makeGbc(1, 2));
		fieldsPanel.add(correo, makeGbc(1, 3));
		fieldsPanel.add(contrasena, makeGbc(1, 4));
		fieldsPanel.add(id, makeGbc(1, 5));
		fieldsPanel.add(dependencia, makeGbc(1, 6));
		fieldsPanel.add(idUniversitario, makeGbc(1, 7));
		fieldsPanel.add(carrera, makeGbc(1, 8));
		fieldsPanel.add(departamento, makeGbc(1, 9));
		fieldsPanel.add(tipo, makeGbc(1, 10));

		fieldsPanel.add(label1, makeGbc(0, 2));
		fieldsPanel.add(label2, makeGbc(0, 3));
		fieldsPanel.add(label3, makeGbc(0, 4));
		fieldsPanel.add(label4, makeGbc(0, 5));
		fieldsPanel.add(label5, makeGbc(0, 6));
		fieldsPanel.add(label6, makeGbc(0, 7));
		fieldsPanel.add(label7, makeGbc(0, 8));
		fieldsPanel.add(label8, makeGbc(0, 9));
		fieldsPanel.add(label9, makeGbc(0, 10));
		fieldsPanel.add(wrongLabel, makeGbc(1, 11));
		fieldsPanel.add(buttonPanel, makeGbc(1, 12));

		buttonPanel.add(add, makeGbc(0, 1));

		inferiorPanel.add(backButton);

		this.add(fieldsPanel);
		this.add(inferiorPanel, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	public void resetWrong() {
		label1.setForeground(Color.black);
		label2.setForeground(Color.black);
		label3.setForeground(Color.black);
		label4.setForeground(Color.black);
		label6.setForeground(Color.black);
	}

	private void resetVisibility() {
		label5.setVisible(false);
		dependencia.setVisible(false);
		label6.setVisible(false);
		idUniversitario.setVisible(false);
		label7.setVisible(false);
		carrera.setVisible(false);
		label8.setVisible(false);
		departamento.setVisible(false);
		label9.setVisible(false);
		tipo.setVisible(false);

	}

	public void clearFields() {
		correo.setText("");
		dependencia.setText("");
		idUniversitario.setText("");
		name.setText("");
		carrera.setText("");
		tipo.setText("");
		departamento.setText("");
		contrasena.setText("");
		id.setText("");
	}

	public CJButton getAdd() {
		return add;
	}

	public void setAdd(CJButton add) {
		this.add = add;
	}

	public JTextField getname() {
		return name;
	}

	public void setname(JTextField name) {
		this.name = name;
	}

	public Object getcategoria() {
		return categoria.getSelectedItem();
	}

	public JTextField getcorreo() {
		return correo;
	}

	public void setcorreo(JTextField correo) {
		this.correo = correo;
	}

	public JTextField getcontrasena() {
		return contrasena;
	}

	public void setcontrasena(JTextField contrasena) {
		this.contrasena = contrasena;
	}

	public JTextField getid() {
		return id;
	}

	public void setid(JTextField id) {
		this.id = id;
	}

	public JTextField getdependencia() {
		return dependencia;
	}

	public void setdependencia(JTextField dependencia) {
		this.dependencia = dependencia;
	}

	public JTextField getidUniversitario() {
		return idUniversitario;
	}

	public void setidUniversitario(JTextField idUniversitario) {
		this.idUniversitario = idUniversitario;
	}

	public JTextField getcarrera() {
		return carrera;
	}

	public void setcarrera(JTextField carrera) {
		this.carrera = carrera;
	}

	public JTextField getdepartamento() {
		return departamento;
	}

	public void setdepartamento(JTextField departamento) {
		this.departamento = departamento;
	}

	public JTextField gettipo() {
		return tipo;
	}

	public void settipo(JTextField tipo) {
		this.tipo = tipo;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public JLabel getLabel3() {
		return label3;
	}

	public void setLabel3(JLabel label3) {
		this.label3 = label3;
	}

	public JLabel getLabel4() {
		return label4;
	}

	public void setLabel4(JLabel label4) {
		this.label4 = label4;
	}

	public JLabel getLabel6() {
		return label6;
	}

	public void setLabel6(JLabel label6) {
		this.label6 = label6;
	}

	public JLabel getWrongLabel() {
		return wrongLabel;
	}

	public void setWrongLabel(JLabel wrongLabel) {
		this.wrongLabel = wrongLabel;
	}

}
