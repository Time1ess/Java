package mineSweeper;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MainFrame extends JFrame
{
	private JPanel minePanel;
	private JPanel settingPanel;
	private int mineNumber;
	private int mineSize;
	ArrayList<JButton> mines;
	ArrayList<Integer> minemap;
	public MainFrame()
	{
		settingPanel=new JPanel();
		settingPanel.setLayout(new GridLayout(2, 2));
		settingPanel.add(new JLabel("地雷个数"));
		final JTextField mineNumberField=new JTextField();
		settingPanel.add(mineNumberField);
		settingPanel.add(new JLabel("雷区大小"));
		final JTextField mineSizeField=new JTextField();
		settingPanel.add(mineSizeField);
		final JButton okButton=new JButton("OK");
		okButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						mineNumber=Integer.valueOf(mineNumberField.getText());
						mineSize=Integer.valueOf(mineSizeField.getText());
						if(mineNumber<0||mineSize*mineSize<mineNumber||mineSize>12)throw new Exception("err");
						System.out.println(mineNumber+"  "+mineSize);
						MainFrame.this.remove(settingPanel);
						MainFrame.this.remove(okButton);
						MainFrame.this.game();
					} catch (Exception e2)
					{
						// TODO: handle exception
					}
				}
			});
		this.add(settingPanel,BorderLayout.CENTER);
		this.add(okButton, BorderLayout.SOUTH);
		pack();
	}
	
	void game()
	{
		MainFrame.this.repaint();
		minePanel=new JPanel();
		minePanel.setLayout(new GridLayout(mineSize, mineSize));
		//MineListener listener=new MineListener();
		MouseListener listener2=new FindMineListener();
		Random rand=new Random();
		mines=new ArrayList<JButton>();
		minemap=new ArrayList<Integer>();
		for(int i=0;i<mineSize*mineSize;i++)
			{
				mines.add(new JButton());
				mines.get(i).setActionCommand(Integer.toString(i));
				//mines.get(i).addActionListener(listener);
				mines.get(i).addMouseListener(listener2);
				minePanel.add(mines.get(i));
			}
		int p;
		for(int i=0;i<mineNumber;i++)
		{
			while(true)
			if(!minemap.contains((p=rand.nextInt(mineSize*mineSize))))
			{
				minemap.add(p);
				break;
			}
		}
		for(int x:minemap)
			System.out.print(x+" ");
		this.add(minePanel);
		this.setSize(mineSize*60, mineSize*60);
	}
	
	class FindMineListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent event)
		{
			JButton button=(JButton)event.getSource();
			if(event.getButton()!=MouseEvent.BUTTON3)
			{
				if(minemap.contains(Integer.valueOf(button.getActionCommand())))
				{
					if(button.getText()!="*")
					{
						JOptionPane optionpane=new JOptionPane();
						optionpane.showMessageDialog(MainFrame.this, "Game Over!");
						System.exit(0);
					}
				}
				else
				{
					setbutton(button);
				}
			}
			else
			{
				if(button.getText()=="*")
						button.setText("");
				else
						button.setText("*");
				int i;
				for(i=0;i<mineSize*mineSize;i++)
				{
					if((minemap.contains(i)&&mines.get(i).getText()=="*")
							||(!minemap.contains(i)&&mines.get(i).getText()!="*"))
						continue;
					break;
				}
				if(i==mineSize*mineSize)
				{
					JOptionPane optionpane=new JOptionPane();
					optionpane.showMessageDialog(MainFrame.this, "Win!");
					System.exit(0);
				}
			}
		}
	}
	
	int minecount(int key)
	{
		int minecount=0;
		if(minemap.contains(key-1)&&key%mineSize!=0)minecount++;
		if(minemap.contains(key+1)&&(key+1)%mineSize!=0)minecount++;
		if(minemap.contains(key-5)&&(key-mineSize+1)>0)minecount++;
		if(minemap.contains(key+5)&&key<(mineSize*(mineSize-1)))minecount++;
		if(minemap.contains(key-6)&&key%mineSize!=0&&(key-mineSize+1)>0)minecount++;
		if(minemap.contains(key+6)&&key<(mineSize*(mineSize-1))&&(key+1)%mineSize!=0)minecount++;
		if(minemap.contains(key-4)&&key<(mineSize*(mineSize-1))&&(key+1)%mineSize!=0)minecount++;
		if(minemap.contains(key+4)&&key%mineSize!=0&&key<(mineSize*(mineSize-1)))minecount++;
		return minecount;
	}
	
	void setbutton(JButton button)
	{
		button.setEnabled(false);
		int key=Integer.valueOf(button.getActionCommand());
		mines.get(key).setText(Integer.toString(minecount(key)));
	}
	
	public static void main(String[] args)
	{
		JFrame frame=new MainFrame();
		frame.setTitle("MineSweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(300, 150);
	}

}
