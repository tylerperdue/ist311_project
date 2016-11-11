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
            bgimg = ImageIO.read(LoginWindow.class.getResource("8Nrep2s.png"));
        }catch (IOException e){
                System.out.println("Error");
        }
    }
       
    //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  
    
    String strCapture = "";

	JTextField newUsernameTextfield = new JTextField();
	JTextField txtSysName = new JTextField(10);
    JPasswordField newPasswordTextfield = new JPasswordField();
    JButton addButton = new JButton("Add!");
    JButton clearButton = new JButton("Clear");
    JButton backButton = new JButton("< Back");
    
    ButtonGroup categoriesGroup = new ButtonGroup();
    
    JRadioButton rbPersonal = new JRadioButton("Personal", true);
    JRadioButton rbEmail = new JRadioButton("Email", false);
    JRadioButton rbWork = new JRadioButton("Work", false);
    JRadioButton rbFinances = new JRadioButton("Finances", false);
    
    JLabel lblCategories = new JLabel("Categories:");
    JLabel lblSysName = new JLabel("Website/App name:");
        
	LoggedInUser loggedUser;


	public AddCredentialsWindow(LoggedInUser lu)
	{
		
        setLayout(null);
        
        newUsernameTextfield.setBounds(233,257,130,35);
    	newPasswordTextfield.setBounds(233,307,130,35);
    	addButton.setBounds(190,540,90,35);
    	backButton.setBounds(85,560,90,35);
        clearButton.setBounds(300,560,90,35);
        
        txtSysName.setBounds(233,375,130,35);
        lblCategories.setBounds(63, 347, 100, 35);
        lblCategories.setFont(new Font("HELVETICA", Font.BOLD, 16));
        lblCategories.setForeground(new Color(67, 211, 175));
        
        
        lblSysName.setBounds(220, 347, 190, 35);
        lblSysName.setFont(new Font("HELVETICA", Font.BOLD, 16));
        lblSysName.setForeground(new Color(67, 211, 175));
        
        
        rbPersonal.setBounds(100, 370, 100, 35);
        rbPersonal.setForeground(Color.WHITE);
        
        rbEmail.setBounds(100, 400, 100, 35);
        rbEmail.setForeground(Color.WHITE);
        
        rbWork.setBounds(100, 430, 100, 35);
        rbWork.setForeground(Color.WHITE);

        rbFinances.setBounds(100, 460, 100, 35);
        rbFinances.setForeground(Color.WHITE);
        
        
        categoriesGroup.add(rbPersonal);
        categoriesGroup.add(rbEmail);
        categoriesGroup.add(rbWork);
        categoriesGroup.add(rbFinances);
        
        
        add(newUsernameTextfield);
        add(newPasswordTextfield);
        add(lblSysName);
        add(rbPersonal);
        add(rbEmail);
        add(rbWork);
        add(rbFinances);
        add(addButton);
        add(clearButton);
        add(backButton);
        add(lblCategories);
        add(txtSysName);
        

        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        backButton.addActionListener(this);
        
        
        

        this.loggedUser = lu;

	}
	
	
//	
//	public ButtonEvent()
//	{
//		
//		
//		
//	}
//	
	
	public String getRadioButtonValue()
	{
		if(rbPersonal.isSelected())
		{
			return "Personal";
		}
		if(rbEmail.isSelected())
		{
			return "Email";
		}
		if(rbWork.isSelected())
		{
			return "Work";
		}
		if(rbFinances.isSelected())
		{
			return "Finances";
		}
		
		return "";
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		switch(ae.getActionCommand())
		{
    		case "Add!":
    			
    			if(!(getRadioButtonValue().equals("")) && !(newUsernameTextfield.getText().equals("")) && !(newPasswordTextfield.getText().equals("")) && !(txtSysName.getText().equals("")))
    			{
    				
    			
                AddCredentialsController x = new AddCredentialsController(getRadioButtonValue(),loggedUser, txtSysName.getText(), newUsernameTextfield.getText(), 
                newPasswordTextfield.getPassword());
    			boolean added = x.addCredential();
                System.out.println(added);
    			if(added){
    				JOptionPane.showMessageDialog(null, "New credentials are successfully stored!");
    				NavigationWindow y = new NavigationWindow(loggedUser);	
    				MainFrame.mainFrame.getContentPane().removeAll();
                    MainFrame.mainFrame.add(y);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();
    			}else{
    				JOptionPane.showMessageDialog(null, "Unable to add credential");
    			}
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(null, "Fill out all of the components in the form!");
    			}
    		break;
    			
    		case "Clear":

            break;

    		case "< Back":
                MainFrame.mainFrame.getContentPane().removeAll();
                   
                NavigationWindow z = new NavigationWindow(loggedUser);
                MainFrame.mainFrame.add(z);
                MainFrame.mainFrame.getContentPane().invalidate();
                MainFrame.mainFrame.getContentPane().validate();
                        
    		break;	
	   }  
    }
}