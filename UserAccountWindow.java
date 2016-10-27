
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class UserAccountWindow extends JPanel implements ActionListener
{

	// Define JLabels, JButtons, JTextFields....


	public UserAccountWindow()
	{
		
		
		
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