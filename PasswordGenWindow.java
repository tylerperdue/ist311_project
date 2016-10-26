import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
	
	public PasswordGenWindow()
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
		
	}
	
//	public class event implements ItemListener
//	{
//
//		@Override
//		public void itemStateChanged(ItemEvent e) {
//			// TODO Auto-generated method stub
//			if()
//			
//		}
//		
//	}
	


	
	
	public void actionPerformed(ActionEvent ae)
	{
		
		PasswordGenController Generator = new PasswordGenController();
		
		int nLength = 0;
		
		
		switch(ae.getActionCommand())
		{
		
		case "Back":
			NavigationWindow x = new NavigationWindow();
			x.setVisible(true);
			this.dispose();
			this.setVisible(false);
		break;
			
		case "Generate":
			System.out.println(sldPwdLength.getValue());
			System.out.println(chkboxUppercaseLetters.isSelected());
			
			nLength = sldPwdLength.getValue();
			try{
				
				String strGeneratedPassword = "";
				String strCapture = "";
				
				
				
				for(int i = 0; i < 50; i++)
				{
					
					for(int j = 0; j < 10; j++)
					{
						strGeneratedPassword +=   Generator.GenerateCapLetters(1, this.chkboxUppercaseLetters.isSelected()) +
												  Generator.GenerateSmallLetters(1, this.chkboxLowercaseLetters.isSelected()) +
												  Generator.GenerateNumbers(1, this.chkboxNumbers.isSelected()) +
												  Generator.GenerateSymbols(1, this.chkboxSymbols.isSelected());
					}
					strGeneratedPassword +=  	 Generator.GenerateCapLetters(2, this.chkboxUppercaseLetters.isSelected()) +
												 Generator.GenerateSmallLetters(2, this.chkboxLowercaseLetters.isSelected()) +
												 Generator.GenerateNumbers(2, this.chkboxNumbers.isSelected()) +
												 Generator.GenerateSymbols(2, this.chkboxSymbols.isSelected());
				
					strCapture = strCapture + String.valueOf(strGeneratedPassword);
				}
				
				
				this.txtArPassword.setText(strCapture.substring(0, nLength));

				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Please specify at least one password requirement");
			}

        break;
	
		}
	}
}
