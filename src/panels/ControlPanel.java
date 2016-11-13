package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener {
	
	MainFrame localRef;
	
	public ControlPanel(MainFrame refMainFrame) {
		localRef = refMainFrame;
		
		JButton runButton = new JButton("Run");
		runButton.addActionListener(this);
		add(runButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Run")) {
			localRef.runParser();
		}
		
	}

}
