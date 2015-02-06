package fileChooser;

import java.awt.*;
import java.beans.*;
import java.io.*;

import javax.swing.*;


public class ImagePreviewer extends JLabel{

	public ImagePreviewer(JFileChooser chooser)
	{
		this.setPreferredSize(new Dimension(100,100));
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setHorizontalAlignment(CENTER);
		chooser.addPropertyChangeListener(new PropertyChangeListener()
		{
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO 自动生成的方法存根
				if(event.getPropertyName()==JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
				{
					File f=(File)event.getNewValue();
					if(f==null)
					{
						ImagePreviewer.this.setIcon(null);
						return;
					}
					ImageIcon icon=new ImageIcon(f.getPath());
					
					if(icon.getIconWidth()>ImagePreviewer.this.getWidth())
						icon=new ImageIcon(icon.getImage().getScaledInstance(ImagePreviewer.this.getWidth(),
								-1, Image.SCALE_DEFAULT));
					ImagePreviewer.this.setIcon(icon);
				}
			}
		});
	}
	
}
