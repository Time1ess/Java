package fontTest;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Scanner;

import javax.swing.*;

public class FontTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
		
		double descent=metrics.getDescent(); //���¶�
		double leading=metrics.getLeading();  //�м��
		
		double x=(getWidth()-bounds.getWidth())/2;   
		double y=(getHeight()-bounds.getHeight())/2;
		
		double ascent=-bounds.getY(); //���¶�
		double baseY=y+ascent;   //����Y����
		
		g2.drawString(message, (int)x, (int)baseY);
		
		g2.setPaint(Color.LIGHT_GRAY);
		
		
		
		//baseY=(=(getHeight()-bounds.getHeight())/2+(-bounds.getY());
		//����Y����,**��ɫ**
		g2.setPaint(Color.BLUE);
		g2.draw(new Line2D.Double(x-10,baseY,x+bounds.getWidth()+10,baseY));
		//y=(getHeight()-bounds.getHeight())/2;
		//���¶�Y���꣬�Ի��߼��㣬**��ɫ**
		g2.setPaint(Color.RED);
		g2.draw(new Line2D.Double(x-10,y,x+bounds.getWidth()+10,y));
		//���¶�Y���꣬�Ի��߼���,**��ɫ**
		g2.setPaint(Color.GREEN);
		g2.draw(new Line2D.Double(x-10,baseY+descent,x+bounds.getWidth()+10,baseY+descent));
		//�м��Y���꣬�Ի��߼���,,**��ɫ**
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