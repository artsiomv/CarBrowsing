import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class User extends JPanel {

	/**
	 * Create the panel.
	 */
	public User(final String userLogIn) {
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search search = new Search(userLogIn);
			}
		});
		btnSearch_1.setBounds(10, 11, 89, 23);
		panel.add(btnSearch_1);
		
		JButton btnViewFavorites = new JButton("View Favorites");
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
		btnViewFavorites.setBounds(109, 11, 122, 23);
		panel.add(btnViewFavorites);
		
		frame.setSize(266, 95);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
