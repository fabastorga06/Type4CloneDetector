package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import View.FileManager;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class CloneTextPanel extends JPanel {

	public CloneTextPanel() {
		setLayout(new GridLayout(2, 1, 5, 5));
		
		JButton loadFileButton = new JButton("LOAD FILE");
		loadFileButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
		loadFileButton.setForeground(new Color(0, 0, 0));
		loadFileButton.setBackground(new Color(211, 211, 211));		
		
		final JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setFont(new Font("Ubuntu", Font.PLAIN, 11));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setEditable(false);
		final JScrollPane scrollable = new JScrollPane(textArea);
		
		loadFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileManager fileManager = new FileManager();				
				try {
					fileManager.readFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
				textArea.setText(fileManager._content.toString());
				fileManager.changeFileDir();				
			}
		});
		
		this.add(scrollable);		
		this.add(loadFileButton);
	}
}
