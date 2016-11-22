
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


public class UserAccountWindow extends JPanel implements ActionListener
{
        //background image pulled from file
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("UserAccount.png"));
        } catch (IOException e) {
                System.out.println("Error");
        }}
       
       //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  
    
	// Define JLabels, JButtons, JTextFields....
        JPasswordField currentPasswordField = new JPasswordField();
        JPasswordField newPasswordField = new JPasswordField();
        JPasswordField reenterNewPasswordField = new JPasswordField();
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("< Back");
        
        LoggedInUser loggedUser;
        
	public UserAccountWindow(LoggedInUser lu)
	{
		
            setLayout(null);
            
            currentPasswordField.setBounds(220,262,135,35);
            newPasswordField.setBounds(220,313,135,35);
            reenterNewPasswordField.setBounds(220,375,135,35);
            submitButton.setBounds(185,470,90,35);
            backButton.setBounds(130,530,90,35);
            clearButton.setBounds(250,530,90,35);
            
            add(currentPasswordField);
            add(newPasswordField);
            add(reenterNewPasswordField);
            add(submitButton);
            add(clearButton);
            add(backButton);
            submitButton.addActionListener(this);
            clearButton.addActionListener(this);
            backButton.addActionListener(this);
		
            this.loggedUser = lu;
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		switch(ae.getActionCommand())
		{
		
		case "Submit":
            UserAccountController submit = new UserAccountController(loggedUser.getUser(), currentPasswordField.getPassword(), 
                newPasswordField.getPassword(), reenterNewPasswordField.getPassword());
            String result = submit.update();
            if(result.equals("OK")){
                MainFrame.mainFrame.getContentPane().removeAll();      
                NavigationWindow y = new NavigationWindow(loggedUser);
                MainFrame.mainFrame.add(y);
                MainFrame.mainFrame.getContentPane().invalidate();
                MainFrame.mainFrame.getContentPane().validate();
            }else if(result.equals("Passwords don't match")){
                JOptionPane.showMessageDialog(null, "Passwords do not match.");
                currentPasswordField.setText("");
                newPasswordField.setText("");
                reenterNewPasswordField.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Current password is incorrect.");
                currentPasswordField.setText("");
                newPasswordField.setText("");
                reenterNewPasswordField.setText("");
            }
		break;
			
		case "Clear":
                    currentPasswordField.setText("");
                    newPasswordField.setText("");
                    reenterNewPasswordField.setText("");    
                break;

		case "< Back":

                    MainFrame.mainFrame.getContentPane().removeAll();
                  
                    NavigationWindow x = new NavigationWindow(loggedUser);
                    MainFrame.mainFrame.add(x);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();	
		break;	
                    

                	
		}
	}
}