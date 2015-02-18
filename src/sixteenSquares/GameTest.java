package sixteenSquares;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import sixteenSquares.GameFrame.DownMove;
import sixteenSquares.GameFrame.LeftMove;
import sixteenSquares.GameFrame.RightMove;
import sixteenSquares.GameFrame.SquareListener;
import sixteenSquares.GameFrame.UpMove;

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
					frame.setTitle("Game");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}
}
