package colorChooser;

import java.awt.EventQueue;

import javax.swing.*;

public class ColorChooserFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   public ColorChooserFrame()
   {      
      this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // add color chooser panel to frame

      ColorChooserPanel panel = new ColorChooserPanel();
      this.add(panel);
   }
   
   	public static void main(String[] args)
   	{
   		EventQueue.invokeLater(new Runnable() 
   		{		
			@Override
			public void run()
			{
				// TODO 自动生成的方法存根
		  		JFrame frame=new ColorChooserFrame();
	 			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  		frame.setTitle("ColorChooserFrame Test");
		   		frame.setVisible(true);
			}
			});

   	}
}