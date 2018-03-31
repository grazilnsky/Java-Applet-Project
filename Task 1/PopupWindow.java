import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class PopupWindow extends Frame implements ActionListener, ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CheckboxGroup shapes = null;
	private CheckboxGroup colors = null;
	private Checkbox rectangle, roundRectangle, ellipse, red, blue, green;
	private Button draw=null;
	private Frame win;
	private Label name1, name2;
	private Hw1_Applet canvas;
	PopupWindow()
	{
		win=new Frame();
		
		draw = new Button("Draw Shape");
	    draw.setBounds(50,40,100,30);
	    draw.addActionListener(this);
	     
	    name1=new Label("Shapes");
	    name1.setBounds(50, 80, 50, 20);	    
	    shapes = new CheckboxGroup();
	    rectangle = new Checkbox("Rectangle", shapes, true);
	    rectangle.setBounds(50, 100, 110, 20);
	    roundRectangle = new Checkbox("Round Rectangle", shapes, false);
	    roundRectangle.setBounds(50, 120, 110, 20);
	    ellipse = new Checkbox("Ellipse", shapes, false);
	    ellipse.setBounds(50, 140, 110, 20);
	    
	    rectangle.addItemListener((ItemListener) this);
	    roundRectangle.addItemListener((ItemListener) this);
	    ellipse.addItemListener((ItemListener) this);
	      
	    
	    name2=new Label("Colors");
	    name2.setBounds(50, 160, 50, 20);	    
	    colors = new CheckboxGroup(); 
	    red = new Checkbox("Red", colors, true);
	    red.setBounds(50, 180, 110, 20);
	    blue = new Checkbox("Blue", colors, false);
	    blue.setBounds(50, 200, 110, 20);
	    green = new Checkbox("Green", colors, false);
	    green.setBounds(50, 220, 110, 20);
	    
	    red.addItemListener((ItemListener) this);
	    blue.addItemListener((ItemListener) this);
	    green.addItemListener((ItemListener) this);
	    
	    
	    win.setLayout(null);
	    win.add(draw);
	    win.add(name1);
	    win.add(rectangle);
	    win.add(roundRectangle);
	    win.add(ellipse);
	    win.add(name2);
	    win.add(red); 
	    win.add(blue);
	    win.add(green);
	    win.setVisible(true);
	    win.setSize(200,300);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		canvas.setPressed();
	}

	public Checkbox getShapeName()
	{
		return shapes.getSelectedCheckbox();
	}
	
	public Checkbox getColorName()
	{
		return colors.getSelectedCheckbox();
	}
	public void setCanvas(Hw1_Applet a)
	{
		this.canvas=a;
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(canvas.getShowed()==true)
			canvas.repaint();	
	}
}
