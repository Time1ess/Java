package ChapSix;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimePrinter implements ActionListener {

	public void actionPerformed(ActionEvent event)
	{
		Date now=new Date();
		System.out.println("At the tone,the time is"+now);
		Toolkit.getDefaultToolkit().beep();
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(1000,listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit prgram?");
		System.exit(0);
	}

}
