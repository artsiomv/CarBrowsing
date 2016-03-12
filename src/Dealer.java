import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JLabel;

import java.awt.Font;


public class Dealer extends JPanel{

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Dealer(final String login) throws SQLException {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 319, 90);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCreateListing = new JButton("Create Listing");
		btnCreateListing.setBackground(new Color(225, 225, 225));
		btnCreateListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreateListing create = new CreateListing(login);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnCreateListing.setBounds(10, 51, 127, 23);
		panel.add(btnCreateListing);
		
		JButton btnNewButton = new JButton("View My Listings");
		btnNewButton.setBackground(new Color(225, 225, 225));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ViewListings view = new ViewListings(login);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(147, 51, 154, 23);
		panel.add(btnNewButton);
		
		JLabel lblWelcome = new JLabel("Welcome " + DBConnect.selectQuery("SELECT fname FROM User WHERE idNum = '"+ login+"';", "fName") + " " 
				 + DBConnect.selectQuery("SELECT lName FROM User WHERE idNum = '"+ login+"';", "lName"));
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcome.setBounds(10, 11, 230, 29);
		panel.add(lblWelcome);
		panel.add(lblWelcome);
		frame.setLocationRelativeTo(null);
		frame.setSize(335, 129);
		frame.setVisible(true);
	}
}

/*
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class Dealer extends JPanel{


	public Dealer(final String login) {
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JButton btnCreatePosting = new JButton("Create listing");
		btnCreatePosting.setBounds(0, 0, 0, 0);
		panel.add(btnCreatePosting);
		btnCreatePosting.setBackground(new Color(225, 225, 225));
		
		JButton btnViewMyPostings = new JButton("View my listings");
		btnViewMyPostings.setBounds(0, 0, 311, 23);
		panel.add(btnViewMyPostings);
		btnViewMyPostings.setBackground(new Color(225, 225, 225));
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
		btnCreatePosting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CreateListing create = new CreateListing(login);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
*/
