package border;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class BorderFrame extends JFrame{

	private JPanel demoPanel;
	private JPanel buttonPanel;
	private ButtonGroup group;
	
	public BorderFrame()
	{
		demoPanel=new JPanel();
		buttonPanel=new JPanel();
		group=new ButtonGroup();
		
		this.addRadioButton("Lower bevel", BorderFactory.createLoweredBevelBorder());
		this.addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
		this.addRadioButton("Etched", BorderFactory.createEtchedBorder());
		this.addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
		this.addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE));
		this.addRadioButton("Empty", BorderFactory.createEmptyBorder());
		
		Border etched=BorderFactory.createEtchedBorder();
		Border titled=BorderFactory.createTitledBorder(etched, "Border types");
		buttonPanel.setBorder(titled);
		
		this.setLayout(new GridLayout(2,1));
		this.add(buttonPanel);
		this.add(demoPanel);
		pack();
		
		
	}
	
	public void addRadioButton(String buttonName,final Border b)
	{
		JRadioButton button=new JRadioButton(buttonName);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				demoPanel.setBorder(b);
			}
		});
		group.add(button);
		buttonPanel.add(button);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new BorderFrame();
				frame.setTitle("BorderFrame test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
