package sixteenSquares;

import java.awt.EventQueue;

import javax.swing.JFrame;

/*
 * ����Ϸ������һ��������ʮ������֣�������հ׷������ɽ���λ�ã����ﵽ˳������ʱ��Ϸ�ɹ�
 * ��һ������Ϸ���ֲܴڣ����ǵ����ܻ�����޽�����
 * �ڶ���Ӧ����������ж������ ��ť����A*�㷨���м���������ʾ
 */

public class GameTest
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
			{
				
				@Override
				public void run()
				{
					JFrame frame=new GameFrame();
					frame.setTitle("Sixteen Squares Game");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}
}
