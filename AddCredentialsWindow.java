import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
            bgimg = ImageIO.read(LoginWindow.class.getResource("addcredential.png"));
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
    JButton addButton = new JButton();
    JButton clearButton = new JButton();
    JButton backButton = new JButton();
    
    ButtonGroup categoriesGroup = new ButtonGroup();
    
    JRadioButton rbPersonal = new JRadioButton("Personal", true);
    JRadioButton rbEmail = new JRadioButton("Email", false);
    JRadioButton rbWork = new JRadioButton("Work", false);
    JRadioButton rbFinances = new JRadioButton("Finances", false);
   
	LoggedInUser loggedUser;


	public AddCredentialsWindow(LoggedInUser lu)
	{
		
        setLayout(null);
        
        newUsernameTextfield.setBounds(175,310,130,35);
        newUsernameTextfield.setCaretColor(Color.white);
        newUsernameTextfield.setOpaque(false);
        newUsernameTextfield.setBackground(new Color(0,0,0,0));
        newUsernameTextfield.setForeground(Color.white);
        newUsernameTextfield.setBorder(BorderFactory.createEmptyBorder());
    	
        newPasswordTextfield.setBounds(175,365,130,35);
        newPasswordTextfield.setCaretColor(Color.white);
        newPasswordTextfield.setOpaque(false);
        newPasswordTextfield.setBackground(new Color(0,0,0,0));
        newPasswordTextfield.setForeground(Color.white);
        newPasswordTextfield.setBorder(BorderFactory.createEmptyBorder());
        
    	addButton.setBounds(55,565,100,40);
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setOpaque(false);
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	
        backButton.setBounds(0,30,70,38);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setOpaque(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
               
        clearButton.setBounds(220,565,100,40);
        clearButton.setBorderPainted(false);
        clearButton.setContentAreaFilled(false);
        clearButton.setOpaque(false);
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        txtSysName.setBounds(175,447,120,30);
        txtSysName.setCaretColor(Color.white);
        txtSysName.setOpaque(false);
        txtSysName.setBackground(new Color(0,0,0,0));
        txtSysName.setForeground(Color.white);
        txtSysName.setBorder(BorderFactory.createEmptyBorder());
        
        rbPersonal.setBounds(70, 450, 100, 35);
        rbPersonal.setForeground(Color.WHITE);
        
        rbEmail.setBounds(70, 470, 100, 35);
        rbEmail.setForeground(Color.WHITE);
        
        rbWork.setBounds(70, 490, 100, 35);
        rbWork.setForeground(Color.WHITE);

        rbFinances.setBounds(70, 510, 100, 35);
        rbFinances.setForeground(Color.WHITE);
        
        
        categoriesGroup.add(rbPersonal);
        categoriesGroup.add(rbEmail);
        categoriesGroup.add(rbWork);
        categoriesGroup.add(rbFinances);
        
        add(newUsernameTextfield);
        add(newPasswordTextfield);
        add(rbPersonal);
        add(rbEmail);
        add(rbWork);
        add(rbFinances);
        add(addButton);
        add(clearButton);
        add(backButton);
        add(txtSysName);
        

        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        backButton.addActionListener(this);
        
        
        

        this.loggedUser = lu;

	}
	
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
		if (ae.getSource() == addButton) {
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
                }
                else if (ae.getSource() == clearButton) {
                    newUsernameTextfield.setText("");
                    newPasswordTextfield.setText("");
                    txtSysName.setText("");
                    rbPersonal.setSelected(true);
                }
                else if (ae.getSource() == backButton) {
                    MainFrame.mainFrame.getContentPane().removeAll();   
                    NavigationWindow z = new NavigationWindow(loggedUser);
                    MainFrame.mainFrame.add(z);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();
                        
                }
	   }  
    }