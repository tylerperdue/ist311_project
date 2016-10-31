import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame
{
    static JFrame mainFrame = new JFrame();
    private NavigationWindow mp;
    LoggedInUser loggedUser;
    
    MainFrame(LoggedInUser lu)
    {
        this.loggedUser = lu;
        mp = new NavigationWindow(loggedUser);
        mainFrame.add(mp);
        mainFrame.setResizable(false);
        mainFrame.setLocation(400, 200);
        mainFrame.setSize(450, 650);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setTitle("Credential Manager - Team 6");
    }
}

        
        
        
   

