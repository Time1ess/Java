package Frametest;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class SimpleFrameTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				SimpleFrame frame=new SimpleFrame();  //�������
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //�����˳�����
				frame.setTitle("David's Java Test");  //���ñ���
				frame.setVisible(true);				//���ÿɼ���
			}
		});
	}
}
class SimpleFrame extends JFrame      //��JFrameΪ������չ���Զ�������
{
	
	public SimpleFrame()
	{
		
//		Toolkit kit=Toolkit.getDefaultToolkit();       //����Toolkit�����Ի�ȡϵͳ��Ļ��С
//		Dimension screen=kit.getScreenSize();
//		setSize(screen.width/2,screen.height/2);       //��ϵͳ��Ļ��С���ÿ�ܴ�С
//		setLocationByPlatform(true);                    //���ö�λ��ʽ
//		add(new HelloWorldComponent());             //��Ӷ��󵽿����
		add(new HelloWorldComponent());
		pack();          //ʹ�����϶����С���е���
	}
}

class HelloWorldComponent extends JComponent         //��JComponentΪ������չ���Զ��������
{
	public static final int MESSAGE_X=100;
	public static final int MESSAGE_Y=100;
	
	private static final int DEFAULT_WIDTH=800;
	private static final int DEFAULT_HEIGHT=150;
	
	public void paintComponent(Graphics g)              //ʹ��drawString������ʾ����
	{
		Font sanbold14=new Font("SansSerif",Font.BOLD,100);
		g.setFont(sanbold14);
		g.drawString("Hello World!", MESSAGE_X, MESSAGE_Y);
	}
	
	public Dimension getPreferredSize()          //���ض�����ѡ��С
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