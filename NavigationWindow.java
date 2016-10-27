package credentialmanagementapplication;

import static credentialmanagementapplication.MainFrame.mainFrame;
  
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;


 
public class NavigationWindow extends JPanel
{
    private Handler handler = new Handler();  
    
    private JButton passwordGenButton = new JButton();
    private JButton passwordVaultButton = new JButton();
    private JButton addCredentialButton = new JButton();
    private JButton userAccountButton = new JButton();
    
    private JTextField searchBar = new JTextField();
    private JButton searchButton = new JButton("Search");
    private JButton logoutButton = new JButton("Log Out");
    
    LoggedInUser loggedUser;
    
     //background image pulled from URL
       static BufferedImage bgimg = null;{
        try {
                bgimg = ImageIO.read(new URL("http://i.imgur.com/hon1nZd.png"));
        } catch (IOException e) {
                System.out.println("Error");
        }}
       
       //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  
    
   NavigationWindow(LoggedInUser lu)
    {
   
       setLayout(null);
       
       addCredentialButton.setBounds(50,215,155,145);
       addCredentialButton.setBorderPainted(false);
       addCredentialButton.setContentAreaFilled(false);
       addCredentialButton.setOpaque(false);
       addCredentialButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(addCredentialButton);
       
       passwordGenButton.setBounds(240,215,155,145);
       passwordGenButton.setBorderPainted(false);
       passwordGenButton.setContentAreaFilled(false);
       passwordGenButton.setOpaque(false);
       passwordGenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(passwordGenButton);
       
       passwordVaultButton.setBounds(50,380,155,145);
       passwordVaultButton.setBorderPainted(false);
       passwordVaultButton.setContentAreaFilled(false);
       passwordVaultButton.setOpaque(false);
       passwordVaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(passwordVaultButton);
       
       userAccountButton.setBounds(240,380,155,145);
       userAccountButton.setBorderPainted(false);
       userAccountButton.setContentAreaFilled(false);
       userAccountButton.setOpaque(false);
       userAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(userAccountButton);

       searchBar.setBounds(75,538,100,30);
       searchBar.setEditable(true);
       add(searchBar);
       searchButton.setBounds(175,538,100,30);
       add(searchButton);
       logoutButton.setBounds(320,538,100,30);
       add(logoutButton);
       
       addCredentialButton.addActionListener(handler);
       passwordGenButton.addActionListener(handler);
       passwordVaultButton.addActionListener(handler);
       userAccountButton.addActionListener(handler);
       searchButton.addActionListener(handler);
       logoutButton.addActionListener(handler);
       
       loggedUser = lu;
    }
    
    private class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addCredentialButton) {
                mainFrame.getContentPane().removeAll();
                AddCredentialsWindow y = new AddCredentialsWindow(loggedUser);
                mainFrame.add(y);
                mainFrame.getContentPane().invalidate();
                mainFrame.getContentPane().validate();    
            }
                else if (e.getSource() == passwordGenButton) {
                    mainFrame.getContentPane().removeAll();
                    PasswordGenWindow x = new PasswordGenWindow(loggedUser);
                    mainFrame.add(x);
                    mainFrame.getContentPane().invalidate();
                    mainFrame.getContentPane().validate();        
                }
                
                else if (e.getSource() == passwordVaultButton) {
                    mainFrame.getContentPane().removeAll();
                    PasswordVaultWindow pv = new PasswordVaultWindow();
                    mainFrame.add(pv);
                    mainFrame.getContentPane().invalidate();
                    mainFrame.getContentPane().validate();
                }
                else if (e.getSource() == userAccountButton) {
                    mainFrame.getContentPane().removeAll();
                    UserAccountWindow ua = new UserAccountWindow();
                    mainFrame.add(ua);
                    mainFrame.getContentPane().invalidate();
                    mainFrame.getContentPane().validate();
                }
                else if (e.getSource() == searchButton) {
                    mainFrame.getContentPane().removeAll();
                    SearchResultsWindow s = new SearchResultsWindow();
                    mainFrame.add(s);
                    mainFrame.getContentPane().invalidate();
                    mainFrame.getContentPane().validate();
                }
                else if (e.getSource() == logoutButton) {
                    mainFrame.getContentPane().removeAll();
                    LoginWindow lo = new LoginWindow();
                    mainFrame.add(lo);
                    mainFrame.getContentPane().invalidate();
                    mainFrame.getContentPane().validate();
                }
            }
            
    } 

}

    
