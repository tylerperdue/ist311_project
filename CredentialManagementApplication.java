import javax.swing.*;
import java.awt.*;



public class CredentialManagementApplication extends JFrame {
    
	
	CredentialManagementApplication()
	{
		
	
    
    JPanel loginWindow = new LoginWindow();
    loginWindow.setLayout(new BorderLayout());
    loginWindow.add(new LoginWindow(), BorderLayout.CENTER);
    
    
   
    setContentPane(loginWindow);
    setResizable(false);
    setLocation(400, 200);
    setSize(450, 650);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Credential Manager - Team 6");
    
	}
	
	static CredentialManagementApplication t = new CredentialManagementApplication();
	public static void main(String[] args) 
	{
            
		
		t.setVisible(true);

	}
}	

