import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class DottedLine extends JComponent
{
	private Rectangle line;
	private ArrayList<Rectangle> dots;
	
	public DottedLine()
	{
		dots = new ArrayList<Rectangle>();
		int y = 0;
		while(!(y>480))
		{
			dots.add(new Rectangle(0,y,2,10));
			y+=20;
		}
		
		setSize(3,500);
		setLocation(350,0);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		for(int i = 0; i<dots.size(); i++)
		{
			g2.fill(dots.get(i));
		}
	}
}
