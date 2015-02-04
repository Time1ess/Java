package fontTest;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Scanner;

import javax.swing.*;

public class FontTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new SimpleFrame();
				frame.setTitle("FontTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class SimpleFrame extends JFrame
{
	public SimpleFrame()
	{
		add(new FontComponent());
		pack();
	}
}

class FontComponent extends JComponent
{
	private static final int DEFAULT_WIDTH=500;
	private static final int DEFAULT_HEIGHT=500;
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D)g;
		String message="HELLO WORLD!"; 
		
		Font f=new Font("SansSerif",Font.BOLD,36);
		g2.setFont(f);
		
		FontRenderContext context=g2.getFontRenderContext();
		Rectangle2D bounds=f.getStringBounds(message, context);
		LineMetrics metrics=f.getLineMetrics(message, context);
		
		double descent=metrics.getDescent(); //下坡度
		double leading=metrics.getLeading();  //行间距
		
		double x=(getWidth()-bounds.getWidth())/2;   
		double y=(getHeight()-bounds.getHeight())/2;
		
		double ascent=-bounds.getY(); //上坡度
		double baseY=y+ascent;   //基线Y坐标
		
		g2.drawString(message, (int)x, (int)baseY);
		
		g2.setPaint(Color.LIGHT_GRAY);
		
		
		
		//baseY=(=(getHeight()-bounds.getHeight())/2+(-bounds.getY());
		//基线Y坐标,**蓝色**
		g2.setPaint(Color.BLUE);
		g2.draw(new Line2D.Double(x-10,baseY,x+bounds.getWidth()+10,baseY));
		//y=(getHeight()-bounds.getHeight())/2;
		//上坡度Y坐标，以基线计算，**红色**
		g2.setPaint(Color.RED);
		g2.draw(new Line2D.Double(x-10,y,x+bounds.getWidth()+10,y));
		//下坡度Y坐标，以基线计算,**绿色**
		g2.setPaint(Color.GREEN);
		g2.draw(new Line2D.Double(x-10,baseY+descent,x+bounds.getWidth()+10,baseY+descent));
		//行间距Y坐标，以基线计算,,**黄色**
		g2.setPaint(Color.YELLOW);
		g2.draw(new Line2D.Double(x-10,baseY+descent+leading,x+bounds.getWidth()+10,baseY+descent+leading));
		
		//Rectangle2D rect=new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
		//g2.draw(rect);
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}