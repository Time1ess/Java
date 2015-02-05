package dialog;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogFrame extends JFrame{

	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;
	private AboutDialog dialog;
	public DialogFrame()
	{
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu fileMenu=new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem aboutItem=new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(dialog==null)
					dialog=new AboutDialog(DialogFrame.this);
				dialog.setVisible(true);
			}
		});
		fileMenu.add(aboutItem);
		
		JMenuItem exitItem=new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
		});
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				JFrame frame=new DialogFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("DialogFrame Test");
				frame.setVisible(true);
			}
		});
	}

}
