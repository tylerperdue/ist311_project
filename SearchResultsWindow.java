import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


//This class defines and displays search results after "Search" button is clicked

public class SearchResultsWindow extends JPanel implements ActionListener
{
   //background image pulled from URL
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("searchresults.png"));
        } catch (IOException e) {
                System.out.println("Error");
        }}
       
       //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  
    
    // Define JLabels, JButtons, JTextFields....
    JTextField searchBar = new JTextField();
    JTextArea resultsTextArea = new JTextArea();
    JButton searchButton = new JButton();
    JButton clearButton = new JButton();
    JButton backButton = new JButton();
    
    
    
    public static String[] strCategories = {"Work", "Finances", "Personal", "Email"};
    
    JComboBox cmbCategories; 
    
    LoggedInUser loggedUser;
    
    
    SearchResultsWindow(LoggedInUser lu)
    {
        setLayout(null);
        
        ItemHandler handler = new ItemHandler();
        
        loggedUser = lu;
        PasswordVaultWindow p = new PasswordVaultWindow(loggedUser);
        
        this.cmbCategories = new JComboBox(strCategories);
        this.cmbCategories.addItemListener(handler);
        
        cmbCategories.setBounds(100,156,145,30);
        
        resultsTextArea.setBounds(60,340,270,180);
        
        searchButton.setBounds(236,157,80,30);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setOpaque(false);
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        clearButton.setBounds(140,548,100,45);
        clearButton.setBorderPainted(false);
        clearButton.setContentAreaFilled(false);
        clearButton.setOpaque(false);
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        backButton.setBounds(0,28,70,38);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setOpaque(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        add(cmbCategories);
        
        add(searchBar);
        add(resultsTextArea);
        add(searchButton);
        add(clearButton);
        add(backButton);

        
        searchButton.addActionListener(this);
        clearButton.addActionListener(this);
        backButton.addActionListener(this);
    }
    

    
    private class ItemHandler implements ItemListener
    {
    	
    	
    	public void itemStateChanged(ItemEvent event)
    	{
    		if(event.getSource() == cmbCategories)
    		{
    			if((cmbCategories.getSelectedItem().toString() != null))
				{
    				SearchWindowController swc = new SearchWindowController(loggedUser.getUser(), cmbCategories.getSelectedItem().toString());

    				resultsTextArea.setText(null);
    				String[] strWebsites;
    				String[] strUsernames;
    				int index = 0;
    				int strLength; 
					for(int i = 0; i < swc.getCredentialsLength(cmbCategories.getSelectedItem().toString()); i++)
					{	
						
						strWebsites = swc.getWebsite(cmbCategories.getSelectedItem().toString());
						strUsernames = swc.getUsername(cmbCategories.getSelectedItem().toString().toString());
						String strCapture = "";
						strLength = swc.getCredentialsLength(cmbCategories.getSelectedItem().toString());
						
						for(int j = 0; j < strLength; j++)
						{
							
							strCapture += " " + strWebsites[j] + ": " + strUsernames[j] + "\n";
							resultsTextArea.setText(strCapture);
						}
					}

				}
    			else
    			{
    				System.out.println("Error!");
    			}
    		}

    	}
    }
    
    
public void actionPerformed(ActionEvent ae)
	{

                if (ae.getSource() == clearButton) {
                    searchBar.setText("");
                    resultsTextArea.setText("");       
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
     
