import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class User extends JPanel {

	/**
	 * Create the panel.
	 */
	public User(final String userLogIn) {
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		String[] sortBy = {"Gasoline","Diesel","Hybrid","Electric","Natural Gas","Hydrogen"};
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDB[] customers = DatabaseAccess.GetUsers();
//				System.out.println(customers[0].toString());
//				System.out.println(customers[1].toString());
			}
		});
		btnSearch_1.setBounds(10, 11, 89, 23);
		panel.add(btnSearch_1);
		
		JButton btnViewFavorites = new JButton("View Favorites*");
		btnViewFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Favorites fav = new Favorites(userLogIn);
			}
		});
		btnViewFavorites.setBounds(109, 11, 122, 23);
		panel.add(btnViewFavorites);
		
		frame.setSize(266, 95);
		frame.setVisible(true);
	}
}
