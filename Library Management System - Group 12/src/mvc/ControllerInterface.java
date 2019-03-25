package mvc;

import javax.swing.JPanel;

/**
 * 
 * An interface that every controller should have for setting the panel
 *
 */
public interface ControllerInterface {
	
	/**
	 * Sets the current JPanel
	 * @param current_panel - the current panel
	 * @param new_panel - the new panel
	 * @param frame - the main frame we are running on
	 */
	public default void setPanel(JPanel current_panel, JPanel new_panel, MainFrame frame) {
		current_panel.setVisible(false);
		frame.setPanel(new_panel);
	}

}
