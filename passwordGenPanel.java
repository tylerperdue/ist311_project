import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 *
 * @author Fahad
 */

//This class defines and displays the password generator window
//The functionality is in the passwordGenCntrl class

public class passwordGenPanel extends JFrame implements ActionListener
{
	private JCheckBox chkNumbers,		// password contains numbers?
					  chkLetters,		// letters?
					  chkSpecialChar;	// special characters?
	private JButton btnGenerate,
					btnCancel,
					btnClear;
	
	private JLabel lblLength;
	private JLabel lblGenPassword;
	private JTextField txtLength;
	private JTextArea displayPassword;
	private JPanel[] panel = new JPanel[6];

	
	public passwordGenPanel()
	{
		this.setTitle("Password Generator");
		this.getContentPane().setBackground(Color.WHITE);
		this.setSize(350, 350);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400, 200);
		
		
		for(int j = 0; j < 6; j++)		// loop to initialize the panels
			panel[j] = new JPanel();
		
		chkNumbers = new JCheckBox("Numbers");
		chkLetters = new JCheckBox("Letters");
		chkSpecialChar = new JCheckBox("Special Characters");
		
		lblLength = new JLabel("Please enter length of password:");
		lblGenPassword = new JLabel("Generated Password:");
		
		txtLength = new JTextField(3);
		
		displayPassword = new JTextArea(3,25);	
		displayPassword.setEditable(false);		// does not allow user to type in text area
		
		btnGenerate = new JButton("Generate");
		btnCancel = new JButton("Cancel");
		btnClear = new JButton("Clear");
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		displayPassword.setBorder(BorderFactory.createCompoundBorder(border, 
								  BorderFactory.createEmptyBorder(10, 10, 10, 10)));	// black boreder around text area
		
		

		panel[0].setLayout(new GridLayout(2,2)); // to align the checkboxes in panel[0]
		
		panel[0].add(chkNumbers);
		panel[0].add(chkLetters);
		panel[0].add(chkSpecialChar);
		panel[0].setBackground(Color.WHITE);
		
		panel[1].add(lblLength);
		panel[1].add(txtLength);
		panel[1].setBackground(Color.WHITE);
		
		panel[2].add(lblGenPassword);
		panel[2].setBackground(Color.WHITE);
		
		panel[3].add(displayPassword);
		panel[3].setBackground(Color.WHITE);
		
		panel[4].add(btnCancel);
		panel[4].add(btnClear);
		panel[4].add(btnGenerate);
		panel[4].setBackground(Color.WHITE);
		
		
		btnGenerate.addActionListener(this);
		btnCancel.addActionListener(this);
		btnClear.addActionListener(this);
		
		for(int i = 0; i < 5; i++)
			add(panel[i]);			// add panels to frame
		
	}
	
//	public static void main(String[] args)
//	{
//		passwordGenPanel pg = new passwordGenPanel();
//		pg.setVisible(true);
//	}

	public void actionPerformed(ActionEvent e) 
	{
	
		switch(e.getActionCommand())
		{
		case "Generate":
			this.displayPassword.setText("Generated Password will be displayed here");
			break; 
		case "Cancel":
			this.dispose();
			this.setVisible(false);
			break;
		case "Clear":
			this.displayPassword.setText(null);
			break;
			default:
				System.out.println("Error");
		}
		
	}
	
}
