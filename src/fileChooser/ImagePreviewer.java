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
					//getScaledInstance方法简述
					/*	getScaledInstance(int width, int height, int hints)
					 *  按指定宽高来创建新图像，如果其中之一为负，则按该参数的原始尺寸等比例调整
					 *  如果两个都为负，则使用原始图像尺寸
					 */
					ImagePreviewer.this.setIcon(icon);
				}
			}
		});
	}
	
}
