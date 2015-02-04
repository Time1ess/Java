package mouse;

import java.awt.EventQueue;

import javax.swing.*;

public class MouseFrame extends JFrame {
	public MouseFrame()
	{
		add(new MouseComponent());
		pack();
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new MouseFrame();
				frame.setTitle("MouseFrame test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,500);
				frame.setVisible(true);
			}
		});
	}
	
}
