package dataExchange;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordChooser extends JPanel
{
	private JTextField username;
	private JPasswordField password;
	private JButton okButton;
	private boolean ok;
	private JDialog dialog;
	
	public PasswordChooser()
	{
		this.setLayout(new BorderLayout());
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("User Name"));
		panel.add(username=new JTextField(""));
		panel.add(new JLabel("Password:"));
		panel.add(password=new JPasswordField());
		this.add(panel, BorderLayout.CENTER);
		
		okButton=new JButton("Ok");
		okButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				ok=true;
				dialog.setVisible(false);
			}
		});
		JButton cancelButton=new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				dialog.setVisible(false);
			}
		});
		
		JPanel buttonPanel=new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void setUser(User u)
	{
		username.setText(u.getName());
	}
	
	public User getUser()
	{
		return new User(username.getText(), password.getPassword());
	}
	
	public boolean showDialog(Component parent,String title)
	{
		ok=false;
		
		Frame owner=null;
		if(parent instanceof Frame)owner=(Frame)parent;
		else owner=(Frame)SwingUtilities.getAncestorOfClass(Frame.class, parent);
		
		if(dialog==null||dialog.getOwner()!=owner)
		{
			dialog=new JDialog(owner,true);
			dialog.add(this);
			dialog.getRootPane().setDefaultButton(okButton);
			dialog.pack();
		}
		
		dialog.setTitle(title);
		dialog.setVisible(true);
		return ok;
	}
}
