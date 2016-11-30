import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


public class UserAccountWindow extends JPanel implements ActionListener
{
        //background image pulled from file
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("useraccount.png"));
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
        JButton submitButton = new JButton();
        JButton clearButton = new JButton();
        JButton backButton = new JButton();
        
        LoggedInUser loggedUser;
        
	public UserAccountWindow(LoggedInUser lu)
	{
		
            setLayout(null);
            
            currentPasswordField.setBounds(195,308,125,35);
            currentPasswordField.setOpaque(false);
            currentPasswordField.setBackground(new Color(0,0,0,0));
            currentPasswordField.setForeground(Color.white);
            currentPasswordField.setBorder(BorderFactory.createEmptyBorder());
            currentPasswordField.setCaretColor(Color.white);
            
            newPasswordField.setBounds(195,360,125,35);
            newPasswordField.setOpaque(false);
            newPasswordField.setBackground(new Color(0,0,0,0));
            newPasswordField.setForeground(Color.white);
            newPasswordField.setBorder(BorderFactory.createEmptyBorder());
            newPasswordField.setCaretColor(Color.white);
            
            reenterNewPasswordField.setBounds(195,438,125,35);
            reenterNewPasswordField.setOpaque(false);
            reenterNewPasswordField.setBackground(new Color(0,0,0,0));
            reenterNewPasswordField.setForeground(Color.white);
            reenterNewPasswordField.setBorder(BorderFactory.createEmptyBorder());
            reenterNewPasswordField.setCaretColor(Color.white);
            
            submitButton.setBounds(55,529,100,40);
            submitButton.setBorderPainted(false);
            submitButton.setContentAreaFilled(false);
            submitButton.setOpaque(false);
            submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            backButton.setBounds(0,28,70,38);
            backButton.setBorderPainted(false);
            backButton.setContentAreaFilled(false);
            backButton.setOpaque(false);
            backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            clearButton.setBounds(220,529,100,40);
            clearButton.setBorderPainted(false);
            clearButton.setContentAreaFilled(false);
            clearButton.setOpaque(false);
            clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
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
            if (ae.getSource() == submitButton) {
            UserAccountController submit = new UserAccountController(loggedUser.getUser(), currentPasswordField.getPassword(), 
                newPasswordField.getPassword(), reenterNewPasswordField.getPassword());
            String result = submit.update();
            if(result.equals("OK")){
                JOptionPane.showMessageDialog(null, "Password changed successfully.")
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
            }
            else if (ae.getSource() == clearButton) {
                    currentPasswordField.setText("");
                    newPasswordField.setText("");
                    reenterNewPasswordField.setText("");    
            }
            else if (ae.getSource() == backButton) {
                    MainFrame.mainFrame.getContentPane().removeAll();
                    NavigationWindow x = new NavigationWindow(loggedUser);
                    MainFrame.mainFrame.add(x);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();	     	
		}
	}
}