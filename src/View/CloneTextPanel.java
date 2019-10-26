/**
 * Class that builds some user interface components
 * @author: Fabián Astorga Cerdas
 */

package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controller.Controller;
import Model.FileManager;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class CloneTextPanel extends JPanel {

	/**
	 * Create the graphic user interface panel with file viewer 
	 * and load file functionality.
	 */
	public CloneTextPanel() 
	{
		setLayout(new GridLayout(2, 1, 5, 5));
		
		JButton loadFileButton = new JButton("LOAD FILE");
		loadFileButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
		loadFileButton.setForeground(new Color(0, 0, 0));
		loadFileButton.setBackground(new Color(211, 211, 211));		
		
		final JTextArea textArea = new JTextArea();
		final JScrollPane scrollable = new JScrollPane(textArea);
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setFont(new Font("Ubuntu", Font.PLAIN, 11));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setEditable(false);
		
		loadFileButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				Controller _bridge = Controller.getInstance();			
				try {
					_bridge.callFileManager();
				} catch (Exception e) {
					e.printStackTrace();
				}
				textArea.setText(_bridge.getFileContent());
				_bridge.startFileManager();		
			}
		});		
		this.add(scrollable);		
		this.add(loadFileButton);
	}
}
