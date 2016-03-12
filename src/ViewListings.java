import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class ViewListings extends JPanel {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public ViewListings(final String login) throws SQLException {
		final JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		int numOfCars = DBConnect.getVehicleCount( "SELECT COUNT(*) FROM VehicleInfo WHERE dealID = '"+login+"';");
		String[] nums = DBConnect.getType( "SELECT listID FROM VehicleInfo WHERE dealID = '"+login+"';");
		final int[] numss = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			numss[i] = Integer.parseInt(nums[i]);
		}
		
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getViewport();
		scrollPane.setBounds(0, 0, 724, 361);
		
		panel.setPreferredSize(new Dimension(700, numOfCars*100));
		frame.getContentPane().add(scrollPane);
		
		for(int carNum = 1; carNum <= numss.length; carNum++) {
			final int i = carNum;
			JButton btnDelete = new JButton("DELETE");
			btnDelete.setBackground(new Color(225, 225, 225));
			btnDelete.setBounds(517, 57+(100*(i-1)), 100, 23);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Object[] options = { "Yes", "No" };
					    int n = JOptionPane.showOptionDialog(new JFrame(),
					            "Are you sure?", "",
					            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					            options, options[1]);
						if(n == JOptionPane.OK_OPTION) {
							DBConnect.deleteVehicle("DELETE FROM VehicleInfo WHERE listID = " + numss[i-1] + ";");
							ViewListings view = new ViewListings(login);
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			
			JButton btnEdit = new JButton("EDIT");
			btnEdit.setBackground(new Color(225, 225, 225));
			btnEdit.setBounds(620, 57+(100*(i-1)), 100, 23);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						Object[] options = { "Yes", "No" };
					    int n = JOptionPane.showOptionDialog(new JFrame(),
					            "Are you sure?", "",
					            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					            options, options[1]);
						if(n == JOptionPane.OK_OPTION) {
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
							try {
								Edit edit = new Edit(login, numss[i-1]);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
				}
			});
			
			JLabel label = new JLabel(i+". ");
			label.setBounds(0, 0+(100*(i-1)), 30, 14);
			
			JLabel lblYear = new JLabel("Year: " + DBConnect.selectQuery("SELECT year FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "year"));
			lblYear.setBounds(22, 0+(100*(i-1)), 84, 14);
			
			JLabel lblMake = new JLabel("Make: " + DBConnect.selectQuery("SELECT make FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "make"));
			lblMake.setBounds(131, 0+(100*(i-1)), 120, 14);
			
			JLabel lblModel = new JLabel("Model: " + DBConnect.selectQuery("SELECT model FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "model"));
			lblModel.setBounds(304, 0+(100*(i-1)), 160, 14);
			
			JLabel lblCost = new JLabel("Cost: " + DBConnect.selectQuery("SELECT cost FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "cost"));
			lblCost.setBounds(517, 0+(100*(i-1)), 180, 14);
			
			JLabel lblTitle = new JLabel("Title: " + DBConnect.selectQuery("SELECT title FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "title"));
			lblTitle.setBounds(22, 19+(100*(i-1)), 82, 14);
			
			JLabel lblMileage = new JLabel("Mileage: " + DBConnect.selectQuery("SELECT mileage FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "mileage"));
			lblMileage.setBounds(131, 19+(100*(i-1)), 98, 14);
			
			JLabel lblPowertrain = new JLabel("Powertrain: " + DBConnect.selectQuery("SELECT powertrain FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "powertrain"));
			lblPowertrain.setBounds(304, 19+(100*(i-1)), 208, 14);
			
			JLabel lblEngineType = new JLabel("Engine Type: " + DBConnect.selectQuery("SELECT engineType FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "engineType"));
			lblEngineType.setBounds(517, 19+(100*(i-1)), 150, 14);
			
			JLabel lblColor = new JLabel("Color: " + DBConnect.selectQuery("SELECT color FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "color"));
			lblColor.setBounds(22, 38+(100*(i-1)), 104, 14);
			
			JLabel lblTransmission = new JLabel("Transmission: " + DBConnect.selectQuery("SELECT transmission FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "transmission"));
			lblTransmission.setBounds(131, 38+(100*(i-1)), 168, 14);
			
			JLabel lblDealid = new JLabel("DealID: " + DBConnect.selectQuery("SELECT dealID FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "dealID"));
			lblDealid.setBounds(304, 38+(100*(i-1)), 208, 14);
			
			JLabel lblFuelType = new JLabel("Fuel Type: " + DBConnect.selectQuery("SELECT fuelType FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "fuelType"));
			lblFuelType.setBounds(517, 38+(100*(i-1)), 140, 14);
			
			JLabel lblVin = new JLabel("VIN#: " + DBConnect.selectQuery("SELECT vin FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "vin"));
			lblVin.setBounds(22, 61+(100*(i-1)), 196, 14);
			
			JLabel lblFormFactor = new JLabel("Form Factor: " + DBConnect.selectQuery("SELECT formFactor FROM VehicleInfo WHERE listID = " + numss[i-1] +";", "formFactor"));
			lblFormFactor.setBounds(304, 61+(100*(i-1)), 160, 14);
			
			JLabel label_3 = new JLabel("--------------------------");
			label_3.setBounds(22, 85+(100*(i-1)), 104, 14);
			
			JLabel label_1 = new JLabel("------------------------------------------");
			label_1.setBounds(131, 85+(100*(i-1)), 168, 14);
			
			JLabel label_2 = new JLabel("----------------------------------------------------");
			label_2.setBounds(304, 85+(100*(i-1)), 208, 14);
			
			JLabel label_4 = new JLabel("---------------------------------------------");
			label_4.setBounds(517, 85+(100*(i-1)), 180, 14);
			
			panel.setLayout(null);
			panel.add(label);
			panel.add(lblYear);
			panel.add(lblMake);
			panel.add(lblModel);
			panel.add(lblCost);
			panel.add(lblTitle);
			panel.add(lblMileage);
			panel.add(lblPowertrain);
			panel.add(lblEngineType);
			panel.add(lblColor);
			panel.add(lblTransmission);
			panel.add(lblDealid);
			panel.add(lblFuelType);
			panel.add(lblVin);
			panel.add(lblFormFactor);
			panel.add(btnDelete);
			panel.add(btnEdit);
			panel.add(label_3);
			panel.add(label_1);
			panel.add(label_2);
			panel.add(label_4);
		}
		
		frame.setSize(740,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
