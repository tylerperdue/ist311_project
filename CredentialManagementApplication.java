import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.io.IOException;



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
			try {
				AESCrypt a = new AESCrypt(true, "password");
				File credentials = new File("CREDENTIALS.txt");
				File credentials_encrypted = new File("CREDENTIALS_encrypted.txt");
				a.decrypt("CREDENTIALS_encrypted.txt", "CREDENTIALS.txt");
				boolean x = credentials_encrypted.delete();
				File userlist = new File("USERLIST.txt");
				File userlist_encrypted = new File("USERLIST_encrypted.txt");
				a.decrypt("USERLIST_encrypted.txt", "USERLIST.txt");
				boolean y = userlist_encrypted.delete();

			} catch (Exception e) {
				e.printStackTrace();
			}
			t.setVisible(true);
		}
}	

