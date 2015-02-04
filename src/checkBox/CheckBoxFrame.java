package checkBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxFrame extends JFrame
{
	private final static int FONTSIZE=20;


	public CheckBoxFrame()
	{
		final JLabel label=new JLabel("Hello World!");
		label.setFont(new Font("Serif",0,FONTSIZE));
		JPanel northPanel=new JPanel();
		northPanel.add(label);
		
		this.add(northPanel,BorderLayout.CENTER);
		
		final JCheckBox bold=new JCheckBox("Bold");
		final JCheckBox italic=new JCheckBox("Italic");

		ActionListener listener=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int mode=0;
				if(bold.isSelected())mode+=Font.BOLD;
				if(italic.isSelected())mode+=Font.ITALIC;
				label.setFont(new Font("Serif",mode,FONTSIZE));
			}
		};
		bold.addActionListener(listener);
		italic.addActionListener(listener);
		
		JPanel southPanel=new JPanel();
		southPanel.setLayout(new GridLayout(1,2));
		southPanel.add(bold);
		southPanel.add(italic);
		
		this.add(southPanel,BorderLayout.SOUTH);
		pack();
	}
}