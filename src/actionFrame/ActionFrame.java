package actionFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ActionFrame extends JFrame {

	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH=500;
	private static final int DEFAULT_HEIGHT=500;
	
	public ActionFrame()
	{
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		buttonPanel=new JPanel();
		
		Action yellowAction=new ColorAction("Yellow",new ImageIcon("yellow-ball.gif"),
				Color.YELLOW);
		Action blueAction=new ColorAction("Blue",new ImageIcon("blue-ball.gif"),
				Color.BLUE);
		Action redAction=new ColorAction("Red",new ImageIcon("red-ball.gif"),
				Color.RED);
		
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		this.add(buttonPanel);
		
		InputMap imap=buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		ActionMap amap=buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new ActionFrame();
				frame.setTitle("ActionFrame test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

public class ColorAction extends AbstractAction
{
	public ColorAction(String name,Icon icon,Color c)
	{
		this.putValue(Action.NAME,name);
		this.putValue(Action.SMALL_ICON,icon);
		this.putValue("color",c);
		this.putValue(Action.SHORT_DESCRIPTION,"set background color to "+name.toLowerCase());
	}
	public void actionPerformed(ActionEvent event)
	{
		Color c=(Color)this.getValue("color");
		buttonPanel.setBackground(c);
	}
}

}
