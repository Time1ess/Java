package dataExchange;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class DataExchangeFrame extends JFrame{

	public static final int TEXT_ROWS=20;
	public static final int TEXT_COLUMNS=40;
	private PasswordChooser dialog=null;
	private JTextArea textArea;
	
	public DataExchangeFrame()
	{
		JMenuBar mbar=new JMenuBar();
		this.setJMenuBar(mbar);
		JMenu fileMenu=new JMenu("File");
		mbar.add(fileMenu);
		
		JMenuItem connectItem=new JMenuItem("Connect");
		connectItem.addActionListener(new ConnectAction());
		fileMenu.add(connectItem);
		
		JMenuItem exitItem=new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
		
		textArea=new JTextArea(TEXT_ROWS,TEXT_COLUMNS);
		this.add(new JScrollPane(textArea),BorderLayout.CENTER);
		textArea.setEditable(false);
		pack();
	}
	
	private class ConnectAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(dialog==null)dialog=new PasswordChooser();
			
			dialog.setUser(new User("yourname", null));
			
			if(dialog.showDialog(DataExchangeFrame.this, "Connect"))
			{
				User u=dialog.getUser();
				textArea.append("user name = "+u.getName()+", password = "+
				new String(u.getPassword())+"\n");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				JFrame frame=new DataExchangeFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("DataExchangeFrame Test");
				frame.setVisible(true);
			}
		});
	}

}
