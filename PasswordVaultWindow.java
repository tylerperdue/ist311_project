import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;



public class PasswordVaultWindow extends JPanel implements ActionListener
{

	// Define JLabels, JButtons, JTextFields....

	

	JLabel lblSelect = new JLabel("Select desired category and verify your identity:");
	
	JLabel lblVerification = new JLabel("Verify your identity:");
	
	JLabel lblUsername = new JLabel("Username:");
	JLabel lblPassword = new JLabel("Password:");
	

	JLabel lblList = new JLabel("Please select a category:");
	
	
	JButton btnAuthentication = new JButton("Authenticate");
	
	JTextField txtUsername = new JTextField(10);
	JPasswordField txtPassword = new JPasswordField(10);
	
	public static String[] strCategories = {"Personal", "Email", "Work", "Finances"};
	
	JComboBox cmbCategories = new JComboBox(strCategories);
	
	LoggedInUser loggedUser;
	

	

	
	public PasswordVaultWindow(LoggedInUser lu)
	{
		

		

		
//		list.setVisibleRowCount(3);
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		

		
		add(lblSelect);
		add(lblVerification);
		add(lblUsername);
		add(txtUsername);
		add(lblPassword);
		add(txtPassword);
		add(btnAuthentication);
		add(lblList);
		add(cmbCategories);
		
		System.out.println(this.cmbCategories.getSelectedItem());


		
		loggedUser = lu;
		
		
		this.btnAuthentication.addActionListener(this);

		

		// this.btnPwdGenerator.addActionListener(this);
		// this.btnPwdVault.addActionListener(this);
		// this.btnAddCredentials.addActionListener(this);
		// this.btnUserAccount.addActionListener(this);
		// this.btnLogout.addActionListener(this);
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		
		switch(ae.getActionCommand())
		{
		
		case "Authenticate":
			
			if(txtUsername.getText().equals(loggedUser.getUser()))
			{
			LoginController lc = new LoginController(txtUsername.getText(), txtPassword.getPassword());
			lc.authenticated = lc.authenticate();
				if(lc.authenticated)
				{
					JOptionPane.showMessageDialog(null, "Username matched! (Test)");
					JOptionPane.showMessageDialog(null, "Authenticated!");
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Username and/or password incorrect.");
					System.out.println("You cannot retrieve Information");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Your username does not match the current username! (Test)");
			}
			
		break;
		case "Password Generator":

		break;
			
		case "Password Vault":

        break;

		case "Add Credentials":

		break;	

		case "User Account":

		break;

		case "Logout":

		break;		
		}
	}
}