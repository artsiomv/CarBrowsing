import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
 
/* PasswordDemo.java requires no other files. */
 
public class LogIn extends JPanel
                          implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";
 
    private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;
    private JTextField textField;
    Panel panel;
    public LogIn(JFrame f) {
        //Use the default FlowLayout.
        controllingFrame = f;
 
        setLayout(new BorderLayout(0, 0));
 
        //Lay out everything.
        JPanel textPane = new JPanel();
        textPane.setLayout(null);
 
        add(textPane);
        
        panel = new Panel();
        add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblEnterTheLogin = new JLabel("Login:");
        panel.add(lblEnterTheLogin);
        
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblEnterYourPassword = new JLabel("Password: ");
        panel.add(lblEnterYourPassword);
                      
        //Create everything.
        passwordField = new JPasswordField(10);
        panel.add(passwordField);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);
        lblEnterYourPassword.setLabelFor(passwordField);
        
        JButton okButton = new JButton("OK");
        panel.add(okButton);
        okButton.setActionCommand(OK);
        okButton.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        UserDB[] c = DatabaseAccess.GetUsers();
        if (OK.equals(cmd)) { //Process the password and login
        	String inputLogIn = textField.getText();
            char[] passwordChar = passwordField.getPassword();
            String password = String.valueOf(passwordChar);
//            System.out.println(inputLogIn);
//            System.out.println(password);
//            if (isLogInCorrect(inputLogIn, password, c)) {
//            	if(inputLogIn.equals("dealer")) {
//            		Dealer deal = new Dealer(inputLogIn);
//            	}
//            	else if(inputLogIn.equals("user")) {
//            		User user = new User(inputLogIn);
//            	}
            boolean logIn = true;
        	for(int i = 0; i < c.length; i++) {
        		if(c[i].username.equals(inputLogIn) && c[i].password.equals(password)) {
        			logIn = true;
        			if(c[i].idNum.contains("U")) {
        				User user = new User(inputLogIn);
        			}
        			else if (c[i].idNum.contains("D")) {
        				Dealer deal = new Dealer(c[i].idNum);
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
     */
    private static void createAndShowGUI() {
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
        frame.setVisible(true);
    }

 
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
            }
        });
    }
}
