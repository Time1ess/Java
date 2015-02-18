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
 * 该游戏开发第一步是设置十五个数字，可以与空白方块自由交换位置，当达到顺序排列时游戏成功
 * 第一步的游戏还很粗糙，考虑到可能会出现无解的情况
 * 第二步应加入解的情况判定并添加 按钮采用A*算法进行计算机求解演示
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
