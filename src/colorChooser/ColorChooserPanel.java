package colorChooser;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class ColorChooserPanel extends JPanel{

	public ColorChooserPanel()
	{
		JButton modalButton=new JButton("Modal");
		modalButton.addActionListener(new ModelListener());
		this.add(modalButton);
		
		JButton modelessButton=new JButton("Modeless");
		modelessButton.addActionListener(new ModelessListener());
		this.add(modelessButton);
		
		JButton immediateButton=new JButton("Immediate");
		immediateButton.addActionListener(new ImmediateListener());
		this.add(immediateButton);	
	}
	
	private class ModelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Color defaultColor=ColorChooserPanel.this.getBackground();
			Color selected=JColorChooser.showDialog(ColorChooserPanel.this, 
					"Set Background",defaultColor);
			if(selected!=null)ColorChooserPanel.this.setBackground(selected);
		}
	}
	
	private class ModelessListener implements ActionListener
	{
		private JDialog dialog;
		private JColorChooser chooser;
		
		public ModelessListener()
		{
			chooser=new JColorChooser();
			dialog=JColorChooser.createDialog(ColorChooserPanel.this, "Background Color",
					false,chooser,new ActionListener() 
					{
						@Override
						public void actionPerformed(ActionEvent event) 
						{
							ColorChooserPanel.this.setBackground(chooser.getColor());
						}
					},null);
		}
		
		public void actionPerformed(ActionEvent event)
		{
			chooser.setColor(ColorChooserPanel.this.getBackground());
			dialog.setVisible(true);
		}
	}
	
	private class ImmediateListener implements ActionListener
	{
		private JDialog dialog;
		private JColorChooser chooser;
		
		public ImmediateListener()
		{
			chooser=new JColorChooser();
			chooser.getSelectionModel().addChangeListener(new ChangeListener()
			{
				
				@Override
				public void stateChanged(ChangeEvent event)
				{
					ColorChooserPanel.this.setBackground(chooser.getColor());
				}
			});
			dialog=new JDialog((Frame)null,false);
			dialog.add(chooser);
			dialog.pack();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			chooser.setColor(ColorChooserPanel.this.getBackground());
			dialog.setVisible(true);
		}
	}
}
