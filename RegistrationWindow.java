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
                bgimg = ImageIO.read(LoginWindow.class.getResource("createnewaccount.png"));
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
	
	JButton btnCancel = new JButton();
	JButton btnOK = new JButton();
	
	
	RegistrationWindow()
	{
		
		this.setLayout(null);
		this.setSize(375, 667);
	
                txtUsername.setBounds(185,327,148,35);
                txtUsername.setOpaque(false);
                txtUsername.setBackground(new Color(0,0,0,0));
                txtUsername.setForeground(Color.white);
                txtUsername.setCaretColor(Color.white);
                txtUsername.setBorder(BorderFactory.createEmptyBorder());
                add(txtUsername);
                txtPassword.setBounds(185,383,148,35);
                txtPassword.setOpaque(false);
                txtPassword.setBackground(new Color(0,0,0,0));
                txtPassword.setForeground(Color.white);
                txtPassword.setCaretColor(Color.white);
                txtPassword.setBorder(BorderFactory.createEmptyBorder());
                add(txtPassword);
                txtPasswordAgain.setBounds(186,457,148,35);
                txtPasswordAgain.setOpaque(false);
                txtPasswordAgain.setBackground(new Color(0,0,0,0));
                txtPasswordAgain.setForeground(Color.white);
                txtPasswordAgain.setCaretColor(Color.white);
                txtPasswordAgain.setBorder(BorderFactory.createEmptyBorder());
                add(txtPasswordAgain);	
                btnOK.setBounds(82,545,210,40);
                btnOK.setBorderPainted(false);
                btnOK.setContentAreaFilled(false);
                btnOK.setOpaque(false);
                btnOK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                add(btnOK);
                btnCancel.setBounds(0,30,70,38);
                btnCancel.setBorderPainted(false);
                btnCancel.setContentAreaFilled(false);
                btnCancel.setOpaque(false);
                btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                add(btnCancel);
                
		
                
                btnCancel.addActionListener(handler);
                btnOK.addActionListener(handler);


		
	}
	//handler class to implement actionlistener switch case            
	private class Handler implements ActionListener {

        @Override
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == btnCancel) {
                    ((Window) getRootPane().getParent()).dispose();
                    CredentialManagementApplication.t.setEnabled(true); 
                }
                else if (ae.getSource() == btnOK) {
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
