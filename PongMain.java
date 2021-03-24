import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * 
 * @author breadman22
 *
 */
public class PongMain extends JFrame implements ActionListener
{
	private Paddle pad1 = new Paddle(25,200);
	private Paddle pad2 = new Paddle(650, 200);
	private Ball ball = new Ball(350,(int)(Math.random()*400+50),10);
	
	public PongMain()
	{
		setBounds(200,200,700,500);
		setTitle("Pong");
		setLayout(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.BLACK);
		
		add(pad1);
		add(pad2);
		add(ball);
		
		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_A)
					dodgeman1.setDx(-5);
				else if(e.getKeyCode() == e.VK_D)
					dodgeman1.setDx(5);
				else if(e.getKeyCode() == e.VK_W)
					dodgeman1.setDy(-5);
				else if(e.getKeyCode() == e.VK_S)
					dodgeman1.setDy(5);
				
				if(dodgeman1.getY() < 0 || dodgeman1.getY() > getHeight())
					dodgeman1.setDy(0);
				if(dodgeman1.getX() < 0 || dodgeman1.getX() > getWidth())
					dodgeman1.setDx(0);
				
				if(e.getKeyCode() == e.VK_SPACE)
				{
				}
					
				if(e.getKeyCode() == e.VK_LEFT)
					dodgeman2.setDx(-5);
				else if(e.getKeyCode() == e.VK_RIGHT)
					dodgeman2.setDx(5);
				else if(e.getKeyCode() == e.VK_UP)
					dodgeman2.setDy(-5);
				else if(e.getKeyCode() == e.VK_DOWN)
					dodgeman2.setDy(5);
				
				if(dodgeman2.getY() < 0 || dodgeman2.getY() > getHeight())
					dodgeman2.setDy(0);
				if(dodgeman2.getX() < 0 || dodgeman2.getX() > getWidth())
					dodgeman2.setDx(0);
				
				if(e.getKeyCode() == e.VK_ENTER)
				{
				}
			}
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_UP)
					dodgeman2.setDy(0);
				else if(e.getKeyCode() == e.VK_DOWN)
					dodgeman2.setDy(0);
				
				if(e.getKeyCode() == e.VK_W)
					dodgeman1.setDy(0);
				else if(e.getKeyCode() == e.VK_S)
					dodgeman1.setDy(0);
			}
			public void keyTyped(KeyEvent e) {
			}});
		
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		new PongMain();
	}

	public void actionPerformed(ActionEvent arg0) 
	{
	}
}
