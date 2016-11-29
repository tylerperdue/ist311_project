import javax.swing.*;
import java.awt.*;



public class CredentialManagementApplication extends JFrame {
    
	
	CredentialManagementApplication()
	{
		
	
    
    JPanel loginWindow = new LoginWindow();
    loginWindow.setLayout(new BorderLayout());    
    
   
    setContentPane(loginWindow);
    setResizable(false);
    setLocation(400, 200);
    setSize(375, 667);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Credential Manager - Team 6");
    
	}
	
	static CredentialManagementApplication t = new CredentialManagementApplication();
	public static void main(String[] args) 
	{
            
		
		t.setVisible(true);

	}
}	

