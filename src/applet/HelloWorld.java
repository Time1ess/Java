package applet;

import java.awt.*;
import javax.swing.*;

public class HelloWorld extends JApplet
{
	public void init()
	{
		EventQueue.invokeLater(new Runnable()
			{
				
				@Override
				public void run()
				{
					JLabel label=new JLabel("I'm a Hello World aplet",SwingConstants.CENTER);
					HelloWorld.this.add(label);
					
				}
			});
	}
}
