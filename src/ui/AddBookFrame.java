package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class AddBookFrame extends StandardFrame {

	private static final long serialVersionUID = 1L;

	// ADD BOOK FRAME
	private CJButton add;
	private JComboBox<String> categoria;
	private JTextField nam;
	private JTextField author;
	private JTextField pDate;
	private JTextField subject;
	private JTextField recommended;
	private JTextField licence;
	private JTextField issbn;
	private JTextField numeroEjemplares;
	private JTextField online;
	private JTextField status;
	private JTextField stringAttached;
	private JTextField department;
	private JTextField volume;

	private JLabel label1AddBook;
	private JLabel label2AddBook;
	private JLabel label3AddBook;
	private JLabel label4AddBook;
	private JLabel label5AddBook;
	private JLabel label6AddBook;
	private JLabel label7AddBook;
	private JLabel label8AddBook;
	private JLabel label9AddBook;
	private JLabel label10AddBook;
	private JLabel label11AddBook;
	private JLabel label12AddBook;
	private JLabel label13AddBook;
	private JLabel wrongLabel;

	public AddBookFrame(String name) {
		super(name);
		this.setSize(500, 575);
		// PANEL
		JPanel superiorPanel = new JPanel();
		superiorPanel.setBackground(blanco);

		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new GridBagLayout());
		fieldsPanel.setBackground(blanco);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(blanco);
		buttonPanel.setPreferredSize(new Dimension(230, 29));

		JPanel inferiorPanel = new JPanel();
		inferiorPanel.setBackground(blanco);

		// COMPONENTS
		categoria = new JComboBox<String>();
		categoria.addItem("--- Select an option ---");
		categoria.addItem("Book");
		categoria.addItem("Journal");
		categoria.addItem("Paper");
		
		label1AddBook = new JLabel("Name: ");//P
		nam = new JTextField(15);

		label2AddBook = new JLabel("Author: ");//P
		author = new JTextField(15);

		label3AddBook = new JLabel("Date of Publication: ");//P
		pDate = new JTextField(15);

		label4AddBook = new JLabel("Subject: ");//B
		subject = new JTextField(15);
		label4AddBook.setVisible(false);
		subject.setVisible(false);

		label5AddBook = new JLabel("Recommended for: ");//B
		recommended = new JTextField(15);
		label5AddBook.setVisible(false);
		recommended.setVisible(false);

		label6AddBook = new JLabel("Licence: ");//P
		licence = new JTextField(15);

		label7AddBook = new JLabel("ISSBN code: ");//P
		issbn = new JTextField(15);

		label8AddBook = new JLabel("Number of copies: ");//P
		numeroEjemplares = new JTextField("0", 15);

		label9AddBook = new JLabel("Online (Yes/No): ");//P
		online = new JTextField("false", 15);

		label10AddBook = new JLabel("Availible (Yes/No): ");//P
		status = new JTextField("false", 15);

		label11AddBook = new JLabel("Link: ");//B Y PA
		stringAttached = new JTextField(15);
		label11AddBook.setVisible(false);
		stringAttached.setVisible(false);

		label12AddBook = new JLabel("Department: ");//J
		department = new JTextField(15);
		label12AddBook.setVisible(false);
		department.setVisible(false);
		
		label13AddBook = new JLabel("Volume: ");//J
		volume = new JTextField(15);
		label13AddBook.setVisible(false);
		volume.setVisible(false);

		add = new CJButton("Add");
		add.setPreferredSize(new Dimension(230, 25));
		
		wrongLabel = new JLabel("Wrong Fields!", SwingConstants.CENTER);
		wrongLabel.setForeground(Color.red);
		wrongLabel.setVisible(false);
		
		clearFields();
		
		categoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("Book".equals((String) categoria.getSelectedItem())) {
					resetVisibility();
					label4AddBook.setVisible(true);
					subject.setVisible(true);
					label5AddBook.setVisible(true);
					recommended.setVisible(true);
					label11AddBook.setVisible(true);
					stringAttached.setVisible(true);
				} else if ("Journal".equals((String) categoria.getSelectedItem())) {
					resetVisibility();
					label12AddBook.setVisible(true);
					department.setVisible(true);
					label13AddBook.setVisible(true);
					volume.setVisible(true);
				} else if ("Paper".equals((String) categoria.getSelectedItem())) {
					resetVisibility();
					label11AddBook.setVisible(true);
					stringAttached.setVisible(true);
				}else if ("--- Select an option ---".equals((String) categoria.getSelectedItem())) {
					resetVisibility();
				}
			}
		});

		// ADD COMPONENTS
		fieldsPanel.add(categoria, makeGbc(1, 1));
		fieldsPanel.add(nam, makeGbc(1, 2));
		fieldsPanel.add(author, makeGbc(1, 3));
		fieldsPanel.add(pDate, makeGbc(1, 4));
		fieldsPanel.add(subject, makeGbc(1, 5));
		fieldsPanel.add(recommended, makeGbc(1, 6));
		fieldsPanel.add(licence, makeGbc(1, 7));
		fieldsPanel.add(issbn, makeGbc(1, 8));
		fieldsPanel.add(numeroEjemplares, makeGbc(1, 9));
		fieldsPanel.add(online, makeGbc(1, 10));
		fieldsPanel.add(status, makeGbc(1, 11));
		fieldsPanel.add(stringAttached, makeGbc(1, 12));
		fieldsPanel.add(department, makeGbc(1, 13));
		fieldsPanel.add(volume, makeGbc(1, 14));

		fieldsPanel.add(label1AddBook, makeGbc(0, 2));
		fieldsPanel.add(label2AddBook, makeGbc(0, 3));
		fieldsPanel.add(label3AddBook, makeGbc(0, 4));
		fieldsPanel.add(label4AddBook, makeGbc(0, 5));
		fieldsPanel.add(label5AddBook, makeGbc(0, 6));
		fieldsPanel.add(label6AddBook, makeGbc(0, 7));
		fieldsPanel.add(label7AddBook, makeGbc(0, 8));
		fieldsPanel.add(label8AddBook, makeGbc(0, 9));
		fieldsPanel.add(label9AddBook, makeGbc(0, 10));
		fieldsPanel.add(label10AddBook, makeGbc(0, 11));
		fieldsPanel.add(label11AddBook, makeGbc(0, 12));
		fieldsPanel.add(label12AddBook, makeGbc(0, 13));
		fieldsPanel.add(label13AddBook, makeGbc(0, 14));
		fieldsPanel.add(wrongLabel, makeGbc(1, 15));

		fieldsPanel.add(buttonPanel, makeGbc(1, 16));
		buttonPanel.add(add);
		
		inferiorPanel.add(backButton);

		this.add(fieldsPanel);
		this.add(inferiorPanel, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	public void clearFields() {
		author.setText("");
		pDate.setText("");
		licence.setText("");
		issbn.setText("");
		nam.setText("");
		numeroEjemplares.setText("");
		status.setText("");
		online.setText("");
		subject.setText("");
		recommended.setText("");
		stringAttached.setText("");
	}
	
	private void resetVisibility() {
		label4AddBook.setVisible(false);
		subject.setVisible(false);
		label5AddBook.setVisible(false);
		recommended.setVisible(false);
		label11AddBook.setVisible(false);
		stringAttached.setVisible(false);
		label12AddBook.setVisible(false);
		department.setVisible(false);
		label13AddBook.setVisible(false);
		volume.setVisible(false);
	}
	
	public void resetWrong() {
		label2AddBook.setForeground(Color.black);
		label3AddBook.setForeground(Color.black);
		label6AddBook.setForeground(Color.black);
		label8AddBook.setForeground(Color.black);
		label9AddBook.setForeground(Color.black);
		label10AddBook.setForeground(Color.black);
	}
	
	public Object getcategoria() {
		return categoria.getSelectedItem();
	}

	public CJButton getAdd() {
		return add;
	}

	public void setAdd(CJButton add) {
		this.add = add;
	}

	public JTextField getNam() {
		return nam;
	}

	public void setNam(JTextField nam) {
		this.nam = nam;
	}

	public JTextField getAuthor() {
		return author;
	}

	public void setAuthor(JTextField author) {
		this.author = author;
	}

	public JTextField getpDate() {
		return pDate;
	}

	public void setpDate(JTextField pDate) {
		this.pDate = pDate;
	}

	public JTextField getSubject() {
		return subject;
	}

	public void setSubject(JTextField subject) {
		this.subject = subject;
	}

	public JTextField getRecommended() {
		return recommended;
	}

	public void setRecommended(JTextField recommended) {
		this.recommended = recommended;
	}

	public JTextField getLicence() {
		return licence;
	}

	public void setLicence(JTextField licence) {
		this.licence = licence;
	}

	public JTextField getIssbn() {
		return issbn;
	}

	public void setIssbn(JTextField issbn) {
		this.issbn = issbn;
	}

	public JTextField getNumeroEjemplares() {
		return numeroEjemplares;
	}

	public void setNumeroEjemplares(JTextField numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}

	public JTextField getOnline() {
		return online;
	}

	public void setOnline(JTextField online) {
		this.online = online;
	}

	public JTextField getStatus() {
		return status;
	}

	public void setStatus(JTextField status) {
		this.status = status;
	}

	public JTextField getStringAttached() {
		return stringAttached;
	}

	public void setStringAttached(JTextField stringAttached) {
		this.stringAttached = stringAttached;
	}

	public JLabel getLabel2AddBook() {
		return label2AddBook;
	}

	public void setLabel2AddBook(JLabel label2AddBook) {
		this.label2AddBook = label2AddBook;
	}

	public JLabel getLabel3AddBook() {
		return label3AddBook;
	}

	public void setLabel3AddBook(JLabel label3AddBook) {
		this.label3AddBook = label3AddBook;
	}

	public JLabel getLabel6AddBook() {
		return label6AddBook;
	}

	public void setLabel6AddBook(JLabel label6AddBook) {
		this.label6AddBook = label6AddBook;
	}

	public JLabel getLabel8AddBook() {
		return label8AddBook;
	}

	public void setLabel8AddBook(JLabel label8AddBook) {
		this.label8AddBook = label8AddBook;
	}

	public JLabel getLabel9AddBook() {
		return label9AddBook;
	}

	public void setLabel9AddBook(JLabel label9AddBook) {
		this.label9AddBook = label9AddBook;
	}

	public JLabel getLabel10AddBook() {
		return label10AddBook;
	}

	public void setLabel10AddBook(JLabel label10AddBook) {
		this.label10AddBook = label10AddBook;
	}

	public JTextField getDepartment() {
		return department;
	}

	public void setDepartment(JTextField department) {
		this.department = department;
	}

	public JTextField getVolume() {
		return volume;
	}

	public void setVolume(JTextField volume) {
		this.volume = volume;
	}

	public JLabel getWrongLabel() {
		return wrongLabel;
	}

	public void setWrongLabel(JLabel wrongLabel) {
		this.wrongLabel = wrongLabel;
	}

}
