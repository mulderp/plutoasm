package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import parser.ParseProgram;
import utils.TablePanelV2;

public class MainFrame extends JFrame implements ActionListener {

	private JSplitPane splitPane;
	EditPanel editPane;
	OutputPanel outputPane;

	public MainFrame() {
		super("Java Swing Examples");
		setSize(400, 600);
		setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        editPane = new EditPanel();
		JScrollPane scrollEditPane = new JScrollPane(editPane);
		
		outputPane = new OutputPanel();
		JScrollPane scrollOutput = new JScrollPane(outputPane);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				scrollEditPane, scrollOutput);

		splitPane.setOneTouchExpandable(false);
		splitPane.setDividerLocation(300);

		// Provide minimum sizes for the two components in the split pane
		Dimension minimumSize = new Dimension(200, 300);
		editPane.setSize(minimumSize);
		outputPane.setSize(minimumSize);

		add(splitPane, BorderLayout.CENTER);
		add(new ControlPanel(this), BorderLayout.SOUTH);
		pack();

	}
	
    public void actionPerformed(ActionEvent quitEvent) {
        this.processWindowEvent(
                new WindowEvent(
                      this, WindowEvent.WINDOW_CLOSING));
    }

	public void runParser() {
		ParseProgram parser = new ParseProgram(getEditPane().getText());
		parser.parse();
		String output = parser.getOutput().toString();
		getOutputPane().setText(output);
	}

	public EditPanel getEditPane() {
		return editPane;
	}

	public void setEditPane(EditPanel editPane) {
		this.editPane = editPane;
	}

	public OutputPanel getOutputPane() {
		return outputPane;
	}

	public void setOutputPane(OutputPanel outputPane) {
		this.outputPane = outputPane;
	}

}
