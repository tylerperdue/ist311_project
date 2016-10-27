import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LoginWindow extends JPanel 
{
     private Handler handler = new Handler();  
     //JFrame frame = new JFrame();
        //background image pulled from URL
       static BufferedImage bgimg = null;{
        try {
                bgimg = ImageIO.read(new URL("http://i.imgur.com/htBdPYl.png"));
        } catch (IOException e) {
                System.out.println("Error");
        }}
       
    //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  
	
        //loginwindow elements
	JButton btnLogin = new JButton("Login");
	JButton btnCancel = new JButton("Cancel");
	JButton btnNewAccount = new JButton("Create New Account");
        JTextField usernameTxtField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
	String LOGGEDINUSER;
	
	public LoginWindow() 
	{
		 
            setOpaque(false);
            
            //layout set to null so setbounds can work
            this.setLayout(null);
     
        usernameTxtField.setBounds(230, 290, 135, 35);
        passwordField.setBounds(230, 356, 135, 35);
        add(usernameTxtField);
        add(passwordField);
        btnLogin.setBounds(125, 427, 90, 35);
        add(btnLogin);      
        btnLogin.addActionListener(handler);
        btnCancel.setBounds(230, 427, 90, 35);
        add(btnCancel);
        btnCancel.addActionListener(handler);
        btnNewAccount.setBounds(150, 473, 145, 35);
        add(btnNewAccount);
        btnNewAccount.addActionListener(handler);
        
       
	}

        //handler class to implement actionlistener switch case            
	private class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             switch(e.getActionCommand())
		{
		
		case "Cancel":
                       System.exit(0);
		break;
			
		case "Login":
                    LoginController lc = new LoginController(usernameTxtField.getText(), passwordField.getPassword());
			boolean authenticated = lc.authenticate();
			if(authenticated){
				LoggedInUser lu = new LoggedInUser();
				lu.setUser(usernameTxtField.getText());
				JOptionPane.showMessageDialog(null, "Successfully Authenticated!");
				NavigationWindow x = new NavigationWindow(lu);
                                x.setVisible(true);
				//MainFrame x = new MainFrame();
                                CredentialManagementApplication.t.dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Username and/or password incorrect.");
                                usernameTxtField.setText("");
                                passwordField.setText("");
			}

			
			//TODO: Add logic to check login information with excel sheet or list
			break;
		case "Create New Account":
                        CredentialManagementApplication.t.setEnabled(false);
                        JFrame registrationWindow = new JFrame();
                        
                        registrationWindow.setSize(340, 410);
                        registrationWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JPanel RegistrationWindow = new RegistrationWindow();
                        registrationWindow.add(RegistrationWindow);
                        registrationWindow.setLocation(553,278);
                        registrationWindow.setResizable(false);
                        registrationWindow.setTitle("Credential Manager - Team 6");
                        RegistrationWindow.setLayout(new BorderLayout());
                        registrationWindow.setVisible(true);
           
		break;		
                    default:
				System.err.println("Error");
                        break;
		}
        }

        
            
        }
       
}
