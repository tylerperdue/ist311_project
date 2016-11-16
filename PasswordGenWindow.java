import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;


public class PasswordGenWindow extends JPanel implements ActionListener
{
    //background image pulled from URL
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("fIIfuBg.png"));
        } 
        catch (IOException e) {
                System.out.println("Image not found");
        }}
       
       //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  

	
	JButton btnGenerate = new JButton("Generate");
	JButton btnBack = new JButton("< Back");

	JCheckBox chkboxSymbols = new JCheckBox();
	JCheckBox chkboxNumbers = new JCheckBox();
	JCheckBox chkboxLowercaseLetters = new JCheckBox();
	JCheckBox chkboxUppercaseLetters = new JCheckBox();
	
	JTextArea txtArPassword = new JTextArea(1,1);
	
	JScrollPane scrlPane = new JScrollPane(txtArPassword);

	JSlider sldPwdLength = new JSlider(JSlider.HORIZONTAL, 8, 32, 12);

        LoggedInUser loggedUser;
        
	public PasswordGenWindow(LoggedInUser lu)
	{
		
		setLayout(null);
		
		
		sldPwdLength.setMajorTickSpacing(10);
		sldPwdLength.setMinorTickSpacing(1);
                
		sldPwdLength.setBounds(200,220,200,100);
                sldPwdLength.setPaintTicks(true);
		sldPwdLength.setPaintLabels(true);
                
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtArPassword.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 50, 300)));
		
		txtArPassword.setEditable(false);
		
		scrlPane.setBounds(55,535,350,50);
		chkboxSymbols.setBounds(80,355,23,23);
		chkboxNumbers.setBounds(250,355,23,23);
                chkboxLowercaseLetters.setBounds(80,393,23,23);
                chkboxUppercaseLetters.setBounds(250,393,23,23);
                
                btnBack.setBounds(230,462,100,35);
                btnGenerate.setBounds(120,462,100,35);
                
		add(sldPwdLength);
		add(chkboxSymbols);
		add(chkboxNumbers);
		add(chkboxLowercaseLetters);
		add(chkboxUppercaseLetters);
		
		add(btnGenerate);
		add(btnBack);

		add(scrlPane);		

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
		
		case "< Back": 
                    MainFrame.mainFrame.getContentPane().removeAll();
                       
                    NavigationWindow x = new NavigationWindow(loggedUser);
                    MainFrame.mainFrame.add(x);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();		
			
		break;
			
		case "Generate":
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
                                        strGeneratedPassword += Generator.GenerateCapLetters(2, this.chkboxUppercaseLetters.isSelected()) +
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