import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(new File("hon1nZd.png"));
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
                MainFrame.mainFrame.getContentPane().removeAll();
                AddCredentialsWindow y = new AddCredentialsWindow(loggedUser);
                MainFrame.mainFrame.add(y);
                MainFrame.mainFrame.getContentPane().invalidate();
                MainFrame.mainFrame.getContentPane().validate();    
            }
                else if (e.getSource() == passwordGenButton) {
                    MainFrame.mainFrame.getContentPane().removeAll();
                    PasswordGenWindow x = new PasswordGenWindow(loggedUser);
                    MainFrame.mainFrame.add(x);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();        
                }
                
                else if (e.getSource() == passwordVaultButton) {
                    MainFrame.mainFrame.getContentPane().removeAll();
                    PasswordVaultWindow pv = new PasswordVaultWindow(loggedUser);
                    MainFrame.mainFrame.add(pv);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();
                }
                else if (e.getSource() == userAccountButton) {
                    MainFrame.mainFrame.getContentPane().removeAll();
                    UserAccountWindow ua = new UserAccountWindow();
                    MainFrame.mainFrame.add(ua);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();
                }
                else if (e.getSource() == searchButton) {
                    MainFrame.mainFrame.getContentPane().removeAll();
                    SearchResultsWindow s = new SearchResultsWindow();
                    MainFrame.mainFrame.add(s);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();
                }
                else if (e.getSource() == logoutButton) {
//                    MainFrame.mainFrame.getContentPane().removeAll();
//                    LoginWindow lo = new LoginWindow();
//                    MainFrame.mainFrame.add(lo);
//                    MainFrame.mainFrame.getContentPane().invalidate();
//                    MainFrame.mainFrame.getContentPane().validate();
                	
                	System.exit(0);
           
                	
                }
            }
            
    } 

}

    
