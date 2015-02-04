package gridbag;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;

import javax.swing.*;


public class FontFrame extends JFrame{

	public static final int TEXT_ROWS=10;
	public static final int TEXT_COLUMNS=20;
	private JComboBox<String> face;
	private JComboBox<Integer> size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea sample;
	
	public FontFrame()
	{
		GridBagLayout layout=new GridBagLayout();
		this.setLayout(layout);
		
		ActionListener listener=EventHandler.create(ActionListener.class, this, "updateSample");
		
		
		JLabel faceLabel=new JLabel("Face: ");
		face=new JComboBox<>(new String[]{"Serif","SansSerif","Monospaced","Dialog","DialogInput"});
		face.addActionListener(listener);
		
		JLabel sizeLabel=new JLabel("Size: ");		
		size=new JComboBox<>(new Integer[]{8,10,12,15,18,24,36,48});
		size.addActionListener(listener);
		
		bold=new JCheckBox("Bold");
		bold.addActionListener(listener);
		
		italic=new JCheckBox("Italic");
		italic.addActionListener(listener);
		
		sample=new JTextArea(TEXT_ROWS,TEXT_COLUMNS);
		sample.setText("Hello World!");
		sample.setEditable(false);
		sample.setLineWrap(true);
		sample.setBorder(BorderFactory.createEtchedBorder());
		
		this.add(faceLabel,new GBC(0,0).setAnchor(GBC.EAST));
		this.add(face,new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		this.add(sizeLabel, new GBC(0,1).setAnchor(GBC.EAST));
		this.add(size,new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		this.add(bold,new GBC(0,2,2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		this.add(italic, new GBC(0,3,2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		this.add(sample, new GBC(2,0,1,4).setFill(GBC.BOTH).setWeight(100, 100));
		
		pack();
		updateSample();
	}
	
	public void updateSample()
	{
		String fontFace=(String)face.getSelectedItem();
		int fontStyle=(bold.isSelected()?Font.BOLD:0)+(italic.isSelected()?Font.ITALIC:0);
		int fontSize=size.getItemAt(size.getSelectedIndex());
		Font font=new Font(fontFace,fontStyle,fontSize);
		sample.setFont(font);
		sample.repaint();
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame=new FontFrame();
				frame.setTitle("FontFrame test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}

}
