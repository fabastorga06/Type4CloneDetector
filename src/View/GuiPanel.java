/**
 * Class that builds some user interface components
 * @author: Fabián Astorga Cerdas
 */
 
package View;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import com.itextpdf.text.DocumentException;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import Controller.Controller;
import Model.Constants;

@SuppressWarnings("serial")
public class GuiPanel extends JPanel implements Constants {
	
	String output_message, msg;
	int msg_type;

	/**
	 * Create the graphic user interface panel with buttons.
	 */
	public GuiPanel() 
	{
		setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setLayout(new GridLayout(0, 1, 5, 5));
		
		JButton detectClonesButton = new JButton("DETECT CLONES");
		detectClonesButton.setForeground(new Color(0, 0, 0));
		detectClonesButton.setBackground(new Color(211, 211, 211));
		detectClonesButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
		detectClonesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller _bridge = Controller.getInstance();
				try
				{					
					if (_bridge.initLogic() ) { 
						output_message = OK_MESSAGE;
						msg_type = JOptionPane.INFORMATION_MESSAGE;
						msg = "DONE";
					}
					else { 
						output_message = ERROR_MESSAGE; 
						msg_type = JOptionPane.ERROR_MESSAGE;
						msg = "ERROR";
					}
						
					JOptionPane.showMessageDialog(new JFrame(), output_message, msg, msg_type);
				} 
				catch (FileNotFoundException | DocumentException e) {
					e.printStackTrace();
				}			
			}
		});
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setForeground(new Color(0, 0, 0));
		cancelButton.setBackground(new Color(211, 211, 211));
		cancelButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(-1);
			}
		});		
		
		add(detectClonesButton);
		add(cancelButton);
	}

}
