import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame
{
    static JFrame mainFrame = new JFrame();
    private NavigationWindow mp;
    LoggedInUser loggedUser;
    
    MainFrame()
    {
        
        mp = new NavigationWindow(loggedUser);
        mainFrame.add(mp);
        mainFrame.setResizable(false);
        mainFrame.setSize(450, 650);
        mainFrame.setLocation(500, 150);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setTitle("Credential Manager - Team 6");
    }
}

        
        
        
   

