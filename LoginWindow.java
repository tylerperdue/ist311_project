import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JPanel 
{
    private Handler handler = new Handler();  
    //background image pulled from URL
    static BufferedImage bgimg = null;{
        try {
            bgimg = ImageIO.read(LoginWindow.class.getResource("login.png"));
        }catch (IOException e){
            System.out.println("Error");
        }   
    }
       
    //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  
	
    //loginwindow elements
	JButton btnLogin = new JButton();
	JButton btnExit = new JButton();
	JButton btnNewAccount = new JButton();
        JTextField usernameTxtField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
	
	public LoginWindow() 
	{
		 
        setOpaque(false);
            
        //layout set to null so setbounds can work
        this.setLayout(null);
     
        usernameTxtField.setBounds(150, 321, 160, 35);
        usernameTxtField.setOpaque(false);
        usernameTxtField.setBackground(new Color(0,0,0,0));
        usernameTxtField.setForeground(Color.white);
        usernameTxtField.setCaretColor(Color.white);
        usernameTxtField.setBorder(BorderFactory.createEmptyBorder());
        
        passwordField.setBounds(150, 377, 160, 35);
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.white);
        passwordField.setBackground(new Color(0,0,0,0));
        passwordField.setCaretColor(Color.white);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        add(usernameTxtField);
        add(passwordField);
       
        btnLogin.setBounds(80,440,220,40);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setOpaque(false);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnNewAccount.setBounds(80,488,220,40);
        btnNewAccount.setBorderPainted(false);
        btnNewAccount.setContentAreaFilled(false);
        btnNewAccount.setOpaque(false);
        btnNewAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnExit.setBounds(143,540,90,40);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setOpaque(false);
        btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          
        add(btnLogin); 
        btnLogin.addActionListener(handler);
        add(btnExit);
        btnExit.addActionListener(handler);
        add(btnNewAccount);
        btnNewAccount.addActionListener(handler);
        
       
	}

    //handler class to implement actionlistener switch case            
	private class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == btnExit) {
                    System.exit(0);
           }
        			
           else if (e.getSource() == btnLogin) {
                    LoginController lc = new LoginController(usernameTxtField.getText(), passwordField.getPassword());
                    boolean authenticated = lc.authenticate();
                        if(authenticated){
                            LoggedInUser lu = new LoggedInUser();
                            lu.setUser(usernameTxtField.getText());
                            System.out.println("Sucessfully authenticated");
                            NavigationWindow x = new NavigationWindow(lu);
                            MainFrame mainFrame = new MainFrame(lu);
                            mainFrame.add(x);
                            x.setVisible(true);
                            CredentialManagementApplication.t.dispose();
                        }else {
                            JOptionPane.showMessageDialog(null, "Username and/or password incorrect.");
                            usernameTxtField.setText("");
                            passwordField.setText("");
                        }
           }

           else if (e.getSource() == btnNewAccount) {
                    CredentialManagementApplication.t.setEnabled(true);
                    JFrame registrationWindow = new JFrame();
                    
                    registrationWindow.setSize(375, 667);
                    registrationWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    JPanel RegistrationWindow = new RegistrationWindow();
                    registrationWindow.add(RegistrationWindow);
                    registrationWindow.setLocation(400, 200);
                    registrationWindow.setResizable(false);
                    registrationWindow.setTitle("Credential Manager - Team 6");
                    RegistrationWindow.setLayout(new BorderLayout());
                    registrationWindow.setVisible(true);   
                    
           }		
                            
           else {
        	System.err.println("Error");
            }
        }      
    }  
}
