import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author akhil
 */
public class mainPanel extends JPanel
{
    private infoDisplayPanel infoDisUI;
    private mainInterfacePanel mainInfiUI;
    
    mainPanel()
    {
        super();
        infoDisUI = new infoDisplayPanel();
        mainInfiUI = new mainInterfacePanel();
        
        setLayout(new GridLayout(1,3));
        add(infoDisUI);
        add(mainInfiUI);
    }
    
}
