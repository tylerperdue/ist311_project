import javax.swing.JFrame;

/**
 *
 * @author akhil
 */
public class mainFrame extends JFrame
{
    private mainPanel mp;
    
    mainFrame()
    {
        super("Credential Manager - Group 6");
        mp = new mainPanel();
        add(mp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       // setLocationRelativeTo(null);
        setSize(1300, 700);
        setVisible(true);
    }
}
