import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;




public class PasswordVaultWindow extends JPanel implements ActionListener
{

     //background image pulled from URL
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("PasswordVault.png"));
        } catch (IOException e) {
                System.out.println("Error");
        }}
       
       //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  

	// Define JLabels, JButtons, JTextFields....

	JButton btnAuthentication = new JButton("Authenticate");
	
	JButton btnBack = new JButton("< Back");
	
	JTextField txtUsername = new JTextField();
	JPasswordField txtPassword = new JPasswordField();
	
        JTextField retrievedUsername = new JTextField();
        JTextField retrievedPassword = new JTextField();
        
	String tempCategory;
	
	public static String[] strCategories = {"Work", "Finances", "Personal", "Email"};
	
	
	JComboBox cmbCategories = new JComboBox(strCategories);
	
	LoggedInUser loggedUser;

	
//	
//	public void readFromTxt()
//	{
//		for(int i = 0; i < )
//	}
	
	public PasswordVaultWindow(LoggedInUser lu)
	{
		

//		list.setVisibleRowCount(3);
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
                setLayout(null);
		
                txtUsername.setBounds(185,330,135,30);
		add(txtUsername);
                txtPassword.setBounds(185,367,135,30);
		add(txtPassword);
                btnAuthentication.setBounds(170,400,120,35);
		add(btnAuthentication);
                btnBack.setBounds(190,550,90,35);
		add(btnBack);
                cmbCategories.setBounds(200,250,135,35);
		add(cmbCategories);
                retrievedUsername.setBounds(250,450,135,30);
                add(retrievedUsername);        
                retrievedPassword.setBounds(250,495,135,30);
		add(retrievedPassword);
		
		System.out.println(this.cmbCategories.getSelectedItem());


		
		loggedUser = lu;
		
		
		this.btnAuthentication.addActionListener(this);
		this.btnBack.addActionListener(this);
		
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		
		switch(ae.getActionCommand())
		{
		
		case "Authenticate":
			
			if(txtUsername.getText().equals(loggedUser.getUser()))
			{
			LoginController lc = new LoginController(txtUsername.getText(), txtPassword.getPassword());
			lc.authenticated = lc.authenticate();
				if(lc.authenticated)
				{
					JOptionPane.showMessageDialog(null, "Username matched! (Test)");
					JOptionPane.showMessageDialog(null, "Authenticated!");
					
					tempCategory = cmbCategories.getSelectedItem().toString();
					PasswordVaultController pv = new PasswordVaultController(txtUsername.getText(), tempCategory, "facebook");
					pv.readCredentials();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Username and/or password incorrect.");
					System.out.println("You cannot retrieve Information");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Your username does not match the current username! (Test)");
			}
			
		break;
		
		case "< Back":
	        MainFrame.mainFrame.getContentPane().removeAll();
            
            NavigationWindow x = new NavigationWindow(loggedUser);
            MainFrame.mainFrame.add(x);
            MainFrame.mainFrame.getContentPane().invalidate();
            MainFrame.mainFrame.getContentPane().validate();
			break;
		default:
			System.out.println("Error");
		}
	}
}