package panels;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EditPanel extends JPanel {
	
	JTextArea srcEdit;
	
	public EditPanel() {
		srcEdit = new JTextArea(20, 30);
		String src = ".data\n"
				+ "a: .word 1, 2, 3\n";
		
		srcEdit.setText(src);
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
