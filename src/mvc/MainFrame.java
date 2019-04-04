package mvc;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	private JPanel display; // basic white display JPanel
	
	/**
	 * The constructor
	 */
	public MainFrame(){
		display = new JPanel();
		display.setBackground(new Color(255, 255, 255));
		this.setSize(1000, 560);
		this.setResizable(false);
		
		getContentPane().add(display);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closes the application properly on close
	}
	
	
	
	/**
	 * Sets a new panel for the JFrame
	 * @param panel - the new panel to be set 
	 */
	public void setPanel(JPanel panel) {
		display.setVisible(false);
		getContentPane().add(panel);
	}

}
