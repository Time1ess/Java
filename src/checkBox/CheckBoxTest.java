package checkBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxTest {

	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new CheckBoxFrame();
				frame.setTitle("CheckBox Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
