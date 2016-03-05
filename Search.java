import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Choice;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class Search extends JPanel {

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public Search(final String login) {
		final JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        
        JLabel lblSearchBy = new JLabel("Search By:");
        lblSearchBy.setBounds(10, 11, 56, 14);
        frame.getContentPane().add(lblSearchBy);
        
        final Choice choice = new Choice();

        choice.add("Make");
        choice.add("Title");
        choice.add("Transmission");
        choice.add("Fuel Type");
        choice.add("Form Factor");
        
        choice.setBounds(72, 11, 145, 20);
        frame.getContentPane().add(choice);
        
        JButton btnViewAll = new JButton("View All");
        btnViewAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
					SearchResult result = new SearchResult(login);
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        });
        btnViewAll.setBounds(128, 62, 180, 23);
        frame.getContentPane().add(btnViewAll);
        
        JLabel lblOr = new JLabel("OR");
        lblOr.setBounds(209, 37, 46, 14);
        frame.getContentPane().add(lblOr);
       
        final Choice choice_1 = new Choice();
        choice_1.setBounds(291, 11, 121, 20);
        frame.getContentPane().add(choice_1);
        
        
        
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(choice.getSelectedItem() == "Make") {
        			choice_1.removeAll();
        			choice_1.setEnabled(false);
        		} else if (choice.getSelectedItem() == "Title") {
        			choice_1.removeAll();
        			choice_1.setEnabled(true);
        			try {
						String[] titles = DBConnect.getType("SELECT * FROM Title");
						for(int i = 0; i < titles.length; i++) {
							choice_1.add(titles[i]);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
        		} else if (choice.getSelectedItem() == "Transmission") {
        			choice_1.removeAll();
        			choice_1.setEnabled(true);
        			try {
						String[] transmission = DBConnect.getType("SELECT * FROM Transmission");
						for(int i = 0; i < transmission.length; i++) {
							choice_1.add(transmission[i]);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
        		} else if (choice.getSelectedItem() == "Fuel Type") {
        			choice_1.removeAll();
        			choice_1.setEnabled(true);
        			try {
						String[] fuel = DBConnect.getType("SELECT * FROM Fuel");
						for(int i = 0; i < fuel.length; i++) {
							choice_1.add(fuel[i]);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
        		} else if (choice.getSelectedItem() == "Form Factor") {
        			choice_1.removeAll();
        			choice_1.setEnabled(true);
        			try {
						String[] formFactor = DBConnect.getType("SELECT * FROM FormFactor");
						for(int i = 0; i < formFactor.length; i++) {
							choice_1.add(formFactor[i]);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
        		}
        	}
        });
        btnOk.setBounds(219, 11, 56, 20);
        frame.getContentPane().add(btnOk);

        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
//        			System.out.println(choice_1.getSelectedItem());
					NarrowSearch search = new NarrowSearch(choice.getSelectedItem(), choice_1.getSelectedItem(), login);
				} catch (SQLException e) {
					e.printStackTrace();
				}
        		
        	}
        });
        btnSearch.setBounds(420, 11, 89, 20);
        frame.getContentPane().add(btnSearch);
        
        frame.setSize(543,  136);
        frame.setVisible(true);
	}
}
