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
			SIZE=Integer.valueOf(settingPane.showInputDialog("ÇëÊäÈëÊýÂëÎ¬Êý"));
			if(SIZE>5)throw new Exception();
		} 
		catch (Exception e)
		{
			JOptionPane errOptionPane=new JOptionPane();
			errOptionPane.showMessageDialog(GameFrame.this, "Error Detected!","ERROR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		settingPanel=new JPanel();
		gamePanel=new JPanel();
		gamePanel.setLayout(new GridLayout(SIZE, SIZE));
		JButton bu=new JButton("Test");
		resetButton=new JButton("Reset");
		resetButton.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					GameFrame.this.Reset();
				}
			});
		autoButton=new JButton("Auto Game");
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
			catch(Exception e){
				//System.out.println(e.getMessage());
				}
			//GameFrame.this.repaint();
			
//			if(GameFrame.this.isEnd())
//			{
//				JOptionPane optionPane=new JOptionPane();
//				optionPane.showMessageDialog(GameFrame.this, "Win!");
//				GameFrame.this.Reset();
//			}
		}
	}
	
	class UpMove extends AbstractAction
	{
		public void actionPerformed(ActionEvent event)
		{
				GameFrame.this.move(3);
		}
	}
	class DownMove extends AbstractAction
	{
		public void actionPerformed(ActionEvent event)
		{
				GameFrame.this.move(2);
		}
	}
	class LeftMove extends AbstractAction
	{
		public void actionPerformed(ActionEvent event)
		{
				GameFrame.this.move(1);
		}
	}
	class RightMove extends AbstractAction
	{
		public void actionPerformed(ActionEvent event)
		{
				GameFrame.this.move(0);
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
				System.out.println(Integer.toString(position));
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
				System.out.println(Integer.toString(position));
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
				System.out.println(Integer.toString(position));
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
				System.out.println(Integer.toString(position));
			}
			break;
		}
			
		default:
			break;
				
		}
		if(GameFrame.this.isEnd())
		{
			JOptionPane optionPane=new JOptionPane();
			optionPane.showMessageDialog(GameFrame.this, "Win!");
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
							//System.out.println(Integer.toString(position));
						}
						break;
					}
			}
		}
		isanswerable();
		}while(GameFrame.this.isEnd()||!GameFrame.this.isanswerable());
	}
	
	
	
	
}
