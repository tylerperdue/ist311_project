package credentialmanagementapplication;

import javax.swing.*;
import java.awt.*;



public class CredentialManagementApplication extends JFrame {
    
     
     static CredentialManagementApplication t = new CredentialManagementApplication();
	public static void main(String[] args) 
	{
            
            JPanel loginWindow = new LoginWindow();
            loginWindow.setLayout(new BorderLayout());
            loginWindow.add(new LoginWindow(), BorderLayout.CENTER);
            
              t.setVisible(true);
            t.setContentPane(loginWindow);
            t.setResizable(false);
            t.setSize(450, 650);
            t.setLocation(500, 150);
            t.setDefaultCloseOperation(EXIT_ON_CLOSE);
            t.setTitle("Credential Manager - Team 6");

	}
}	

