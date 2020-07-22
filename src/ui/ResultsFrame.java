package ui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import data.Resources;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class ResultsFrame extends StandardFrame {

	private static final long serialVersionUID = 1L;

	// LIST FRAME
	private CJButton selectResource;
	@SuppressWarnings("rawtypes")
	private JList list;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResultsFrame(String name, Vector<Resources> items) {
		super(name);

		// PANEL
		JPanel superiorPanel = new JPanel();
		superiorPanel.setBackground(blanco);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setBackground(blanco);

		JPanel inferiorPanel = new JPanel();
		inferiorPanel.setBackground(blanco);

		// COMPONENTS
		selectResource = new CJButton("Select");
		list = new JList(items);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.setFixedCellHeight(30);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(500, 200));
		listScroller.setMinimumSize(new Dimension(480, 200));
		listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// ADD COMPONENTS
		inferiorPanel.add(listScroller, makeGbc(0, 1));
		buttonPanel.add(backButton, makeGbc(0, 1));
		buttonPanel.add(selectResource, makeGbc(0, 0));

		this.add(superiorPanel, BorderLayout.NORTH);
		this.add(inferiorPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.setVisible(true);
		this.pack();
	}

	public CJButton getSelectResource() {
		return selectResource;
	}

	public void setSelectResource(CJButton selectResource) {
		this.selectResource = selectResource;
	}

	@SuppressWarnings("rawtypes")
	public JList getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(JList list) {
		this.list = list;
	}

}
