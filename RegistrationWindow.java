import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RegistrationWindow extends JPanel 
{
    private Handler handler = new Handler();
  
    static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("Jr2kf94.png"));
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
                         CredentialManagementApplication.t.setEnabled(true); 
		break;
		
		case "OK":
            RegistrationController rc = new RegistrationController(txtUsername.getText(), txtPassword.getPassword(), 
																   txtPasswordAgain.getPassword());
			String result = rc.register();
			if (result.equals("registered")){
				CredentialManagementApplication.t.setEnabled(true); 	// open the Login window 
				((Window) getRootPane().getParent()).dispose();
				//this.setVisible(false);	// set the current frame to invisible 
				System.out.println("OK");
			}else if(result.equals("pwds don't match")){
				JOptionPane.showMessageDialog(null, "Passwords do not match.");
				txtUsername.setText("");
				txtPassword.setText("");
				txtPasswordAgain.setText("");
			}else{
				JOptionPane.showMessageDialog(null, "Username already exists.");
				txtUsername.setText("");
				txtPassword.setText("");
				txtPasswordAgain.setText("");
			}
			System.out.println(result);
		}
	}
}
}
