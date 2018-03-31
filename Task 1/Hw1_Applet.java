import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Checkbox;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class Hw1_Applet extends Applet implements MouseListener, MouseMotionListener
{
	private boolean pressed=false;
	private boolean showed=false;
	private PopupWindow w=null;
	private int  xc,yc,xcord,ycord,width,length;
	private Random r=new Random();

	@Override
    public void init()
    {
		addMouseListener((MouseListener) this); 
    }

    @Override
    public void paint (Graphics g)
    {
    	if(showed==true)
    	{
	    	Checkbox checkShape = w.getShapeName();
	    	Checkbox checkColor = w.getColorName();
	    	
	    	if(pressed==true)
	    	{
	    		g.drawString("button pressed", 10, 40);
	    		
	    		width=r.nextInt(120)+20;
	    		length=r.nextInt(180)+20;
	    		xc=(xcord+xcord-width)/2;
    		    yc=(ycord+ycord-length)/2;
    		    
	    		if(checkShape.getLabel()=="Rectangle")
	    		{
	    			String col=checkColor.getLabel();
	    			
	    		    if(col=="Red")
	    		    	g.setColor(Color.red);
	    		    else
	    		    	if(col=="Blue")
	    		    		g.setColor(Color.blue);
	    		    		else
	    		    			if(col=="Green")
	    		    				g.setColor(Color.green);
	    			g.drawRect(xc, yc,width,length);
	    		}
	    		
	    		if(checkShape.getLabel()=="Round Rectangle")
	    		{
	    			String col=checkColor.getLabel();
	    
	    		    if(col=="Red")
	    		    	g.setColor(Color.red);
	    		    else
	    		    	if(col=="Blue")
	    		    		g.setColor(Color.blue);
	    		    		else
	    		    			if(col=="Green")
	    		    				g.setColor(Color.green);
	    			g.drawRoundRect(xc, yc, width,length, 40, 40);
		
	    		}
	    		
	    		if(checkShape.getLabel()=="Ellipse")
	    		{
	    			String col=checkColor.getLabel();
	    	
	    		    if(col=="Red")
	    		    	g.setColor(Color.red);
	    		    else
	    		    	if(col=="Blue")
	    		    		g.setColor(Color.blue);
	    		    		else
	    		    			if(col=="Green")
	    		    				g.setColor(Color.green);
	    			g.drawOval(xc, yc, width,length);
	    		}
	    	}
	    		    	
	    	pressed=false;
	        g.drawString(checkColor.getLabel() + " " + checkShape.getLabel() + " is selected", 10 ,20);
    	}
    }
    
    
    @Override
	public void mousePressed(MouseEvent me)
    {
    	
    	if(pressed==true && showed==true)
    	{
    		xcord=me.getX();
    		ycord=me.getY();
    		repaint();
    	}
    	
	}
    

	@Override
	public void mouseClicked(MouseEvent me) 
	{	
		if(showed==false && me.getButton()==3)
		{
			showed=true;
			w=new PopupWindow();
			w.setCanvas(this);
			repaint();
		}
	}

	
	public void setPressed()
	{
		pressed=true;
	}
	
	
	public boolean getShowed()
	{
		return showed;
	}
	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
