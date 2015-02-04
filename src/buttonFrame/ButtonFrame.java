package buttonFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ButtonFrame extends JFrame {

	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;
	
	public ButtonFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
//		JButton yellowButton=new JButton("YELLOW");
//		JButton blueButton=new JButton("BULUE");
//		JButton redButton=new JButton("RED");
		
		buttonPanel=new JPanel();
		for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels())
			makeButton(info.getName(),info.getClassName());
		
//		makeButton("YELLOW",Color.YELLOW);
//		makeButton("BLUE",Color.BLUE);
//		makeButton("RED",Color.RED);
//		makeButton("RESET",buttonPanel.getBackground());
		
		
//		buttonPanel.add(yellowButton);
//		buttonPanel.add(blueButton);
//		buttonPanel.add(redButton);
		
		add(buttonPanel);
		
//		ColorAction yelloAction=new ColorAction(Color.YELLOW);
//		ColorAction blueAction=new ColorAction(Color.BLUE);
//		ColorAction redAction=new ColorAction(Color.RED);
		
//		yellowButton.addActionListener(yelloAction);
//		blueButton.addActionListener(blueAction);
//		redButton.addActionListener(redAction);
	}
	
	public void makeButton(String name,final String plafName)
	{
//		匿名内部类和局部内部类只能访问final变量
		
//		原因在于JVM编译时将内部类翻译成outer.Inner，即方法和内部类同级
//		而该变量为方法的局部变量，只在该方法内部有效，所以该内部类无法访问
//		所以要使用final修饰，才可以访问
//		而final修饰后可以使用是因为Java采用了copy local variable的方式
//		也就是说把定义为final的局部变量拷贝过来用，而引用的也可以拿过来用，
//		只是不能重新赋值。从而造成了可以access   local   variable的假象，
//		而这个时候由于不能重新赋值，所以一般不会造成不可预料的事情发生
//		
		
		JButton button=new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(ButtonFrame.this);
					System.out.println(plafName);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
//	private class ColorAction implements ActionListener
//	{
//		private Color backgroundColor;
//		
//		public ColorAction(Color c)
//		{
//			backgroundColor=c;
//		}
//		
//		public void actionPerformed(ActionEvent event)
//		{
//			buttonPanel.setBackground(backgroundColor);
//		}
//	}
	
	public static void main(String[] args)
	{

		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new ButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("ButtonFrame");
				frame.setVisible(true);
			}
		});
	}
	

}
