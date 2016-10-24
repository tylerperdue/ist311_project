import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author akhil
 */

//This class defines and displays the buttons on the main window
//The functionality is in the mainInterfaceCntrl class

public class mainInterfacePanel extends JPanel implements ActionListener
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
        
        passwordGenerate.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		switch(e.getActionCommand())
		{
		case "Password generator":
			passwordGenPanel PasswordGenerator = new passwordGenPanel();
			PasswordGenerator.setVisible(true);
			break;
			default:
				System.err.println("Error");
			
		}
		
	}
            
}
