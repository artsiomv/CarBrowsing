import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class User extends JPanel {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public User(final String userLogIn) throws SQLException {
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBackground(new Color(225, 225, 225));
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search search = new Search(userLogIn);
			}
		});
		btnSearch_1.setBounds(10, 56, 89, 23);
		panel.add(btnSearch_1);
		
		JButton btnViewFavorites = new JButton("View Favorites");
		btnViewFavorites.setBackground(new Color(225, 225, 225));
		btnViewFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Favorites fav = new Favorites(userLogIn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnViewFavorites.setBounds(109, 56, 122, 23);
		panel.add(btnViewFavorites);
		
		JLabel lblWelcome = new JLabel("Welcome " + DBConnect.selectQuery("SELECT fname FROM User WHERE idNum = '"+ userLogIn+"';", "fName") + " " 
				 + DBConnect.selectQuery("SELECT lName FROM User WHERE idNum = '"+ userLogIn+"';", "lName"));
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcome.setBounds(10, 11, 230, 23);
		panel.add(lblWelcome);
		
		frame.setSize(266, 129);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
