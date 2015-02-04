package radioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonFrame extends JFrame{

	private static final int DEFAULT_SIZE=20;
	final JPanel southPanel;
	final JLabel label;
	final ButtonGroup group;
	public RadioButtonFrame()
	{
		label=new JLabel("Hello World!");
		label.setFont(new Font("Serif",0,DEFAULT_SIZE));
		JPanel northPanel=new JPanel();
		northPanel.add(label);
		
		this.add(northPanel,BorderLayout.NORTH);
		
		group=new ButtonGroup();
		southPanel=new JPanel();
		
		this.addRadioButton("Small", 10);
		this.addRadioButton("Medium", 20);
		this.addRadioButton("Large",25);
		this.addRadioButton("Extra Large", 30);
		
		this.add(southPanel,BorderLayout.SOUTH);
		pack();
	}
	
	public void addRadioButton(String name,final int size)
	{
		boolean selected=size==DEFAULT_SIZE;
		JRadioButton button=new JRadioButton(name,selected);
		group.add(button);
		southPanel.add(button);
		
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				label.setFont(new Font("Serif",0,size));
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new RadioButtonFrame();
				frame.setTitle("RadioButtonFrame Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}

}
