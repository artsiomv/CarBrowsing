import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
 
/* PasswordDemo.java requires no other files. */
 
public class LogIn extends JPanel
                          implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";
 
    private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;
    private JTextField textField;
    Panel panel;
    public LogIn(JFrame f) throws IOException {
        //Use the default FlowLayout.
        controllingFrame = f;
 
        setLayout(new BorderLayout(0, 0));
        
        panel = new Panel();
        add(panel);
        panel.setLayout(null);
        
        JLabel lblEnterTheLogin = new JLabel("Login:");
        lblEnterTheLogin.setBounds(20, 112, 48, 14);
        panel.add(lblEnterTheLogin);
        
        textField = new JTextField();
        textField.setBounds(68, 109, 86, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblEnterYourPassword = new JLabel("Password: ");
        lblEnterYourPassword.setBounds(164, 112, 65, 14);
        panel.add(lblEnterYourPassword);
                      
        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setBounds(239, 109, 86, 20);
        panel.add(passwordField);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);
        lblEnterYourPassword.setLabelFor(passwordField);
        
        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(225, 225, 225));
        okButton.setBounds(95, 140, 63, 23);
        panel.add(okButton);
        okButton.setActionCommand(OK);
        
        JButton btnSignUp = new JButton("Sign up");
        btnSignUp.setBackground(new Color(225, 225, 225));
        btnSignUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		CreateUser user = new CreateUser();
        	}
        });
        btnSignUp.setBounds(164, 140, 89, 23);
        panel.add(btnSignUp);
        
        File file = new File("./carBrowsing.png");
        BufferedImage image = ImageIO.read(file);
        JLabel lblNewLabel = new JLabel(new ImageIcon(image));
        lblNewLabel.setBounds(0, 0, 362, 174);
        panel.add(lblNewLabel);
        okButton.addActionListener(this);
        controllingFrame.setPreferredSize(new Dimension(360, 220));
    }
 
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        UserDB[] c = DatabaseAccess.GetUsers();
        if (OK.equals(cmd)) { //Process the password and login
        	String inputLogIn = textField.getText();
            char[] passwordChar = passwordField.getPassword();
            String password = String.valueOf(passwordChar);

            boolean logIn = true;
        	for(int i = 0; i < c.length; i++) {
        		if(c[i].username.equals(inputLogIn) && c[i].password.equals(password)) {
        			logIn = true;
        			if(c[i].idNum.contains("U")) {
        				try {
							User user = new User(c[i].idNum);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
        			}
        			else if (c[i].idNum.contains("D")) {
        				try {
							Dealer deal = new Dealer(c[i].idNum);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        			break;
        		} else logIn = false;
        	}
        	if(!logIn) {
        		JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid password/login. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
        	}
            passwordField.selectAll();
            resetFocus();
        }
    }
 
    //Must be called from the event dispatch thread.
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     * @throws IOException 
     */
    private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("Log In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        final LogIn newContentPane = new LogIn(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });
 
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

 
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        try {
			createAndShowGUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
            }
        });
    }
}
