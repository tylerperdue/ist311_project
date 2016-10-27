package credentialmanagementapplication;

import static credentialmanagementapplication.CredentialManagementApplication.t;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class RegistrationWindow extends JPanel 
{
    private Handler handler = new Handler();
  
    static BufferedImage bgimg = null;{
        try {
                bgimg = ImageIO.read(new URL("http://i.imgur.com/Jr2kf94.png"));
        } catch (IOException e) {
                System.out.println("Error");
        }}
       
    //paint method that will paint background
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  
	JTextField txtUsername = new JTextField();
	
	JPasswordField txtPassword = new JPasswordField();
	
	JPasswordField txtPasswordAgain = new JPasswordField();
	
	JButton btnCancel = new JButton("Cancel");
	JButton btnOK = new JButton("OK");
	
	
	RegistrationWindow()
	{
		
		this.setLayout(null);
		this.setSize(340, 410);
	
                txtUsername.setBounds(183,170,115,35);
                add(txtUsername);
                txtPassword.setBounds(183,210,115,35);
                add(txtPassword);
                txtPasswordAgain.setBounds(183,260,115,35);
                add(txtPasswordAgain);	
                btnOK.setBounds(85,310,80,35);
                add(btnOK);
                btnCancel.setBounds(183,310,90,35);
                add(btnCancel);
                
		
                btnCancel.addActionListener(handler);
                btnOK.addActionListener(handler);


		
	}
	//handler class to implement actionlistener switch case            
	private class Handler implements ActionListener {

        @Override
	
	public void actionPerformed(ActionEvent ae)
	{
		switch(ae.getActionCommand())
		{
		case "Cancel":
			 ((Window) getRootPane().getParent()).dispose();
                         t.setEnabled(true); 
		break;
		
		case "OK":
               
                    //TODO: Add logic to check if passwords match
                    //TODO: Add logic to grab field data and store in excel sheet or list
                    t.setEnabled(true); 	// open the Login window 
			((Window) getRootPane().getParent()).dispose();
			//this.setVisible(false);	// set the current frame to invisible 
			System.out.println("OK");
		}
	}
}
}
