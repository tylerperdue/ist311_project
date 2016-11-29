import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class PasswordVaultWindow extends JPanel implements ActionListener
{

     //background image pulled from URL
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("passwordvault.png"));
        } catch (IOException e) {
                System.out.println("Error");
        }}
       
       //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  

	// Define JLabels, JButtons, JTextFields....
	JButton btnBack = new JButton();

        JTextField retrievedUsername = new JTextField();
        JTextField retrievedPassword = new JTextField();
        
	String tempCategory;
	
	public static String[] strCategories = {"Work", "Finances", "Personal", "Email"};
	public static String[] strWebsites = {"Website 1", "Website 2"};
	
	JComboBox cmbCategories; 
	JComboBox cmbWebsites = new JComboBox();
	LoggedInUser loggedUser;
	
	PasswordVaultController pv;
	
	
	public PasswordVaultWindow(LoggedInUser lu)
	{
		
		loggedUser = lu;
		
                setLayout(null);
                
                pv = new PasswordVaultController(loggedUser.getUser(), null, null);
                ItemHandler handler =  new ItemHandler();
                

                String[] tempCategory = new String[pv.getCredentialsLength()];

                this.cmbCategories = new JComboBox(strCategories);
                this.cmbCategories.addItemListener(handler);
                
                this.cmbWebsites.addItemListener(handler); // stopped here 

                System.out.println("Selected item: " + this.cmbCategories.getSelectedItem());
                
                
                btnBack.setBounds(0,28,70,38);
                btnBack.setBorderPainted(false);
                btnBack.setContentAreaFilled(false);
                btnBack.setOpaque(false);
                btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                add(btnBack);
		   
                cmbCategories.setBounds(130,310,135,35);
                add(cmbCategories);
                
                cmbWebsites.setBounds(190,378,150,35);
                add(cmbWebsites);
                
                retrievedUsername.setBounds(170,453,150,35);
                retrievedUsername.setOpaque(false);
                retrievedUsername.setBackground(new Color(0,0,0,0));
                retrievedUsername.setForeground(Color.white);
                retrievedUsername.setBorder(BorderFactory.createEmptyBorder());
                retrievedUsername.setEditable(false);
                add(retrievedUsername);
                
                retrievedPassword.setBounds(170,540,150,35);
                retrievedPassword.setOpaque(false);
                retrievedPassword.setBackground(new Color(0,0,0,0));
                retrievedPassword.setForeground(Color.white);
                retrievedPassword.setBorder(BorderFactory.createEmptyBorder());
                retrievedPassword.setEditable(false);
                add(retrievedPassword);
		
		System.out.println(this.cmbCategories.getSelectedItem());
		
		
		//this.btnAuthentication.addActionListener(this);
		this.btnBack.addActionListener(this);
		
	}
	
	
	
	private class ItemHandler implements ItemListener
	{
		
//		@Override
		
		
	
		public void itemStateChanged(ItemEvent event)
		{
			
			String[] strWebsites;
			String strCategoryCapture = "";
			if(event.getSource() == cmbCategories)
			{
				cmbWebsites.removeAllItems();
				if((cmbCategories.getSelectedItem().toString() != null))
				{
					retrievedUsername.setText(null);
					retrievedPassword.setText(null);
					
					cmbWebsites.setToolTipText("Please select a Website/App name");
					cmbWebsites.repaint();
					strWebsites = pv.getCategories(cmbCategories.getSelectedItem().toString());
			
					cmbWebsites.addItem("Select ...");
					for(String str : strWebsites)
						cmbWebsites.addItem(str);
					

				}
				strCategoryCapture = cmbCategories.getSelectedItem().toString();
	
			}
			else if(event.getSource() == cmbWebsites)
			{
				if(cmbWebsites.isValid())
				{
					
					retrievedUsername.setText(null);
					retrievedPassword.setText(null);
					
					System.out.println(pv.getUsername(cmbCategories.getSelectedItem().toString(), cmbWebsites.getSelectedItem().toString()));
					retrievedUsername.setText(pv.getUsername(cmbCategories.getSelectedItem().toString(), cmbWebsites.getSelectedItem().toString()));
					retrievedPassword.setText(pv.getPassword(cmbCategories.getSelectedItem().toString(), cmbWebsites.getSelectedItem().toString()));
				}
			}
			
			
			
		

		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
            if (ae.getSource() == btnBack) {
                MainFrame.mainFrame.getContentPane().removeAll();
                NavigationWindow x = new NavigationWindow(loggedUser);
                MainFrame.mainFrame.add(x);
                MainFrame.mainFrame.getContentPane().invalidate();
                MainFrame.mainFrame.getContentPane().validate();
	
            }
}
}