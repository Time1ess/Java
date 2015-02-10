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
	private static final int SIZE=4;
	ArrayList<JButton> squares;
	public GameFrame()
	{
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
			gamePanel.add(squares.get(i));
		}
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
			if(key%4!=0&&squares.get(key-1).getText()=="")
			{
				//squares.get(key-1).setActionCommand(squares.get(key).getActionCommand());
				//squares.get(key).setActionCommand("");
				squares.get(key-1).setText(squares.get(key).getText());
				squares.get(key).setText("");
				//System.out.print(" blank right move");
			}
			else if((key+1)%SIZE!=0&&squares.get(key+1).getText()=="")
			{
				//squares.get(key+1).setActionCommand(squares.get(key).getActionCommand());
				//squares.get(key).setActionCommand("");
				squares.get(key+1).setText(squares.get(key).getText());
				squares.get(key).setText("");
				//System.out.print(" blank left move");
			}
			else if(key>SIZE-1&&squares.get(key-SIZE).getText()=="")
			{
				//squares.get(key-4).setActionCommand(squares.get(key).getActionCommand());
				//squares.get(key).setActionCommand("");
				squares.get(key-SIZE).setText(squares.get(key).getText());
				squares.get(key).setText("");
				//System.out.print(" blank down move");
			}
			else if(key<SIZE*(SIZE-1)&&squares.get(key+SIZE).getText()=="")
			{
				//squares.get(key+4).setActionCommand(squares.get(key).getActionCommand());
				//squares.get(key).setActionCommand("");
				squares.get(key+SIZE).setText(squares.get(key).getText());
				squares.get(key).setText("");
				//System.out.print(" blank up move");
			}
			else 
			{
				//System.out.print(" failed");
			}
			}
			catch(Exception e){
				//System.out.println(e.getMessage());
				}
			//GameFrame.this.repaint();
			
			if(GameFrame.this.isEnd())
			{
				JOptionPane optionPane=new JOptionPane();
				optionPane.showMessageDialog(GameFrame.this, "Win!");
				GameFrame.this.Reset();
			}
		}
	}
	
	boolean isEnd()
	{
		int minus=1;
		int i;
		for(i=0;i<SIZE*SIZE;i++)
		{
			if(squares.get(i).getText()=="")
				{
					minus=0;
					continue;
				}
			if(Integer.valueOf(squares.get(i).getText())-minus==i)continue;
			break;
		}
		if(i==SIZE*SIZE)return true;
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
						if(p!=SIZE*SIZE){
							squares.get(i).setText(Integer.toString(p));
//							squares.get(i).setActionCommand(Integer.toString(p));
						}
						break;
					}
			}
		}
		}while(GameFrame.this.isEnd());
	}
}
