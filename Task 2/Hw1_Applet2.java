
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Checkbox;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Hw1_Applet2 extends Applet implements MouseListener, MouseMotionListener
{
	private ArrayList<MyObject> objects=new ArrayList<MyObject>();
	private ArrayList<MyObject> selected=new ArrayList<MyObject>();
	Iterator<MyObject> objIterator = objects.iterator();
	private Checkbox checkShape, checkColor, checkOperation;
	private boolean drawPressed=false;
	private boolean showed=false;
	private boolean editPressed=false;
	private boolean editPressed2=false;
	private PopupWindow w=null;
	private int  xc,yc,xcord,ycord,width,length,xsel,ysel, objNr,xtr,ytr;
	private Random r=new Random();

	@Override
    public void init()
    {
		addMouseListener((MouseListener) this); 
		objNr=0;
    }

    @Override
    public void paint (Graphics g)
    {
    	if(showed==true)
    	{
	    	checkShape = w.getShapeName();
	    	checkColor = w.getColorName();
	    	checkOperation=w.getOperationName();
	    	
	    	if(drawPressed==true)
	    	{
	    		g.drawString("button pressed", 10, 60);
	    		width=r.nextInt(100)+20;
	    		length=r.nextInt(180)+20;
	    		xc=(xcord+xcord-width)/2;
	    		yc=(ycord+ycord-length)/2;
	    		objNr++;
    		    
	    		if(checkShape.getLabel()=="Rectangle")
	    		{
	    			String col=checkColor.getLabel();	    			
	    		    if(col=="Red")
	    		    	objects.add(new MyRectangle(xc, yc, width, length, Color.red));
	    		    else
	    		    	if(col=="Blue")
	    		    		objects.add(new MyRectangle(xc, yc, width, length, Color.blue));
	    		    		else
	    		    			if(col=="Green")
	    		    				objects.add(new MyRectangle(xc, yc, width, length, Color.green));		
	    		}
	    		
	    		if(checkShape.getLabel()=="Round Rectangle")
	    		{
	    			String col=checkColor.getLabel();	    
	    		    if(col=="Red")
	    		    	objects.add(new MyRoundRectangle(xc, yc, width, length, Color.red));
	    		    else
	    		    	if(col=="Blue")
	    		    		objects.add(new MyRoundRectangle(xc, yc, width, length, Color.blue));
	    		    		else
	    		    			if(col=="Green")
	    		    				objects.add(new MyRoundRectangle(xc, yc, width, length, Color.green));
	    		}
	    		
	    		if(checkShape.getLabel()=="Ellipse")
	    		{
	    			String col=checkColor.getLabel();	    	
	    		    if(col=="Red")
	    		    	objects.add(new MyEllipse(xc, yc, width, length, Color.red));
	    		    else
	    		    	if(col=="Blue")
	    		    		objects.add(new MyEllipse(xc, yc, width, length, Color.blue));
	    		    		else
	    		    			if(col=="Green")
	    		    				objects.add(new MyEllipse(xc, yc, width, length, Color.green));	    		    
	    		}
	    		
	    	}
	    	if(editPressed==true)
	    	{
	    		g.drawString("Edit button pressed", 10, 80);
	    	}
	    	
	    	for(MyObject o: objects)
	    	{
	    		o.paint(g);
	    	}
	    	if(selected!=null)
	    	{
				for(MyObject o: selected)
				{
				    o.paint(g);
				}
				g.drawString("selected: " + selected.size(), 10 ,140);
	    	}
	    	if(selected==null)
	    		g.drawString("You must select an object", 10, 140);
			drawPressed=false;
	        g.drawString(checkColor.getLabel() + " " + checkShape.getLabel() + " is selected", 10 ,20);
	        g.drawString(checkOperation.getLabel() + " is selected", 10 ,40);
	        g.drawString("objects: " + objects.size(), 10 ,120);
	        g.drawString("Total Objects: " + objNr, 10 ,100);
    	}
    }
    
    
    @Override
	public void mousePressed(MouseEvent me)
    {
    	
    	if(drawPressed==true && showed==true)
    	{
    		xcord=me.getX();
    		ycord=me.getY();
    		repaint();
    	}
    	if(editPressed==true && showed==true)
    	{
    		if(editPressed2==false)
    		{
    			xsel=me.getX();
    			ysel=me.getY();
    			selected=selectShapes(xsel, ysel);
    			repaint();
    			if(selected==null)
	    		{
	    			editPressed=false;
	    			editPressed2=false;
	    		}
    		}
    		if(editPressed2==true )
	    	{
    			checkOperation=w.getOperationName();
	    		if(checkOperation.getLabel()=="Fill" && selected!=null)
	    		{
	    			fillShapes();
	    		}
	    		if(checkOperation.getLabel()=="Delete" && selected!=null)
	    		{
	    			deleteShapes();
	    		}
	    		
	    		repaint();

	    	}
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

	@Override
	public void mouseReleased(MouseEvent me) 
	{
		if(editPressed2==true)
		{
		xtr=me.getX();
		ytr=me.getY();
		}
		if(editPressed==true && showed==true && editPressed2==true && checkOperation.getLabel()=="Translate")
    	{
			translateShapes(xtr, ytr);
			repaint();
    	}
	}
	
	
	public ArrayList<MyObject> selectShapes(int xsel, int ysel)
	{
		int nr=objNr;
		ArrayList<MyObject> sel = new ArrayList<MyObject>();
		for(int i=0;i<nr;i++)
		{
			MyObject o = objects.get(i);
			int wobj=o.getW();
			int lobj=o.getL();
			int xobj=o.getXC()+wobj/2;
			int yobj=o.getYC()+lobj/2;
			
			if(xsel>=xobj-wobj/2 && xsel <=xobj+wobj/2 && ysel>=yobj-lobj/2 && ysel<=yobj+lobj/2)
			{
				o.setSelected(true);
				sel.add(o);
				objects.remove(o);
				nr--;
				i--;
			}
		}
		if(sel.size()!=0)
			return sel;
		return null;
	}
	
	public void fillShapes()
	{	
		Iterator<MyObject> selIterator = selected.iterator();
		while(selIterator.hasNext())
		{	
			MyObject o=selIterator.next();
			checkColor = w.getColorName();
			if(checkColor.getLabel()=="Red")
				o.setColor(Color.red);
				else
					if(checkColor.getLabel()=="Blue")
						o.setColor(Color.blue);
					else
						if(checkColor.getLabel()=="Green")
							o.setColor(Color.green);
			o.setFilled();
			o.setSelected(false);
			objects.add(o);		
			selIterator.remove();
			
		}
		editPressed=false;
		editPressed2=false;
	}
	
	public void deleteShapes()
	{
		Iterator<MyObject> selIterator = selected.iterator();
		while(selIterator.hasNext())
		{
			MyObject o=selIterator.next();
			o.setSelected(false);
			selIterator.remove();
			objNr--;
		}
		editPressed=false;
		editPressed2=false;
	}
	
	public void translateShapes(int xtr,int ytr)
	{
		Iterator<MyObject> selIterator = selected.iterator();
		while(selIterator.hasNext())
		{
			MyObject o = selIterator.next();
			o.setXC(xtr-o.getW()/2);
			o.setYC(ytr-o.getL()/2);	

			o.setSelected(false);
			objects.add(o);		
			selIterator.remove();
		}
		editPressed=false;
		editPressed2=false;
		
	}
	
	public void setDrawPressed()
	{
		drawPressed=true;
	}
	
	public void setEditPressed()
	{
		
		if(editPressed==true)
		{
			editPressed2=true;
		}
		editPressed=true;
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
	public void mouseDragged(MouseEvent me) 
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent me) 
	{
		
	}
}
