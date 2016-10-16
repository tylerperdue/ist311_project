import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author akhil
 */

//This class defines and displays the information/credential display section of the main window
//The functionality is in the infoDisplayCntrl class

public class infoDisplayPanel extends JPanel
{
    private JTextField searchBar;
    
    infoDisplayPanel()
    {
        super();
        searchBar = new JTextField(" Search ");
        setBackground(Color.WHITE);
        add(searchBar);
    }  
}
