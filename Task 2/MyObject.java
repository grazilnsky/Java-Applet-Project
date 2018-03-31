import java.awt.Color;
import java.awt.Graphics;
public interface MyObject {
	public void paint(Graphics g);
	public int getXC();
	public int getYC();
	public int getW();
	public int getL();
	public void setSelected(boolean a);
	public boolean isSelected();
	public void setFilled();
	public void setColor(Color c);
	public void setXC(int xtr);
	public void setYC(int ytr);
}
