import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


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
    
    LoggedInUser loggedUser;
;    
    SearchResultsWindow(LoggedInUser lu)
    {
        setLayout(null);
        
        searchBar.setBounds(100,156,145,30);
        searchBar.setOpaque(false);
        searchBar.setBackground(new Color(0,0,0,0));
        searchBar.setForeground(Color.white);
        searchBar.setBorder(BorderFactory.createEmptyBorder());
        searchBar.setCaretColor(Color.white);
        
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
        
        add(searchBar);
        add(resultsTextArea);
        add(searchButton);
        add(clearButton);
        add(backButton);
        
        loggedUser = lu;
        
        searchButton.addActionListener(this);
        clearButton.addActionListener(this);
        backButton.addActionListener(this);
    }
    
public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == searchButton) {
                   SearchWindowController swc = new SearchWindowController(searchBar.getText());
                }
                else if (ae.getSource() == clearButton) {
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
     
