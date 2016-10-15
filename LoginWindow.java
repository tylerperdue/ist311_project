

package credentialmanagementapplication;

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
     JFrame frame = new JFrame();
        //background image pulled from URL
       static BufferedImage bgimg = null;{
        try {
                bgimg = ImageIO.read(new URL("http://i.imgur.com/S17IifC.png"));
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
	
	
	public LoginWindow() 
	{
		 
            setOpaque(false);
            
            //layout set to null so setbounds can work
            this.setLayout(null);
        
        usernameTxtField.setBounds(230, 310, 115, 30);
        passwordField.setBounds(230, 375, 115, 30);
        add(usernameTxtField);
        add(passwordField);
        btnLogin.setBounds(125, 450, 90, 35);
        add(btnLogin);      
        btnLogin.addActionListener(handler);
        btnCancel.setBounds(225, 450, 90, 35);
        add(btnCancel);
        btnCancel.addActionListener(handler);
        btnNewAccount.setBounds(150, 500, 145, 35);
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
			System.out.println("Login");
			//TODO: Add logic to check login information with excel sheet or list
			break;
		case "Create New Account":	
                        //currently shows in popup window, change so it stays in same frame
			RegistrationWindow r = new RegistrationWindow();
			r.setVisible(true);
		break;		
                    default:
				System.err.println("Error");
                        break;
		}
        }

        
            
        }
       
}
