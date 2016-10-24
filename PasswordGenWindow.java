import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class PasswordGenWindow extends JFrame implements ActionListener
{

	JLabel lblPwdLength = new JLabel("Password Length: ");
	JLabel lblIncludes = new JLabel("Include: ");

	JButton btnGenerate = new JButton("Generate");
	JButton btnBack = new JButton("Back");

	JCheckBox chkboxSymbols = new JCheckBox("Symbols");
	JCheckBox chkboxNumbers = new JCheckBox("Numbers");
	JCheckBox chkboxLowercaseLetters = new JCheckBox("Lowercase Letters");
	JCheckBox chkboxUppercaseLetters = new JCheckBox("Uppercase Letters");

	JSlider sldPwdLength = new JSlider(JSlider.HORIZONTAL, 8, 32, 12);

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();

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

		p4.setBackground(Color.WHITE);
		p4.add(btnGenerate);
		p4.add(btnBack);

		
		add(p1);
		add(p2);
		add(p3);
		add(p4);

		this.btnBack.addActionListener(this);
		this.btnGenerate.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		switch(ae.getActionCommand())
		{
		
		case "Back":
			NavigationWindow x = new NavigationWindow();
			x.setVisible(true);
			this.dispose();
			this.setVisible(false);
		break;
			
		case "Generate":

        break;
	
		}
	}
}
