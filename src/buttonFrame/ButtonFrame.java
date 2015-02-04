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
//		�����ڲ���;ֲ��ڲ���ֻ�ܷ���final����
		
//		ԭ������JVM����ʱ���ڲ��෭���outer.Inner�����������ڲ���ͬ��
//		���ñ���Ϊ�����ľֲ�������ֻ�ڸ÷����ڲ���Ч�����Ը��ڲ����޷�����
//		����Ҫʹ��final���Σ��ſ��Է���
//		��final���κ����ʹ������ΪJava������copy local variable�ķ�ʽ
//		Ҳ����˵�Ѷ���Ϊfinal�ľֲ��������������ã������õ�Ҳ�����ù����ã�
//		ֻ�ǲ������¸�ֵ���Ӷ�����˿���access   local   variable�ļ���
//		�����ʱ�����ڲ������¸�ֵ������һ�㲻����ɲ���Ԥ�ϵ����鷢��
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
