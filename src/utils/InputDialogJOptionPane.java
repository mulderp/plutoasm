package utils;

import java.awt.Component;
import java.awt.Frame;

import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;


public class InputDialogJOptionPane {
	

	private static void setupUIManager() {
		InputMap im = (InputMap)UIManager.get("Button.focusInputMap");
		im.put( KeyStroke.getKeyStroke( "ENTER" ), "pressed" );
		im.put( KeyStroke.getKeyStroke( "released ENTER" ), "released" );
	}
	
	public static boolean getInput(Frame parent, String title, JPanel mainPanel) {
		int ret = JOptionPane.showOptionDialog(
				parent, mainPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE ,
				null, new Object[]{"Ok", "Cancel"}, null);

		return (ret == 0); 
	}
}
