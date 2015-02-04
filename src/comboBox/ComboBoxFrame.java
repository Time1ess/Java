package comboBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ComboBoxFrame extends JFrame{

	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEFAULT_SIZE=24;
	
	public ComboBoxFrame()
	{
		label=new JLabel("Hello World!",SwingConstants.CENTER);
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		label.setBorder(BorderFactory.createEtchedBorder());
		this.add(label,BorderLayout.CENTER);
		
		faceCombo=new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		
		faceCombo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
						Font.PLAIN,DEFAULT_SIZE));
			}
		});
		
		JPanel comboPanel=new JPanel();
		comboPanel.add(faceCombo);
		this.add(comboPanel,BorderLayout.SOUTH);
		pack();
		this.setSize(this.getWidth()+100, this.getHeight());
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new ComboBoxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("ComboBoxFrame text");
				frame.setVisible(true);
			}
		});
	}

}
