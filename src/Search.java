import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Choice;
import java.awt.Color;

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
        lblSearchBy.setBounds(27, 17, 73, 14);
        frame.getContentPane().add(lblSearchBy);
        
        final Choice choice = new Choice();

        choice.add("Make");
        choice.add("Model");
        choice.add("Color");
        choice.add("Title");
        choice.add("Engine Type");
        choice.add("Transmission");
        choice.add("Fuel Type");
        choice.add("Form Factor");
        
        choice.setBounds(106, 11, 145, 20);
        frame.getContentPane().add(choice);
        
        JButton btnViewAll = new JButton("View All");
        btnViewAll.setBackground(new Color(225, 225, 225));
        btnViewAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
					SearchResult result = new SearchResult(login);
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        });
        btnViewAll.setBounds(164, 62, 180, 23);
        frame.getContentPane().add(btnViewAll);
        
        JLabel lblOr = new JLabel("OR");
        lblOr.setBounds(245, 37, 46, 14);
        frame.getContentPane().add(lblOr);
       
        final Choice choice_1 = new Choice();
        choice_1.setBounds(327, 11, 121, 20);
        frame.getContentPane().add(choice_1);
        
        
        JButton btnOk = new JButton("OK");
        btnOk.setBackground(new Color(225, 225, 225));
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(choice.getSelectedItem() == "Make") {
        			choice_1.removeAll();
        			try {
						String[] titles = DBConnect.getType("SELECT DISTINCT make FROM VehicleInfo;");
						for(int i = 0; i < titles.length; i++) {
							choice_1.add(titles[i]);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
        		} else if (choice.getSelectedItem() == "Model") {
        			choice_1.removeAll();
        			try {
						String[] titles = DBConnect.getType("SELECT DISTINCT model FROM VehicleInfo;");
						for(int i = 0; i < titles.length; i++) {
							choice_1.add(titles[i]);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
        		} else if (choice.getSelectedItem() == "Color") {
        			choice_1.removeAll();
        			try {
						String[] titles = DBConnect.getType("SELECT DISTINCT color FROM VehicleInfo;");
						for(int i = 0; i < titles.length; i++) {
							choice_1.add(titles[i]);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
        		} else if (choice.getSelectedItem() == "Engine Type") {
        			choice_1.removeAll();
        			try {
						String[] titles = DBConnect.getType("SELECT DISTINCT engineType FROM VehicleInfo;");
						for(int i = 0; i < titles.length; i++) {
							choice_1.add(titles[i]);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
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
        btnOk.setBounds(255, 11, 56, 20);
        frame.getContentPane().add(btnOk);

        
        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(225, 225, 225));
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
        			NarrowSearch search = new NarrowSearch(choice.getSelectedItem(), choice_1.getSelectedItem(), login);
				} catch (SQLException e) {
					e.printStackTrace();
				}
        		
        	}
        });
        btnSearch.setBounds(456, 11, 89, 20);
        frame.getContentPane().add(btnSearch);
        
        frame.setSize(580,  136);
        frame.setVisible(true);
	}
}
