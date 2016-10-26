import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


public class AddCredentialsWindow extends JFrame implements ActionListener
{

	JLabel lblIntro = new JLabel("Input new credentials and select category: ");
	
	JLabel lblUsername = new JLabel("New Username:");
	JTextField txtUsername = new JTextField(10);
	
	JLabel lblPassword = new JLabel("New Password:");
	JPasswordField txtPassword = new JPasswordField(10);
	
	JButton btnBack = new JButton("Back");
	JButton btnAdd = new JButton("Add");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

	LoggedInUser loggedUser;


	public AddCredentialsWindow(LoggedInUser lu)
	{
		
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 340);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		
		
		p1.setBackground(Color.WHITE);
		p1.add(lblIntro);

		p2.setBackground(Color.WHITE);
		p2.add(lblUsername);
		p2.add(txtUsername);

		p3.setBackground(Color.WHITE);
		p3.add(lblPassword);
		p3.add(txtPassword);

		p4.setBackground(Color.WHITE);
		p4.add(btnBack);
		p4.add(btnAdd);
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);

		this.btnBack.addActionListener(this);
		this.btnAdd.addActionListener(this);

		this.loggedUser = lu;
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		switch(ae.getActionCommand())
		{
		
		case "Back":

		break;
			
		case "Add":
			AddCredentialsController x = new AddCredentialsController(loggedUser, txtUsername.getText(), 
																	  txtPassword.getPassword());
			boolean added = x.addCredential();
			if(added){
				NavigationWindow y = new NavigationWindow(loggedUser);
				y.setVisible(true);
				this.dispose();
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "Unable to add credential");
			}
        break;
	
		}
	}
}
