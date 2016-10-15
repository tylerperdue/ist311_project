

package credentialmanagementapplication;

import javax.swing.*;
import java.awt.*;



public class CredentialManagementApplication extends JFrame {
    
     
     
	public static void main(String[] args) 
	{
            //all of this is basically so that the background image would show
            JPanel loginWindow = new LoginWindow();
            loginWindow.setLayout(new BorderLayout());
            loginWindow.add(new LoginWindow(), BorderLayout.CENTER);

            CredentialManagementApplication t = new CredentialManagementApplication();
            t.setContentPane(loginWindow);
            t.setResizable(false);
            t.setSize(450, 650);
            t.setLocation(500, 150);
            t.setDefaultCloseOperation(EXIT_ON_CLOSE);
            t.setVisible(true);
            t.setTitle("Credential Management");

	}
}	

