import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/**
 * 
 * @author breadman22
 *
 */
public class Ball extends JComponent
{
	private Ellipse2D.Double circle;
	private int dx, dy;
	
	public Ball(int x, int y, int d)
	{
		circle = new Ellipse2D.Double(0,0,d,d);
		setSize(d+1,d+1);
		setLocation(x,y);
		
		dx = 0;
		dy = 0;
	}
	
	public void setDx(int x)
	{
		dx = x;
	}
	public void setDy(int y)
	{
		dy = y;
	}
	public void update()
	{
		setLocation(getX()+dx, getY()+dy);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.WHITE);
		g2.fill(circle);
	}
	public void reset(int x, int y)
	{
		setLocation(x,y);
		dx=0;
		dy=0;
	}
}
