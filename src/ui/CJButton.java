/**
 * 
 */
package ui;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * @author pablourrutia
 *
 */
public class CJButton extends JButton {
	private static final long serialVersionUID = 1L;
	protected Color azul = new Color(0, 87, 173);

	public CJButton() {
		this.setBackground(azul);
		this.setForeground(Color.white);
	}

	public CJButton(Icon icon) {
		super(icon);
		this.setBackground(azul);
		this.setForeground(Color.white);
	}

	public CJButton(String text) {
		super(text);
		//this.setBackground(azul);
		//this.setOpaque(true);
		//this.setForeground(Color.white);
	}

	public CJButton(Action a) {
		super(a);
		this.setBackground(azul);
		this.setForeground(Color.white);
	}

	public CJButton(String text, Icon icon) {
		super(text, icon);
		this.setBackground(azul);
		this.setForeground(Color.white);
	}

}
