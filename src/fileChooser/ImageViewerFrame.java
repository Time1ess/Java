package fileChooser;


import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewerFrame extends JFrame{

	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=400;
	private JLabel label;
	private JFileChooser chooser;
	
	public ImageViewerFrame()
	{
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu menu=new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem=new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO 自动生成的方法存根
				chooser.setCurrentDirectory(new File("."));
				
				int result=chooser.showOpenDialog(ImageViewerFrame.this);
				
				if(result==JFileChooser.APPROVE_OPTION)
				{
					String name=chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(name));
					pack();
				}
			}
		});
		
		JMenuItem exitItem=new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
			System.exit(0);	
			}
		});
		menu.add(exitItem);
		
		label=new JLabel();
		this.add(label);
		
		chooser=new JFileChooser();
		
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Image Files"
				,"jpg","jpeg","gif");
		chooser.setFileFilter(filter);
		
		chooser.setAccessory(new ImagePreviewer(chooser));
		
		chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				JFrame frame=new ImageViewerFrame();
				frame.setTitle("ImageViewerFrame Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}



