package credentialmanagementapplication;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class PasswordVaultWindow extends JPanel implements ActionListener
{

	// Define JLabels, JButtons, JTextFields....

        LoginWindow verification = new LoginWindow();

	JLabel lblSelect = new JLabel("Select desired category and verify your identity:");
	
	JLabel lblVerification = new JLabel("Verify your identity:");
	
	JButton btnAuthentication = new JButton("Authenticate");
	
	JTextField txtUsername = new JTextField(10);
	JPasswordField txtPassword = new JPasswordField(10);
	
	JTree Categories = new JTree();
	
	public PasswordVaultWindow()
	{
		
//		this.setLayout(new FlowLayout());
//		this.setResizable(false);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(400, 340);
//		this.setLocationRelativeTo(null);
//		this.getContentPane().setBackground(Color.WHITE);
//		
//		
//		add(lblSelect);
//		add(lblVerification);
//		add(verification.lblUsername);
//		add(txtUsername);
//		add(verification.lblPassword);
//		add(txtPassword);
//		add(this.btnAuthentication);
//		
//		
//		
//		
//		
//		
//		this.btnAuthentication.addActionListener(this);
		
		// // p1.setBackground(Color.WHITE);
		// // p1.add(btnPwdGenerator);
		// // p1.add(btnPwdVault);

		// // p2.setBackground(Color.WHITE);
		// // p2.add(btnAddCredentials);
		// // p2.add(btnUserAccount);

		// // p3.setBackground(Color.WHITE);
		// // p3.add(btnLogout);
		
		// // add(p1);
		// // add(p2);
		// // add(p3);

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
			
			
			LoginController lc = new LoginController(txtUsername.getText(), txtPassword.getPassword());
			lc.authenticated = lc.authenticate();
			
			if(lc.authenticated)
			{
				JOptionPane.showMessageDialog(null, "Authenticated!");
				
//				this.add();
			}
			
			
			else
			{
				JOptionPane.showMessageDialog(null, "Username and/or password incorrect.");
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