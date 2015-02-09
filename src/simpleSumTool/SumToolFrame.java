package simpleSumTool;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SumToolFrame extends JFrame{

	private JPanel sumPanel;
	private JTextField arg1TextField;
	private JTextField arg2TextField;
	private JTextField answerTextField;
	private JButton okButton;
	public SumToolFrame()
	{
		sumPanel=new JPanel();
		sumPanel.setLayout(new GridLayout(1, 5));
		
		arg1TextField=new JTextField("");
		sumPanel.add(arg1TextField);
		
		JButton sumButton=new JButton("+");
		sumPanel.add(sumButton);
		sumButton.setEnabled(false);
		
		arg2TextField=new JTextField("");
		sumPanel.add(arg2TextField);
		
		okButton=new JButton("=");
		sumPanel.add(okButton);
		
		okButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{

				try
				{
				answerTextField.setText(Double.toString(Double.valueOf(arg1TextField.getText())+
						Double.valueOf(arg2TextField.getText())));
				}
				catch(Exception exception){}
			}
		});
		
		answerTextField=new JTextField("");
		sumPanel.add(answerTextField);
		this.add(sumPanel);
		pack();
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame=new SumToolFrame();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("SimpleSumTool Frame");
				frame.setResizable(false);
			}
		});
	}

}
