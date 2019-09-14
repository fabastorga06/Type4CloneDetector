package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import mpi.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	
	public MainWindow() {
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

	public static void main(String[] args) throws InterruptedException {		
		
		long startTime = System.nanoTime();

		/* code being measured starts */		
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int procs = MPI.NUM_OF_PROCESSORS;
		System.out.println("process: " + rank + "\n" + "size: " + size + "\n" + "processors: " + procs);
		MPI.Finalize(); 		

	    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});			

		/* the code being measured ends */
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " + 
								timeElapsed / 1000000);
		
	}
}
