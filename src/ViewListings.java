import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;


public class ViewListings extends JPanel {

	/**
	 * Create the panel.
	 */
	public ViewListings() {
		JFrame frame = new JFrame();
		
		JLabel lblHereIsGoing = new JLabel("Here is going to be all cars listed");
		frame.getContentPane().add(lblHereIsGoing, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
