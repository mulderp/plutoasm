package panels;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OutputPanel extends JPanel {
	

	JTextArea output;
	
	public OutputPanel() {
		output = new JTextArea(20, 30);
		
		add(output);
	}

	public JTextArea getOutput() {
		return output;
	}

	public void setOutput(JTextArea output) {
		this.output = output;
	}

	public void setText(String string) {
		getOutput().setText(string);	
	}

}
