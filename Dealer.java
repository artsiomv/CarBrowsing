import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class Dealer extends JPanel{

	/**
	 * Create the panel.
	 */
	public Dealer(final String login) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnCreatePosting = new JButton("Create listing");
		btnCreatePosting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreateListing create = new CreateListing(login);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnCreatePosting);
		
		JButton btnViewMyPostings = new JButton("View my listings");
		btnViewMyPostings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ViewListings view = new ViewListings(login);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel.add(btnViewMyPostings);
		
		JButton btnDeleteListing = new JButton("Delete listing");
		btnDeleteListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteListing delete = new DeleteListing();
			}
		});
		panel.add(btnDeleteListing);
		frame.pack();
		frame.setVisible(true);
		
		JPanel panel1 = new JPanel();
		frame.getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setLayout(new BorderLayout(0, 0));
	}

}
