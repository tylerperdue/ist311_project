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
                bgimg = ImageIO.read(LoginWindow.class.getResource("SearchResults.png"));
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
    JButton searchButton = new JButton("Search");
    JButton clearButton = new JButton("Clear");
    JButton backButton = new JButton("< Back");
    
    LoggedInUser loggedUser;
;    
    SearchResultsWindow(LoggedInUser lu)
    {
        setLayout(null);
        
        searchBar.setBounds(120,198,150,30);
        resultsTextArea.setBounds(80,310,290,160);
        searchButton.setBounds(290,198,90,35);
        clearButton.setBounds(180,510,90,35);
        backButton.setBounds(180,555,90,35);
        
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
		switch(ae.getActionCommand())
		{
		
		case "Search":
                   SearchWindowController swc = new SearchWindowController(searchBar.getText());
		break;
			
		case "Clear":
                    searchBar.setText("");
                    resultsTextArea.setText("");       
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
     
