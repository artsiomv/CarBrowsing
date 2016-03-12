import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Choice;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JList;


public class Edit extends JPanel {
	private JTextField make;
	private JTextField model;
	private JTextField year;
	private JTextField mileage;
	private JTextField price;
	private JTextField engineType;
	private JTextField vin;
	private JTextField color;
	private Choice choiceTransmission, choicePowertrain, choiceTitle, choiceFuelType, choiceFormFactor;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Edit(final String login, final int listID) throws SQLException {
		final JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCreateNewListing = new JLabel("Update Listing");
		lblCreateNewListing.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCreateNewListing.setBounds(10, 11, 311, 31);
		panel.add(lblCreateNewListing);

		JButton btnOk = new JButton("Update");
		btnOk.setBackground(new Color(225, 225, 225));
		btnOk.setBounds(24, 407, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "UPDATE `VehicleInfo` SET listID = listID, year = "+year.getText()+", make = '"+make.getText()+"', model = '"+model.getText()+"', mileage = "+mileage.getText()+", title = '"+choiceTitle.getSelectedItem()+"', cost = "+price.getText()+", engineType = '"+engineType.getText()+"', transmission = '"+choiceTransmission.getSelectedItem()+"', powertrain = '"+choicePowertrain.getSelectedItem()+"', fuelType = '"+choiceFuelType.getSelectedItem()+"', vin = '"+vin.getText()+"', formFactor = '"+choiceFormFactor+"', color = '"+color.getText()+"', dealID = '"+login+"' WHERE listID = "+listID+";";
				try {
					DBConnect.insertListing(sql);
					JOptionPane.showMessageDialog(frame,
							"Your listing has been updated.",
							"Success",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame,
							"Your listing has NOT been updated. Please try again.",
							"Something went wrong",
							JOptionPane.ERROR_MESSAGE);
				}
				try {
					ViewListings view = new ViewListings(login);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		panel.add(btnOk);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 53, 364, 339);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMake = new JLabel("Make:");
		lblMake.setBounds(0, 11, 92, 14);
		panel_1.add(lblMake);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(0, 36, 92, 14);
		panel_1.add(lblModel);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(0, 61, 92, 14);
		panel_1.add(lblYear);
		
		JLabel lblMileage = new JLabel("Mileage:");
		lblMileage.setBounds(0, 86, 92, 14);
		panel_1.add(lblMileage);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(0, 111, 92, 14);
		panel_1.add(lblTitle);
		
		JLabel lblCost = new JLabel("Price:");
		lblCost.setBounds(0, 136, 92, 14);
		panel_1.add(lblCost);
		
		JLabel lblEngineType = new JLabel("Engine Type:");
		lblEngineType.setBounds(0, 161, 92, 14);
		panel_1.add(lblEngineType);
		
		JLabel lblTransmission = new JLabel("Transmission:");
		lblTransmission.setBounds(0, 186, 92, 14);
		panel_1.add(lblTransmission);
		
		JLabel lblPowertrain = new JLabel("Powertrain:");
		lblPowertrain.setBounds(0, 211, 92, 14);
		panel_1.add(lblPowertrain);
		
		JLabel lblFuelType = new JLabel("Fuel Type:");
		lblFuelType.setBounds(0, 236, 92, 14);
		panel_1.add(lblFuelType);
		
		JLabel lblVin = new JLabel("VIN:");
		lblVin.setBounds(0, 261, 92, 14);
		panel_1.add(lblVin);
		
		JLabel lblFormFactor = new JLabel("Form Factor:");
		lblFormFactor.setBounds(0, 286, 92, 14);
		panel_1.add(lblFormFactor);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(0, 311, 92, 14);
		panel_1.add(lblColor);
		
		make = new JTextField(DBConnect.selectQuery( "SELECT make FROM VehicleInfo WHERE listID = "+listID+";", "make"));
		make.setBounds(145, 8, 209, 20);
		panel_1.add(make);
		make.setColumns(10);
		
		model = new JTextField(DBConnect.selectQuery( "SELECT model FROM VehicleInfo WHERE listID = "+listID+";", "model"));
		model.setBounds(145, 33, 209, 20);
		panel_1.add(model);
		model.setColumns(10);
		
		year = new JTextField(DBConnect.selectQuery( "SELECT year FROM VehicleInfo WHERE listID = "+listID+";", "year"));
		year.setBounds(145, 58, 209, 20);
		panel_1.add(year);
		year.setColumns(10);
		
		mileage = new JTextField(DBConnect.selectQuery( "SELECT mileage FROM VehicleInfo WHERE listID = "+listID+";", "mileage"));
		mileage.setBounds(145, 83, 209, 20);
		panel_1.add(mileage);
		mileage.setColumns(10);
		
		price = new JTextField(DBConnect.selectQuery( "SELECT cost FROM VehicleInfo WHERE listID = "+listID+";", "cost"));
		price.setBounds(145, 133, 209, 20);
		panel_1.add(price);
		price.setColumns(10);
		
		engineType = new JTextField(DBConnect.selectQuery( "SELECT engineType FROM VehicleInfo WHERE listID = "+listID+";", "engineType"));
		engineType.setBounds(145, 158, 209, 20);
		panel_1.add(engineType);
		engineType.setColumns(10);
		
		vin = new JTextField(DBConnect.selectQuery( "SELECT vin FROM VehicleInfo WHERE listID = "+listID+";", "vin"));
		vin.setBounds(145, 258, 209, 20);
		panel_1.add(vin);
		vin.setColumns(10);
		
		color = new JTextField(DBConnect.selectQuery( "SELECT color FROM VehicleInfo WHERE listID = "+listID+";", "color"));
		color.setBounds(145, 308, 209, 20);
		panel_1.add(color);
		color.setColumns(10);

		choiceTransmission = new Choice();
		String[] transmissions = DBConnect.getType("SELECT * FROM Transmission");
		for(int i = 0; i < transmissions.length; i++) {
			choiceTransmission.add(transmissions[i]);
		}
		choiceTransmission.select(DBConnect.selectQuery( "SELECT transmission FROM VehicleInfo WHERE listID = "+listID+";", "transmission"));
		choiceTransmission.setBounds(145, 183, 209, 20);
		panel_1.add(choiceTransmission);

		choiceTitle = new Choice();
		String[] titles = DBConnect.getType("SELECT * FROM Title");
		for(int i = 0; i < titles.length; i++) {
			choiceTitle.add(titles[i]);
		}
		choiceTitle.select(DBConnect.selectQuery( "SELECT title FROM VehicleInfo WHERE listID = "+listID+";", "title"));
		choiceTitle.setBounds(145, 108, 209, 20);
		panel_1.add(choiceTitle);
		
		choiceFuelType = new Choice();
		String[] fuels = DBConnect.getType("SELECT * FROM Fuel");
		for(int i = 0; i < fuels.length; i++) {
			choiceFuelType.add(fuels[i]);
		}
		choiceFuelType.select(DBConnect.selectQuery( "SELECT fuelType FROM VehicleInfo WHERE listID = "+listID+";", "fuelType"));
		
		choiceFuelType.setBounds(145, 233, 209, 20);
		panel_1.add(choiceFuelType);
		
		choicePowertrain = new Choice();
		String[] trains = DBConnect.getType("SELECT * FROM Powertrain");
		for(int i = 0; i < trains.length; i++) {
			choicePowertrain.add(trains[i]);
		}
		choicePowertrain.select(DBConnect.selectQuery( "SELECT powertrain FROM VehicleInfo WHERE listID = "+listID+";", "powertrain"));
		choicePowertrain.setBounds(145, 208, 209, 20);
		panel_1.add(choicePowertrain);
		
		choiceFormFactor = new Choice();
		String[] forms = DBConnect.getType("SELECT * FROM FormFactor");
		for(int i = 0; i < forms.length; i++) {
			choiceFormFactor.add(forms[i]);
		}
		choiceFormFactor.select(DBConnect.selectQuery( "SELECT formFactor FROM VehicleInfo WHERE listID = "+listID+";", "formFactor"));
		choiceFormFactor.setBounds(145, 283, 209, 20);
		panel_1.add(choiceFormFactor);
		
		frame.setSize(400, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}