import java.awt.Color;
import java.awt.Graphics;
public class MyRectangle implements MyObject
{
	private int xc, yc, width,length;
	private Color color;
	private boolean filled=false;
	private boolean selected=false;
	
	MyRectangle(int xcenter, int ycenter, int w, int l, Color col)
	{
		color=col;
		xc=xcenter;
		yc=ycenter;
		width=w;
		length=l;
	}
	public void paint(Graphics g)
	{
		if(filled==false && selected==false)
		{
			g.setColor(color);
			g.drawRect(xc, yc,width ,length);
		}
		if(filled==false && selected==true)
		{
			g.setColor(Color.pink);
			g.drawRect(xc, yc,width ,length);
		}
		if(filled==true && selected==false)
		{
			g.setColor(color);
			g.fillRect(xc, yc, width, length);
		}
		if(filled==true && selected==true)
		{
			g.setColor(Color.pink);
			g.fillRect(xc, yc, width, length);
		}
	}
	
	public int getXC()
	{
		return xc;
	}
	
	public int getYC()
	{
		return yc;
	}
	
	public int getW()
	{
		return width;
	}
	
	public int getL()
	{
		return length;
	}
	public void setFilled()
	{
		filled=true;
	}
	public void setSelected(boolean a)
	{
		selected=a;
	}
	public boolean isSelected()
	{
		return selected;
	}
	public void setColor(Color c)
	{
		color=c;
	}
	public void setXC(int xtr)
	{
		xc=xtr;
	}
	public void setYC(int ytr)
	{
		yc=ytr;
	}
}
