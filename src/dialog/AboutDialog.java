package dialog;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AboutDialog extends JDialog{

	public AboutDialog(JFrame owner)
	{
		super(owner,"About DialogTest",true);
		this.add(new JLabel("Hello World",SwingConstants.CENTER),BorderLayout.CENTER);
		JButton ok=new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				AboutDialog.this.setVisible(false);
			}
		});
		JPanel panel=new JPanel();
		panel.add(ok);
		this.add(panel, BorderLayout.SOUTH);
		pack();
	}
}
