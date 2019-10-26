/**

 * Main class that inits the program.
 * @author: Fabián Astorga Cerdas
 * @version: 1.0

 */

package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Class constructor. Inits the graphical user interface.
	 */
	public MainWindow() 
	{
		setBackground(new Color(169, 169, 169));
		setTitle("TYPE-4 CLONE DETECTOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		GuiPanel guiPanel = new GuiPanel();
		contentPane.add(guiPanel, BorderLayout.EAST);
		
		CloneTextPanel cloneTextPanel = new CloneTextPanel();
		contentPane.add(cloneTextPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Main function
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException
	{	
	    EventQueue.invokeLater(new Runnable() 
	    {
			public void run() 
			{
				try 
				{
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});				
	}
}
