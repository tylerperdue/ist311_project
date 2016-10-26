import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class PasswordGenWindow extends JFrame implements ActionListener
{

	JLabel lblPwdLength = new JLabel("Password Length: ");
	JLabel lblIncludes = new JLabel("Include: ");
	JLabel lblGenPassword = new JLabel("Generated Password:");

	JButton btnGenerate = new JButton("Generate");
	JButton btnBack = new JButton("Back");

	JCheckBox chkboxSymbols = new JCheckBox("Symbols");
	JCheckBox chkboxNumbers = new JCheckBox("Numbers");
	JCheckBox chkboxLowercaseLetters = new JCheckBox("Lowercase Letters");
	JCheckBox chkboxUppercaseLetters = new JCheckBox("Uppercase Letters");
	
	JTextArea txtArPassword = new JTextArea(2,1);
	
	JScrollPane scrlPane = new JScrollPane(txtArPassword);

	JSlider sldPwdLength = new JSlider(JSlider.HORIZONTAL, 8, 32, 12);

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();

	LoggedInUser loggedUser;
	
	public PasswordGenWindow(LoggedInUser lu)
	{
		
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		
		this.sldPwdLength.setMajorTickSpacing(10);
		this.sldPwdLength.setMinorTickSpacing(2);
		this.sldPwdLength.setPaintTicks(true);
		this.sldPwdLength.setPaintLabels(true);
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtArPassword.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 50, 300)));
		
		txtArPassword.setEditable(false);
		
		scrlPane.setBounds(5, 5, 300,50);
		
		p1.setBackground(Color.WHITE);
		p1.add(lblPwdLength);
		p1.add(sldPwdLength);

		p2.setBackground(Color.WHITE);
		p2.add(lblIncludes);

		p3.setBackground(Color.WHITE);
		p3.add(chkboxSymbols);
		p3.add(chkboxNumbers);
		p3.add(chkboxLowercaseLetters);
		p3.add(chkboxUppercaseLetters);
		
//		p4.setBackground(Color.WHITE);
//		p4.add(displayPassword);
		
		p5.setBackground(Color.WHITE);
		p5.add(btnGenerate);
		p5.add(btnBack);

		p4.setBackground(Color.WHITE);
		p4.add(scrlPane);
		
		add(p1);
		add(p2);
		add(p3);
		add(p5);
		add(p4);

		this.btnBack.addActionListener(this);
		this.btnGenerate.addActionListener(this);

		this.loggedUser = lu;
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		
		PasswordGenController Generator = new PasswordGenController();
		
		int nLength = 0;
		switch(ae.getActionCommand())
		{
		
		case "Back":
			NavigationWindow x = new NavigationWindow(loggedUser);
			x.setVisible(true);
			this.dispose();
			this.setVisible(false);
		break;
			
		case "Generate":
			System.out.println(sldPwdLength.getValue());
			
			try{
				
				String strGeneratedPassword = "";
				nLength = Integer.valueOf(sldPwdLength.getValue());
				strGeneratedPassword = Generator.GeneratePassword(nLength);
				this.txtArPassword.setText(strGeneratedPassword);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Please enter a length for the password");
			}

        break;
	
		}
	}
}
