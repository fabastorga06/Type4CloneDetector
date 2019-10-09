package View;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.DocumentException;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import Controller.Controller;

@SuppressWarnings("serial")
public class GuiPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GuiPanel(String[] args) 
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
				Controller bridge = new Controller();
				try {
					bridge.initLogic(args);
				} catch (FileNotFoundException | DocumentException e) {
					// TODO Auto-generated catch block
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
