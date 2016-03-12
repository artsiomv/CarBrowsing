import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Choice;
import java.sql.SQLException;
import java.util.Random;


public class CreateUser extends JPanel {
	private JTextField fName;
	private JTextField lName;
	private JTextField date;
	private JTextField address;
	private JTextField phone;
	private JTextField eMail;
	private JTextField username;
	private JTextField password;
	private Choice choice;

	/**
	 * Create the panel.
	 */
	public CreateUser() {
		final JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeNewUser = new JLabel("Welcome");
		lblWelcomeNewUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWelcomeNewUser.setBounds(10, 11, 103, 14);
		frame.getContentPane().add(lblWelcomeNewUser);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 36, 133, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 61, 133, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblBirthDate = new JLabel("Birth date: YYYY-MM-DD");
		lblBirthDate.setBounds(10, 86, 133, 14);
		frame.getContentPane().add(lblBirthDate);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 111, 127, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone #: XXXXXXXXXX");
		lblPhone.setBounds(10, 134, 133, 14);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("eMail:");
		lblEmail.setBounds(10, 159, 133, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 184, 133, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 209, 133, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblWhoAreYou = new JLabel("Who are you?");
		lblWhoAreYou.setBounds(10, 234, 133, 14);
		frame.getContentPane().add(lblWhoAreYou);
		
		fName = new JTextField();
		fName.setBounds(172, 33, 133, 20);
		frame.getContentPane().add(fName);
		fName.setColumns(10);
		
		lName = new JTextField();
		lName.setBounds(172, 58, 133, 20);
		frame.getContentPane().add(lName);
		lName.setColumns(10);
		
		date = new JTextField();
		date.setBounds(172, 83, 133, 20);
		frame.getContentPane().add(date);
		date.setColumns(10);
		
		address = new JTextField();
		address.setBounds(172, 108, 133, 20);
		frame.getContentPane().add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(172, 131, 133, 20);
		frame.getContentPane().add(phone);
		phone.setColumns(10);
		
		eMail = new JTextField();
		eMail.setBounds(172, 156, 133, 20);
		frame.getContentPane().add(eMail);
		eMail.setColumns(10);
		
		username = new JTextField();
		username.setBounds(172, 181, 133, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(172, 206, 133, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();
				int num = rand.nextInt(9000000 - 1 + 1000000);
				String id = Integer.toString(num);
				int off = 9-id.length();
				for(int i = 0; i < off; i++) {
					id = "0"+id;
				}
				if(choice.getSelectedItem().equals("Dealer")) id = "D"+id;
				else id = "U"+id;
				String sql = "INSERT INTO `User`(`fName`, `lName`, `bDay`, `address`, `phoneNum`, `eMail`, `username`, `password`, `idNum`)" +" VALUES ('"+ fName.getText()+"', '"+lName.getText()+"', '"+date.getText()+"', '"+address.getText()+"', "+phone.getText()+", '"+eMail.getText()+"', '"+ username.getText()+"', '"+password.getText()+"', '"+id+"');";                                    
				try {
					DatabaseAccess.insert(sql);
					JOptionPane.showMessageDialog(frame,
							"Your listing has been created.",
							"Success",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame,
							"Your listing has NOT been created. Please try again.",
							"Something went wrong",
							JOptionPane.ERROR_MESSAGE);
				}
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnNewButton.setBackground(new Color(225, 225, 225));
		btnNewButton.setBounds(10, 283, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		choice = new Choice();
		choice.add("Dealer");
		choice.add("User");
		choice.setBounds(172, 234, 133, 20);
		frame.getContentPane().add(choice);
		
		frame.setSize(380,362);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
