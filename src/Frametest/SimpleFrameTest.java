package Frametest;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class SimpleFrameTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				SimpleFrame frame=new SimpleFrame();  //创建框架
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置退出动作
				frame.setTitle("David's Java Test");  //设置标题
				frame.setVisible(true);				//设置可见性
			}
		});
	}
}
class SimpleFrame extends JFrame      //以JFrame为基类扩展的自定义框架类
{
	
	public SimpleFrame()
	{
		
//		Toolkit kit=Toolkit.getDefaultToolkit();       //创建Toolkit对象以获取系统屏幕大小
//		Dimension screen=kit.getScreenSize();
//		setSize(screen.width/2,screen.height/2);       //以系统屏幕大小设置框架大小
//		setLocationByPlatform(true);                    //设置定位方式
//		add(new HelloWorldComponent());             //添加对象到框架中
		add(new HelloWorldComponent());
		pack();          //使框架配合对象大小进行调整
	}
}

class HelloWorldComponent extends JComponent         //以JComponent为基类扩展的自定义对象类
{
	public static final int MESSAGE_X=100;
	public static final int MESSAGE_Y=100;
	
	private static final int DEFAULT_WIDTH=800;
	private static final int DEFAULT_HEIGHT=150;
	
	public void paintComponent(Graphics g)              //使用drawString方法显示文字
	{
		Font sanbold14=new Font("SansSerif",Font.BOLD,100);
		g.setFont(sanbold14);
		g.drawString("Hello World!", MESSAGE_X, MESSAGE_Y);
	}
	
	public Dimension getPreferredSize()          //返回对象首选大小
	{
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}

class DrawComponent extends JComponent
{
	private static final int DEFAULT_WIDTH=400;
	private static final int DEFAULT_HEIGHT=400;
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.setPaint(SystemColor.desktop);
		double leftX=100;
		double topY=100;
		double width=200;
		double height=150;
		Rectangle2D rect=new Rectangle2D.Double(leftX,topY,width,height);
		g2.draw(rect);
		
		Ellipse2D ellipse=new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);
		
		
		g2.draw(new Line2D.Double(leftX,topY,width+leftX,topY+height));
		g2.draw(new Line2D.Double(leftX,topY+height,leftX+width,topY));
		
		double centerX=rect.getCenterX();
		double centerY=rect.getCenterY();
		double radius=150;
		
		Ellipse2D circle=new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
		g2.draw(circle);
		
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}