package sixteenSquares;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class GameFrame extends JFrame
{
	private JPanel gamePanel;
	private JPanel settingPanel;
	private JButton resetButton;
	private JButton autoButton;
	private static int SIZE;
	private static int position;
	ArrayList<JButton> squares;
	public GameFrame()
	{
		JOptionPane settingPane=new JOptionPane();
		try
		{
			SIZE=Integer.valueOf(settingPane.showInputDialog(GameFrame.this, "请输入数码维数", "游戏初始化", JOptionPane.INFORMATION_MESSAGE));
			if(SIZE>5)throw new Exception();
		} 
		catch (Exception e)
		{
			JOptionPane errOptionPane=new JOptionPane();
			errOptionPane.showMessageDialog(GameFrame.this, "检测到初始化错误!","错误",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		settingPanel=new JPanel();
		gamePanel=new JPanel();
		gamePanel.setLayout(new GridLayout(SIZE, SIZE));
		resetButton=new JButton("重置");
		resetButton.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					GameFrame.this.Reset();
				}
			});
		autoButton=new JButton("自动");
		settingPanel.add(resetButton);
		settingPanel.add(autoButton);
		this.add(settingPanel,BorderLayout.SOUTH);
		squares=new ArrayList<JButton>();
		ActionListener listener=new SquareListener();
		for(int i=0;i<SIZE*SIZE;i++)
		{
			squares.add(new JButton());
			squares.get(i).addActionListener(listener);
			squares.get(i).setFont(new Font("monospaced",Font.BOLD,22));
			gamePanel.add(squares.get(i));
		}
		InputMap imap=gamePanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("UP"), "UP MOVE");
		imap.put(KeyStroke.getKeyStroke("DOWN"), "DOWN MOVE");
		imap.put(KeyStroke.getKeyStroke("LEFT"), "LEFT MOVE");
		imap.put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT MOVE");
		ActionMap amap=gamePanel.getActionMap();
		amap.put("UP MOVE", new DownMove());
		amap.put("DOWN MOVE", new UpMove());
		amap.put("LEFT MOVE", new RightMove());
		amap.put("RIGHT MOVE", new LeftMove());
		this.add(gamePanel, BorderLayout.CENTER);
		this.setSize(100*SIZE, 50+100*SIZE);
		this.setResizable(false);
		this.Reset();
	}
	class SquareListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
			int key=Integer.valueOf(event.getActionCommand());
			//System.out.println("key "+key+" pressed");
			if(key%SIZE!=0&&key-1==position)
			{
				GameFrame.this.move(0);
			}
			else if((key+1)%SIZE!=0&&key+1==position)
			{
				GameFrame.this.move(1);
			}
			else if(key>SIZE-1&&key-SIZE==position)
			{
				GameFrame.this.move(2);
			}
			else if(key<SIZE*(SIZE-1)&&key+SIZE==position)
			{
				GameFrame.this.move(3);
			}
			else 
			{
				System.out.println(Integer.toString(position));
			}
			}
			catch(Exception e)
			{
			}
			GameFrame.this.WinToReset();
		}
	}
	class UpMove extends AbstractAction
	{
		public void actionPerformed(ActionEvent event)
		{
				GameFrame.this.move(3);
				GameFrame.this.WinToReset();
		}
	}
	class DownMove extends AbstractAction
	{
		public void actionPerformed(ActionEvent event)
		{
				GameFrame.this.move(2);
				GameFrame.this.WinToReset();
		}
	}
	class LeftMove extends AbstractAction
	{
		public void actionPerformed(ActionEvent event)
		{
				GameFrame.this.move(1);
				GameFrame.this.WinToReset();
		}
	}
	class RightMove extends AbstractAction
	{
		public void actionPerformed(ActionEvent event)
		{
				GameFrame.this.move(0);
				GameFrame.this.WinToReset();
		}
	}
	void move(int direction)
	{
		switch(direction)
		{
		case 0:         //Right Move
		{
			if((position+1)%SIZE!=0)
			{
				squares.get(position).setText(squares.get(position+1).getText());
				squares.get(position+1).setText("");
				position+=1;
//				System.out.println(Integer.toString(position));
			}
			break;
		}
		case 1:         //Left Move
		{
			if(position%SIZE!=0)
			{
				squares.get(position).setText(squares.get(position-1).getText());
				squares.get(position-1).setText("");
				position-=1;
//				System.out.println(Integer.toString(position));
			}
			break;
		}
		case 2:         //Down Move
		{
			if(position<SIZE*(SIZE-1))
			{
				squares.get(position).setText(squares.get(position+SIZE).getText());
				squares.get(position+SIZE).setText("");
				position+=SIZE;
//				System.out.println(Integer.toString(position));
			}
			break;
		}
		case 3:         //Up Move
		{
			if(position>SIZE-1)
			{
				squares.get(position).setText(squares.get(position-SIZE).getText());
				squares.get(position-SIZE).setText("");
				position-=SIZE;
//				System.out.println(Integer.toString(position));
			}
			break;
		}
			
		default:
			break;
				
		}

	}
	void WinToReset()
	{
		if(GameFrame.this.isEnd())
		{
			JOptionPane optionPane=new JOptionPane();
			optionPane.showMessageDialog(GameFrame.this, "胜利!");
			GameFrame.this.Reset();
		}
	}
	boolean isanswerable()
	{
		int[] list=new int[SIZE*SIZE];
		int cs=0;
		for(int i=0;i<SIZE*SIZE;i++)
		{
			if(squares.get(i).getText()!="")
				list[i]=Integer.valueOf(squares.get(i).getText());
			else 
				list[i]=0;
			if(list[i]!=0)
			for(int j=0;j<i;j++)
			{
				if(list[j]>list[i])cs++;
			}
			else continue;
		}

		if(SIZE%2==0)
		{			
			if((cs+(SIZE*SIZE-1-position)/SIZE)%2==0)
				return true;
			else return false;
		}
		else
		{
			if(cs%2==0)return true;
			else return false;
		}
	}
	boolean isEnd()
	{
		int i;
		for(i=0;i<SIZE*SIZE-1;i++)
		{
			if(squares.get(i).getText()!=""&&
					Integer.valueOf(squares.get(i).getText())-1==i)continue;
			else break;
		}
		if(i==SIZE*SIZE-1)return true;
		else return false;
	}
	void Reset()
	{
		do
		{
			Random rand=new Random();
			int[] order=new int[SIZE*SIZE];
			int p;
			for(int i=0;i<SIZE*SIZE;i++)
			{
				squares.get(i).setText("");
				squares.get(i).setActionCommand(Integer.toString(i));
				while(true)
				{
					p=rand.nextInt(SIZE*SIZE)+1;
					int j;
					for(j=0;j<SIZE*SIZE;j++)
						if(order[j]==p)break;
					if(j==SIZE*SIZE)
					{
						order[i]=p;
						if(p!=SIZE*SIZE)
						{
							squares.get(i).setText(Integer.toString(p));
//							squares.get(i).setActionCommand(Integer.toString(p));
						}
						else
						{
							position=i;
//							System.out.println(Integer.toString(position));
						}
						break;
					}
			}
		}
		}while(GameFrame.this.isEnd()||!GameFrame.this.isanswerable());
	}

}
