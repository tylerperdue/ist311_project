/*
 * Author: Fahad Abunayyan
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;


public class LoginWindow extends JFrame implements ActionListener
{

	JTextField txtUsername = new JTextField(10);
	JPasswordField txtPassword = new JPasswordField(10);
	
	
	JLabel lblLogin = new JLabel("Please Login:");
	JLabel lblUsername = new JLabel("Username:");
	JLabel lblPassword = new JLabel("Password:");
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();

	
	JButton btnLogin = new JButton("Login");
	JButton btnCancel = new JButton("Cancel");
	JButton btnNewAccount = new JButton("Create New Account");

	
	
	public LoginWindow()
	{
		
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 340);
		this.setLocation(500, 250);
		this.getContentPane().setBackground(Color.WHITE);
		
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
//		add(new JLabel(new ImageIcon("vaultii.png")));
	
		p1.setBackground(Color.WHITE);
		p1.add(lblUsername);
		p1.add(txtUsername);
		
		p2.setBackground(Color.WHITE);
		p2.add(lblPassword);
		p2.add(txtPassword);
		
		p3.setBackground(Color.WHITE);
		p3.add(btnCancel);
		p3.add(btnLogin);

		p4.add(lblLogin);
		p4.setBackground(Color.WHITE);

		p5.add(btnNewAccount);
		p5.setBackground(Color.WHITE);

		
	
		add(p4);
		add(p1);
		add(p2);
		add(p3);
		add(p5);

		
		this.btnCancel.addActionListener(this);
		this.btnLogin.addActionListener(this);
		this.btnNewAccount.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		switch(ae.getActionCommand())
		{
		
		case "Cancel":
			this.dispose();
			this.setVisible(false);
		break;
			
		case "Login":
			LoginController lc = new LoginController(txtUsername.getText(), txtPassword.getPassword());
			boolean authentiated = lc.authenticate();
			if(authentiated){
				JOptionPane.showMessageDialog(null, "Successfully Authenticated!");
				//mainFrame x = new mainFrame();
				NavigationWindow x = new NavigationWindow();
				x.setVisible(true);
				this.dispose();
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "Username and/or password incorrect.");
			}
        	break;
        	default: 
				System.err.println("Error");

		case "Create New Account":
			this.dispose();
			RegistrationWindow r = new RegistrationWindow();
			r.setVisible(true);
		break;			
		}
		
	}
//	
//	public static void main(String[] args)
//	{
//		
//		cLogin login = new cLogin();
//		login.setVisible(true);
//	}
//	
}
