package utils;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Created by Thomas Schuett, Munich
 * Free to use.
 */
public class TablePanelV2 extends JPanel {
	
	public static int FILL_NONE  = 0;
	public static int FILL_HORIZONTAL = 1;
	public static int FILL_VERTICAL   = 2;
	/** default */
	public static int FILL_BOTH       = 3;
	
	
	public int defaultAncor = GridBagConstraints.NORTHWEST;
	public int defaultFill = FILL_NONE;
	
	private Insets insets = new Insets(4,4,4,4);
	
	public TablePanelV2() {
		setLayout(new GridBagLayout());
	}
	
	public void add(GridBagConstraints cons, Component comp) {
		if (comp instanceof JCheckBox) {
			cons.insets = new Insets(0,4,0,4);
		}
		add(comp, cons);
	}
	
	/**
	 *  The given row and col overwrites the values in the given constrains.
	 */
	public void add(int row, int col, GridBagConstraints c, Component comp) {
		c.gridx = col;
		c.gridy = row;
		add(c, comp);
	}
	
	public void add(int row, int col, Component comp) {
		GridBagConstraints c = createConstraints(row, col, 1, 1, defaultAncor, defaultFill);
		add(c, comp);
	}
	
	public void add(int row, int col, int width, Component comp) {
		GridBagConstraints c = createConstraints(row, col, width, 1, defaultAncor, defaultFill);
		add(c, comp);
	}
	
	public void add(int row, int col, int width, int height, Component comp) {
		GridBagConstraints c = createConstraints(row, col, width, height, defaultAncor, defaultFill);
		add(c, comp);
	}
	
	public void add(int row, int col, int width, int height, int fill, Component comp) {
		GridBagConstraints c = createConstraints(row, col, width, height, defaultAncor, fill);
		add(c, comp);
	}

	public void add(int row, int col, int width, int height, int ancor, int fill, Component comp) {
		GridBagConstraints c = createConstraints(row, col, width, height, ancor, fill);
		add(c, comp);
	}

	public GridBagConstraints createConstraints(int row, int col, int width, int height, int ancor, int fill) {
		return createConstraints(row, col, width, height, ancor, fill, insets);
	}

	public static GridBagConstraints createConstraints(int row, int col, int width, int height, int ancor, int fill, Insets insets) {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = insets;
		c.anchor = ancor;
		c.gridx = col; 
		c.gridy = row;
		c.gridwidth = width;
		c.gridheight = height;
		
		c.fill = GridBagConstraints.BOTH;  //  always !!!
		c.weightx = 0;
		c.weighty = 0;
		if (fill == TablePanelV2.FILL_HORIZONTAL) {
			c.weightx = 1;
		}
		if (fill == TablePanelV2.FILL_VERTICAL) {
			c.weighty = 1;
		}
		if (fill == TablePanelV2.FILL_BOTH) {
			c.weightx = 1;
			c.weighty = 1;
		}
		return c;
	}
	
	/**
	 * Creates a JPanel with two columns, where
	 * the compList elements are placed in in flow order.
	 * 
	 * Each 2nd element may be null. Then the elem before gets the whole 
	 * row to be placed in.
	 * 
	 * A  "new JLabel(""), null" component pair gives a small line spacing.
	 * A  "new JLabel(" "), null" component pair gives a big line spacing.
	 * 
	 * @param compList
	 * @return JPanel
	 */
	public static TablePanelV2 createTwoColumnPanel(Component[] compList) {
		TablePanelV2 mainPanel = new TablePanelV2();
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = createConstraints(0, 0, 1, 1, mainPanel.defaultAncor, mainPanel.defaultFill, new Insets(4,4,4,4));
		c.gridx = 0; c.gridy = 0;
		for (int i=0; i < compList.length -1 ; i=i+2) {
			// if an odd number of components is given, the last one
			// is silently ignored
			Component compLeft =  compList[i];
			Component compRight =  compList[i+1];
			if (compRight == null) {
				c.gridwidth = 2;
				c.gridx = 0;  
				mainPanel.add(compLeft, c);
			}
			else {
				c.gridwidth = 1;
				c.gridx = 0;
				mainPanel.add(compLeft, c);
				c.gridx = 1;  
				mainPanel.add(compRight, c);
			}
			c.gridy++;
		}
		return mainPanel;
	}

	public Insets getInsets() {
		return insets;
	}

	public void setInsets(Insets insets) {
		this.insets = insets;
	}

	/**
	 * Testing / Usage Example
	 */
	public static void main(String[] args) {
		final JTextField name = new JTextField();
		name.setColumns(20);
		final JPasswordField pwd = new JPasswordField();
		pwd.setColumns(20);
		final JTextField nochwas = new JTextField();
		nochwas.setColumns(12);

		TablePanelV2 mainPanel = new TablePanelV2();
		int baseCol = 1;
		mainPanel.add(0, 0, new JLabel("             ")); // indent (an empty 1st column)
		mainPanel.add(0, baseCol + 0, 2, new JLabel("Login Data:"));
		mainPanel.add(1, baseCol + 0, new JLabel("Name:"));
		mainPanel.add(1, baseCol + 1, name);
		mainPanel.add(2, baseCol + 0, new JLabel("Passwort:"));
		mainPanel.add(2, baseCol + 1, pwd);
		mainPanel.add(3, baseCol + 0, new JLabel(""));
		mainPanel.add(4, baseCol + 0, new JLabel(""));
		mainPanel.add(5, baseCol + 0, 2, new JLabel("A long section headline:"));
		mainPanel.add(6, baseCol + 0, new JLabel("Some more:"));
		mainPanel.add(6, baseCol + 1, nochwas);
		mainPanel.add(7, baseCol + 0, new JLabel(""));

		boolean ret = InputDialogJOptionPane.getInput((Frame) null, "Dialog",
				mainPanel);

		if (!ret) {
			System.out.println("Canceled");
		} else {
			System.out.println("User: " + name.getText());
			System.out.println("PWD : " + new String(pwd.getPassword()));
		}

		// ========== example 2 ==========================

		mainPanel = TablePanelV2
				.createTwoColumnPanel(new Component[] {
						new JLabel("Login Data:"), null, new JLabel("Name:"),
						name, new JLabel("Passwort:"), pwd, new JLabel(""),
						null, new JLabel(""), null,
						new JLabel("A long section headline:"), null,
						new JLabel("Some more:"), nochwas, new JLabel(""), null });

		ret = InputDialogJOptionPane
				.getInput((Frame) null, "Dialog", mainPanel);

		if (!ret) {
			System.out.println("Canceled");
		} else {
			System.out.println("User: " + name.getText());
			System.out.println("PWD : " + new String(pwd.getPassword()));
		}
	}
}	
