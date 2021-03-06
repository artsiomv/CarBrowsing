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


public class CreateListing extends JPanel {
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
	public CreateListing(final String login) throws SQLException {
		final JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCreateNewListing = new JLabel("Create New Listing");
		lblCreateNewListing.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCreateNewListing.setBounds(10, 11, 311, 31);
		panel.add(lblCreateNewListing);

		final int num = DBConnect.getVehicleCount( "SELECT listID FROM VehicleInfo ORDER BY listID DESC LIMIT 1;");

		JButton btnOk = new JButton("Create");
		btnOk.setBackground(new Color(225, 225, 225));
		btnOk.setBounds(24, 407, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "INSERT INTO `VehicleInfo`(`listID`, `year`, `make`, `model`, `mileage`, `title`, `cost`, `engineType`, `transmission`, `powertrain`, `fuelType`, `vin`, `formFactor`, `color`, `dealID`)" +" VALUES ("+ (num+1) +", "+year.getText()+", '"+make.getText()+"', '"+model.getText()+"', "+mileage.getText()+", '"+choiceTitle.getSelectedItem()+"', "+price.getText()+", '"+engineType.getText()+"', '"+choiceTransmission.getSelectedItem()+"', '"+choicePowertrain.getSelectedItem()+"', '"+choiceFuelType.getSelectedItem()+"', '"+vin.getText()+"', '"+choiceFormFactor.getSelectedItem()+"', '"+color.getText()+"', '"+login+"');";
				try {
					DBConnect.insertListing(sql);
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
				try {
					ViewListings view = new ViewListings(login);
				} catch (SQLException e) {
					e.printStackTrace();
				}
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
		
		make = new JTextField();
		make.setBounds(145, 8, 209, 20);
		panel_1.add(make);
		make.setColumns(10);
		
		model = new JTextField();
		model.setBounds(145, 33, 209, 20);
		panel_1.add(model);
		model.setColumns(10);
		
		year = new JTextField();
		year.setBounds(145, 58, 209, 20);
		panel_1.add(year);
		year.setColumns(10);
		
		mileage = new JTextField();
		mileage.setBounds(145, 83, 209, 20);
		panel_1.add(mileage);
		mileage.setColumns(10);
		
		price = new JTextField();
		price.setBounds(145, 133, 209, 20);
		panel_1.add(price);
		price.setColumns(10);
		
		engineType = new JTextField();
		engineType.setBounds(145, 158, 209, 20);
		panel_1.add(engineType);
		engineType.setColumns(10);
		
		vin = new JTextField();
		vin.setBounds(145, 258, 209, 20);
		panel_1.add(vin);
		vin.setColumns(10);
		
		color = new JTextField();
		color.setBounds(145, 308, 209, 20);
		panel_1.add(color);
		color.setColumns(10);

		choiceTransmission = new Choice();
		String[] transmissions = DBConnect.getType("SELECT * FROM Transmission");
		for(int i = 0; i < transmissions.length; i++) {
			choiceTransmission.add(transmissions[i]);
		}
		choiceTransmission.setBounds(145, 183, 209, 20);
		panel_1.add(choiceTransmission);

		choiceTitle = new Choice();
		String[] titles = DBConnect.getType("SELECT * FROM Title");
		for(int i = 0; i < titles.length; i++) {
			choiceTitle.add(titles[i]);
		}
		choiceTitle.setBounds(145, 108, 209, 20);
		panel_1.add(choiceTitle);
		choiceFuelType = new Choice();
		String[] fuels = DBConnect.getType("SELECT * FROM Fuel");
		for(int i = 0; i < fuels.length; i++) {
			choiceFuelType.add(fuels[i]);
		}
		choiceFuelType.setBounds(145, 233, 209, 20);
		panel_1.add(choiceFuelType);
		
		choicePowertrain = new Choice();
		String[] trains = DBConnect.getType("SELECT * FROM Powertrain");
		for(int i = 0; i < trains.length; i++) {
			choicePowertrain.add(trains[i]);
		}
		choicePowertrain.setBounds(145, 208, 209, 20);
		panel_1.add(choicePowertrain);
		
		choiceFormFactor = new Choice();
		String[] forms = DBConnect.getType("SELECT * FROM FormFactor");
		for(int i = 0; i < forms.length; i++) {
			choiceFormFactor.add(forms[i]);
		}
		choiceFormFactor.setBounds(145, 283, 209, 20);
		panel_1.add(choiceFormFactor);
		
		frame.setSize(400, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
