import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PasswordGenWindow extends JPanel implements ActionListener
{
    //background image pulled from URL
       static Image bgimg = null;{
        try {
                bgimg = ImageIO.read(LoginWindow.class.getResource("generatepassword.png"));
        } 
        catch (IOException e) {
                System.out.println("Image not found");
        }}
       
       //paint method that will paint background
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bgimg, 0, 0, getWidth(), getHeight(), this);
    }  

	
	JButton btnGenerate = new JButton();
	JButton btnBack = new JButton();

	JCheckBox chkboxSymbols = new JCheckBox();
	JCheckBox chkboxNumbers = new JCheckBox();
	JCheckBox chkboxLowercaseLetters = new JCheckBox();
	JCheckBox chkboxUppercaseLetters = new JCheckBox();
	
	JTextArea txtArPassword = new JTextArea(1,1);
	
	JScrollPane scrlPane = new JScrollPane(txtArPassword);

	JSlider sldPwdLength = new JSlider(JSlider.HORIZONTAL, 8, 32, 12);
	
	JLabel lblPasswordLength = new JLabel("Length:");
	JLabel lblSliderLength = new JLabel(Integer.toString(sldPwdLength.getValue()));
	

        LoggedInUser loggedUser;
        
	public PasswordGenWindow(LoggedInUser lu)
        {	
		setLayout(null);
		
		ChangeHandler handler = new ChangeHandler();
				
		sldPwdLength.addChangeListener(handler);
		sldPwdLength.setForeground(Color.WHITE);
		sldPwdLength.setMajorTickSpacing(10);
		sldPwdLength.setMinorTickSpacing(1);
                
		sldPwdLength.setBounds(160,290,200,100);
		lblSliderLength.setBounds(280,265,200,100);
		
		lblPasswordLength.setFont(new Font("HELVETICA", Font.BOLD, 12));
		lblPasswordLength.setBounds(225,265,200,100);
		lblPasswordLength.setForeground(Color.WHITE);
		
		lblSliderLength.setForeground(Color.WHITE);
		lblSliderLength.setFont(new Font("HELVETICA", Font.BOLD, 12));
		add(lblSliderLength);
		add(lblPasswordLength);
                sldPwdLength.setPaintTicks(true);
		sldPwdLength.setPaintLabels(true);
                
		Border border = BorderFactory.createLineBorder(Color.WHITE);
		txtArPassword.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 50, 300)));
		
		txtArPassword.setEditable(false);
		
		
		scrlPane.setBounds(28,570,320,50);
		chkboxSymbols.setBounds(54,397,23,23);
		chkboxNumbers.setBounds(205,397,23,23);
                chkboxLowercaseLetters.setBounds(54,447,23,23);
                chkboxUppercaseLetters.setBounds(205,447,23,23);
                
                btnGenerate.setBounds(83,495,220,44);
                btnGenerate.setBorderPainted(false);
                btnGenerate.setContentAreaFilled(false);
                btnGenerate.setOpaque(false);
                btnGenerate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                
                btnBack.setBounds(0,28,68,38);
                btnBack.setBorderPainted(false);
                btnBack.setContentAreaFilled(false);
                btnBack.setOpaque(false);
                btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
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
	
	private class ChangeHandler implements ChangeListener
	{
		
		public void stateChanged(ChangeEvent event)
		{
			if(event.getSource() == sldPwdLength)
			{
                            int sliderLength = sldPwdLength.getValue();
                            String silderLength = Integer.toString(sliderLength);
                            lblSliderLength.setText(silderLength);	
				
			}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		PasswordGenController Generator = new PasswordGenController();
		
		int nLength = 0;
		if (ae.getSource() == btnBack) { 
                    MainFrame.mainFrame.getContentPane().removeAll();
                    NavigationWindow x = new NavigationWindow(loggedUser);
                    MainFrame.mainFrame.add(x);
                    MainFrame.mainFrame.getContentPane().invalidate();
                    MainFrame.mainFrame.getContentPane().validate();		
                }
                else if (ae.getSource() == btnGenerate) {	
                    nLength = sldPwdLength.getValue();
                    try{

                        String strGeneratedPassword = "";
                        String strCapture = "";
                        for(int i = 0; i < 50; i++)
                        {	
                                for(int j = 0; j < 10; j++)
                                {
                                    strGeneratedPassword +=   Generator.GenerateCapLetters(Generator.randomNumber(), this.chkboxUppercaseLetters.isSelected()) +
                                    Generator.GenerateSmallLetters(Generator.randomNumber(), this.chkboxLowercaseLetters.isSelected()) +
                                    Generator.GenerateNumbers(Generator.randomNumber(), this.chkboxNumbers.isSelected()) +
                                    Generator.GenerateSymbols(Generator.randomNumber(), this.chkboxSymbols.isSelected());
                                }
//                                        strGeneratedPassword += Generator.GenerateCapLetters(2, this.chkboxUppercaseLetters.isSelected()) +
//                                                                Generator.GenerateSmallLetters(2, this.chkboxLowercaseLetters.isSelected()) +
//                                                                Generator.GenerateNumbers(2, this.chkboxNumbers.isSelected()) +
//                                                                Generator.GenerateSymbols(2, this.chkboxSymbols.isSelected());

                                strCapture = strCapture + String.valueOf(strGeneratedPassword);
                        }


                        this.txtArPassword.setText(strCapture.substring(0, nLength));	
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "Please specify at least one password requirement");
                    }
        
		}
	}
}