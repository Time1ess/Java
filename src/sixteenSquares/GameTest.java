package sixteenSquares;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
					frame.setTitle("Sixteen Squares Game");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}
}
