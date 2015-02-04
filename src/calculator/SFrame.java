package calculator;

import javax.swing.*;

public class SFrame extends JFrame{

	public SFrame()
	{
		this.add(new CalculatorPanel());
		pack();
	}
}
