package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class SearchFrame extends StandardFrame {

	private static final long serialVersionUID = 1L;

	// SEARCH FRAME
	private CJButton searchResource;

	private JTextField filter;
	private JTextField byAuthor;
	private JTextField byName;

	private JLabel label1Search;
	private JLabel label2Search;
	private JLabel label3Search;

	public SearchFrame(String name) {
		super(name);

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
		label1Search = new JLabel("filter: ");
		filter = new JTextField(15);

		label2Search = new JLabel("Author: ");
		byAuthor = new JTextField(15);

		label3Search = new JLabel("Name: ");
		byName = new JTextField(15);

		searchResource = new CJButton("Search Resource");
		searchResource.setPreferredSize(new Dimension(230, 25));

		// ADD COMPONENTS
		fieldsPanel.add(filter, makeGbc(1, 1));
		fieldsPanel.add(byAuthor, makeGbc(1, 2));
		fieldsPanel.add(byName, makeGbc(1, 3));

		fieldsPanel.add(label1Search, makeGbc(0, 1));
		fieldsPanel.add(label2Search, makeGbc(0, 2));
		fieldsPanel.add(label3Search, makeGbc(0, 3));

		fieldsPanel.add(buttonPanel, makeGbc(1, 4));
		buttonPanel.add(searchResource);
		
		inferiorPanel.add(backButton);

		this.add(fieldsPanel);
		this.add(inferiorPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public CJButton getSearchResource() {
		return searchResource;
	}

	public void setSearchResource(CJButton searchResource) {
		this.searchResource = searchResource;
	}

	public JTextField getFilter() {
		return filter;
	}

	public void setFilter(JTextField filter) {
		this.filter = filter;
	}

	public JTextField getByAuthor() {
		return byAuthor;
	}

	public void setByAuthor(JTextField byAuthor) {
		this.byAuthor = byAuthor;
	}

	public JTextField getByName() {
		return byName;
	}

	public void setByName(JTextField byName) {
		this.byName = byName;
	}

}
