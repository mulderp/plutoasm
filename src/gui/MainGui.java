package gui;

import java.awt.Component;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import panels.EditPanel;
import panels.MainFrame;
import panels.OutputPanel;
import utils.InputDialogJOptionPane;
import utils.TablePanelV2;

public class MainGui {
	
	/**
	 * Testing / Usage Example
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		    	  MainFrame mainPane = new MainFrame();
		    	  mainPane.setVisible(true);
		      }
		    });
		
		

	}

}
