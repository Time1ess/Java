package swingTextInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextComponentFrame extends JFrame{

	public static final int TEXTAREA_ROWS=8;
	public static final int TEXTAREA_COLUMNS=20;
	
	public TextComponentFrame()
	{
		final JTextField textField=new JTextField();
		final JPasswordField passwordField=new JPasswordField();
		
		JPanel northPanel=new JPanel();
		northPanel.setLayout(new GridLayout(2,2));
		northPanel.add(new JLabel("User Name: ",SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password: ",SwingConstants.RIGHT));
		northPanel.add(passwordField);
		
		this.add(northPanel,BorderLayout.NORTH);
		
		final JTextArea textArea=new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);
		textArea.setEnabled(false);
		JScrollPane scrollPane=new JScrollPane(textArea);
		
		this.add(scrollPane,BorderLayout.CENTER);
		
		JPanel southPanel=new JPanel();
		
		JButton insertButton=new JButton("Insert");
		southPanel.add(insertButton);
		insertButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						textArea.append("User name: "+textField.getText()+
								"\nPassword: "+new String(passwordField.getPassword())+"\n");
					}
				});
		
		this.add(southPanel,BorderLayout.SOUTH);
		pack();
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new TextComponentFrame();
				frame.setTitle("Text Input Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500,500);
				frame.setVisible(true);
				
			}
		});
	}

}
