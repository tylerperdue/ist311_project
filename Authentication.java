import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Authentication extends JFrame implements ActionListener
{

	private JButton cmdAuthenticate; 		
	private JButton cmdCancel;		
	private JTextField txtUsername;	 
	private JPasswordField txtPassword; 
	private JLabel lblUserName; 	
	private JLabel lblPassword; 
	
	LoggedInUser loggedUser;


	public Authentication(LoggedInUser lu)
	{
		
		lblUserName = new JLabel(" Username:"); 
		lblUserName.setToolTipText("Please enter username in the field below");
		add(lblUserName);

		
		txtUsername = new JTextField(10); 
		txtUsername.setVisible(true);
		add(txtUsername); 
		

		lblPassword = new JLabel(" Password:"); 
		lblPassword.setToolTipText("Please enter password in the field below (8-15) characters");
		add(lblPassword); 
		
		txtPassword = new JPasswordField(10); 	
		txtPassword.setVisible(true);
		add(txtPassword);		
		
		
		cmdCancel = new JButton("Cancel"); 
		add(cmdCancel);	
		cmdCancel.addActionListener(this);
		
		cmdAuthenticate = new JButton("Authenticate");
		add(cmdAuthenticate); 
		cmdAuthenticate.addActionListener(this);
		
		this.setTitle("Authentication"); 
		setLayout(new FlowLayout()); 
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(500,300); 	
		this.setSize(260, 150); 
		this.setResizable(false);
		
		loggedUser = lu;
		

	}
	



		public void actionPerformed(ActionEvent ae)
		{
			switch(ae.getActionCommand())
			{
			case "Cancel":
				this.setVisible(false);
				this.dispose();
			break;
			case "Authenticate":
				
				if(txtUsername.getText().equals(loggedUser.getUser()))
				{
				LoginController lc = new LoginController(txtUsername.getText(), txtPassword.getPassword());
				lc.authenticated = lc.authenticate();
					if(lc.authenticated)
					{
		                    
						this.setVisible(false);
		                this.dispose();
		                
						MainFrame.mainFrame.getContentPane().removeAll();
	                    PasswordVaultWindow pv = new PasswordVaultWindow(loggedUser);
	                    MainFrame.mainFrame.add(pv);
	                    MainFrame.mainFrame.getContentPane().invalidate();
	                    MainFrame.mainFrame.getContentPane().validate();
	                    
	                    JOptionPane.showMessageDialog(null, "You are successfully authenticated!");
	                    
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and/or password incorrect.");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Your username does not match the current username! (Test)");
				}
				
			break;
					
			
			default:		// do nothing
				break;

			}
		} // ends actionPerformed method
		
}
		