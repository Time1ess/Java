package slider;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SliderFrame extends JFrame{

	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;
	
	public SliderFrame()
	{
		sliderPanel=new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		
		listener=new ChangeListener()
		{
			public void stateChanged(ChangeEvent event)
			{
				JSlider source=(JSlider)event.getSource();
				textField.setText(""+source.getValue());
			}
		};
		
		JSlider slider=new JSlider();
		this.addSlider(slider,"Plain");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		this.addSlider(slider, "Ticks");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		this.addSlider(slider,"Snap to Ticks");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		this.addSlider(slider, "No track");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		this.addSlider(slider,"Inverted");
		
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		this.addSlider(slider,"Labels");
		
		slider=new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		Dictionary<Integer,Component> labelTable=new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		
		slider.setLabelTable(labelTable);
		this.addSlider(slider, "Custom labels");
		
		slider=new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(20);
		
		labelTable=new Hashtable<Integer,Component>();
		labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
		labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
		labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
		labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
		labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
		labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));
		
		slider.setLabelTable(labelTable);
		this.addSlider(slider, "Icon labels");
		
		textField=new JTextField();
		textField.setEnabled(false);
		this.add(sliderPanel,BorderLayout.CENTER);
		this.add(textField,BorderLayout.SOUTH);
		pack();
	}
	
	
	
	
	public void addSlider(JSlider s,String description)
	{
		s.addChangeListener(listener);
		JPanel panel=new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridy=sliderPanel.getComponentCount();
		gbc.anchor=GridBagConstraints.WEST;
		sliderPanel.add(panel,gbc);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new SliderFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("SliderFrame test");
				frame.setVisible(true);
			}
		});
		
	}

}
