package imageTest;

import java.awt.*;

import javax.swing.*;

public class ImageTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new Sframe();
				frame.setTitle("ImageTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class Sframe extends JFrame
{
	public Sframe()
	{
		add(new SComponent());
		pack();
	}
}

class SComponent extends JComponent
{
	private static final int DEFAULT_WIDTH=1366;
	private static final int DEFAULT_HEIGHT=768;
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		Image image=new ImageIcon("1.jpg").getImage();
		g2.drawImage(image, 0, 0,1366,768, null);
	}
}