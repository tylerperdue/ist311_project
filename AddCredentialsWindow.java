import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;



public class AddCredentialsWindow extends JPanel implements ActionListener
{
   //background image pulled from URL
   static Image bgimg = null;{
        try {
            bgimg = ImageIO.read(new File("8Nrep2s.png"));
        }catch (IOException e){
                System.out.println("Error");
        }
    }
       
    //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  

	JTextField newUsernameTextfield = new JTextField();
    JPasswordField newPasswordTextfield = new JPasswordField();
    JButton addButton = new JButton("Add!");
    JButton clearButton = new JButton("Clear");
    JButton backButton = new JButton("Back");
    
    ButtonGroup categoriesGroup = new ButtonGroup();
    
    JRadioButton rbPersonal = new JRadioButton("Personal", true);
    JRadioButton rbEmail = new JRadioButton("Email", false);
    JRadioButton rbWork = new JRadioButton("Work", false);
    JRadioButton rbFinances = new JRadioButton("Finances", false);
    
   
        
	LoggedInUser loggedUser;


	public AddCredentialsWindow(LoggedInUser lu)
	{
		
        setLayout(null);
        
        newUsernameTextfield.setBounds(233,257,130,35);
    	newPasswordTextfield.setBounds(233,307,130,35);
    	addButton.setBounds(190,540,90,35);
    	backButton.setBounds(85,560,90,35);
        clearButton.setBounds(300,560,90,35);
        
        rbPersonal.setBounds(100, 360, 100, 35);
        rbPersonal.setForeground(Color.WHITE);
        
        rbEmail.setBounds(200, 360, 100, 35);
        rbEmail.setForeground(Color.WHITE);
        
        
        categoriesGroup.add(rbPersonal);
        categoriesGroup.add(rbEmail);
        
        add(newUsernameTextfield);
        add(newPasswordTextfield);
        add(rbPersonal);
        add(rbEmail);
        add(addButton);
        add(clearButton);
        add(backButton);
        

        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        backButton.addActionListener(this);
        
        
        

        this.loggedUser = lu;

	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		switch(ae.getActionCommand())
		{
    		case "Add!":
                AddCredentialsController x = new AddCredentialsController(loggedUser, newUsernameTextfield.getText(), 
                newPasswordTextfield.getPassword());
    			boolean added = x.addCredential();
                System.out.println(added);
    			if(added){
    				NavigationWindow y = new NavigationWindow(loggedUser);	
    				MainFrame.mainFrame.getContentPane().removeAll();
                    MainFrame.mainFrame.add(y);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();
    			}else{
    				JOptionPane.showMessageDialog(null, "Unable to add credential");
    			}
    		break;
    			
    		case "Clear":

            break;

    		case "Back":
                MainFrame.mainFrame.getContentPane().removeAll();
                   
                NavigationWindow z = new NavigationWindow(loggedUser);
                MainFrame.mainFrame.add(z);
                MainFrame.mainFrame.getContentPane().invalidate();
                MainFrame.mainFrame.getContentPane().validate();
                        
    		break;	
	   }  
    }
}