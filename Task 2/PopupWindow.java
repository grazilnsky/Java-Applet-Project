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
	private CheckboxGroup operations = null;
	private Checkbox rectangle, roundRectangle, ellipse, red, blue, green, fill, delete, translate;
	private Button draw=null;
	private Button edit=null;
	private Frame win;
	private Label name1, name2, name3;
	private Hw1_Applet2 canvas;
	PopupWindow()
	{
		win=new Frame();
		
		draw = new Button("Draw Shape");
	    draw.setBounds(50,40,100,30);
	    draw.addActionListener(this);
	    
	    edit = new Button("Edit Shape");
	    edit.setBounds(50, 80, 100, 30);
	    edit.addActionListener(this);
	    
	    
	    name1=new Label("Shapes");
	    name1.setBounds(50, 120, 50, 20);	    
	    shapes = new CheckboxGroup();
	    rectangle = new Checkbox("Rectangle", shapes, true);
	    rectangle.setBounds(50, 140, 110, 20);
	    roundRectangle = new Checkbox("Round Rectangle", shapes, false);
	    roundRectangle.setBounds(50, 160, 150, 20);
	    ellipse = new Checkbox("Ellipse", shapes, false);
	    ellipse.setBounds(50, 180, 110, 20);
	    
	    rectangle.addItemListener((ItemListener) this);
	    roundRectangle.addItemListener((ItemListener) this);
	    ellipse.addItemListener((ItemListener) this);
	      
	    
	    name2=new Label("Colors");
	    name2.setBounds(50, 200, 50, 20);	    
	    colors = new CheckboxGroup(); 
	    red = new Checkbox("Red", colors, true);
	    red.setBounds(50, 220, 110, 20);
	    blue = new Checkbox("Blue", colors, false);
	    blue.setBounds(50, 240, 110, 20);
	    green = new Checkbox("Green", colors, false);
	    green.setBounds(50, 260, 110, 20);
	    
	    red.addItemListener((ItemListener) this);
	    blue.addItemListener((ItemListener) this);
	    green.addItemListener((ItemListener) this);
	    
	    
	    name3=new Label("Operations");
	    name3.setBounds(50, 280, 80, 20);
	    operations = new CheckboxGroup();
	    fill=new Checkbox("Fill", operations, true);
	    fill.setBounds(50, 300, 110, 20);
	    delete=new Checkbox("Delete", operations, false);
	    delete.setBounds(50, 320, 110, 20);
	    translate=new Checkbox("Translate", operations, false);
	    translate.setBounds(50, 340, 110, 20);
	    
	    fill.addItemListener((ItemListener) this);
	    delete.addItemListener((ItemListener) this);
	    translate.addItemListener((ItemListener) this);
	    
	    win.setLayout(null);
	    win.add(draw);
	    win.add(edit);
	    win.add(name1);
	    win.add(rectangle);
	    win.add(roundRectangle);
	    win.add(ellipse);
	    win.add(name2);
	    win.add(red); 
	    win.add(blue);
	    win.add(green);
	    win.add(name3);
	    win.add(fill);
	    win.add(delete);
	    win.add(translate);
	    win.setVisible(true);
	    win.setSize(200,400);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==draw)
			canvas.setDrawPressed();
		if (e.getSource()==edit)
			canvas.setEditPressed();
	}

	public Checkbox getShapeName()
	{
		return shapes.getSelectedCheckbox();
	}
	
	public Checkbox getColorName()
	{
		return colors.getSelectedCheckbox();
	}
	public void setCanvas(Hw1_Applet2 a)
	{
		this.canvas=a;
	}
	public Checkbox getOperationName()
	{
		return operations.getSelectedCheckbox();
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(canvas.getShowed()==true)
			canvas.repaint();	
	}
}
