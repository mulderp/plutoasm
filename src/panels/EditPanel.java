package panels;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EditPanel extends JPanel {
	
	JTextArea srcEdit;
	
	public EditPanel() {
		srcEdit = new JTextArea(20, 30);
		srcEdit.setText("abc");
		add(srcEdit);
		
	}

	public JTextArea getSrcEdit() {
		return srcEdit;
	}

	public void setSrcEdit(JTextArea srcEdit) {
		this.srcEdit = srcEdit;
	}

	public String getText() {
		return getSrcEdit().getText() ;
	}

}
