import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PasswordGenWindow extends JFrame implements ActionListener
{

	// Define JLabels, JButtons, JTextFields....


	public PasswordGenWindow()
	{
		
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 340);
		this.setLocation(500, 250);
		this.getContentPane().setBackground(Color.WHITE);
		
		
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
