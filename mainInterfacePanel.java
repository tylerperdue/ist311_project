import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author akhil
 */

//This class defines and displays the buttons on the main window
//The functionality is in the mainInterfaceCntrl class

public class mainInterfacePanel extends JPanel
{
    private JButton newCredential, passwordGenerate, editCredential;
    
    mainInterfacePanel()
    {
        super();
        
        newCredential = new JButton("New credential");
        passwordGenerate = new JButton("Password generator");
        editCredential = new JButton("Edit credential");

        add(newCredential);
        add(passwordGenerate);
        add(editCredential);
    }
            
}
