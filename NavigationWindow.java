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
    
    private JButton searchButton = new JButton();
    private JButton logoutButton = new JButton();
    
    LoggedInUser loggedUser;
    
     //background image pulled from URL
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("navigation.png"));
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
       
       addCredentialButton.setBounds(45,265,115,115);
       addCredentialButton.setBorderPainted(false);
       addCredentialButton.setContentAreaFilled(false);
       addCredentialButton.setOpaque(false);
       addCredentialButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(addCredentialButton);
       
       passwordGenButton.setBounds(222,300,115,115);
       passwordGenButton.setBorderPainted(false);
       passwordGenButton.setContentAreaFilled(false);
       passwordGenButton.setOpaque(false);
       passwordGenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(passwordGenButton);
       
       passwordVaultButton.setBounds(45,433,115,115);
       passwordVaultButton.setBorderPainted(false);
       passwordVaultButton.setContentAreaFilled(false);
       passwordVaultButton.setOpaque(false);
       passwordVaultButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(passwordVaultButton);
       
       userAccountButton.setBounds(222,468,115,115);
       userAccountButton.setBorderPainted(false);
       userAccountButton.setContentAreaFilled(false);
       userAccountButton.setOpaque(false);
       userAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(userAccountButton);

       searchButton.setBounds(64,592,70,30);
       searchButton.setBorderPainted(false);
       searchButton.setContentAreaFilled(false);
       searchButton.setOpaque(false);
       searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       add(searchButton);
       logoutButton.setBounds(270,30,110,40);
       logoutButton.setBorderPainted(false);
       logoutButton.setContentAreaFilled(false);
       logoutButton.setOpaque(false);
       logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                	
                    Authentication auth = new Authentication(loggedUser);
                    auth.setVisible(true);
                }
                else if (e.getSource() == userAccountButton) {
                    MainFrame.mainFrame.getContentPane().removeAll();
                    UserAccountWindow ua = new UserAccountWindow(loggedUser);
                    MainFrame.mainFrame.add(ua);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();
                }
                else if (e.getSource() == searchButton) {
                    MainFrame.mainFrame.getContentPane().removeAll();
                    SearchResultsWindow s = new SearchResultsWindow(loggedUser);
                    MainFrame.mainFrame.add(s);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();
                }
                else if (e.getSource() == logoutButton) {
                    
                    //asking if the user wants to logout
                        Object[] options = {"Yes", "No"};
                        int a = JOptionPane.showOptionDialog(null, "Are you sure you want to log out?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                	if(a == JOptionPane.YES_OPTION){
                          try {
                              AESCrypt aes = new AESCrypt(true, "password");
                              File credentials = new File("CREDENTIALS.txt");
                              File credentials_encrypted = new File("CREDENTIALS_encrypted.txt");
                              aes.encrypt(2, "CREDENTIALS.txt", "CREDENTIALS_encrypted.txt");
                              boolean x = credentials.delete();
                              File userlist = new File("USERLIST.txt");
                              File userlist_encrypted = new File("USERLIST_encrypted.txt");
                              aes.encrypt(2, "USERLIST.txt", "USERLIST_encrypted.txt");
                              boolean y = userlist.delete();
                              System.exit(0);

                            } catch (Exception e2) {
                              e2.printStackTrace();
                            }
                  }else{}
                }
            }
            
    } 

}

    
