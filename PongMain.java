import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

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
	private Insets inset;
	private int score1, score2, lastScored;
	private JLabel lbl1,lbl2;
	
	public PongMain()
	{
		setBounds(200,200,700,500);
		setTitle("Pong");
		setLayout(null);
		setResizable(false);
		this.getContentPane().setBackground(Color.BLACK);
		
		score1 = 0;
		score2 = 0;
		lastScored = 1;
		
		lbl1 = new JLabel(String.valueOf(score1));
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Serif", Font.BOLD, 50));
		lbl1.setBounds(150,40,50,50);
		add(lbl1);
		
		lbl2 = new JLabel(String.valueOf(score2));
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Serif", Font.BOLD, 50));
		lbl2.setBounds(500,40,50,50);
		add(lbl2);
		
		pad1 = new Paddle(25,200);
		pad2 = new Paddle(650, 200);
		ball = new Ball(350,(int)(Math.random()*400+50),10);
		
		inset = getInsets();
		inset.set(0, 0, 500, 700);
		
		Timer t1 = new Timer(10,this);
		t1.start();
		
		add(pad1);
		add(pad2);
		add(ball);
		
		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_W)
					pad1.setDy(-5);
				else if(e.getKeyCode() == e.VK_S)
					pad1.setDy(5);
				
				if(pad1.getY() < inset.top || pad1.getY() + pad1.getHeight() > inset.bottom)
					pad1.setDy(0);
					
				if(e.getKeyCode() == e.VK_UP)
					pad2.setDy(-5);
				else if(e.getKeyCode() == e.VK_DOWN)
					pad2.setDy(5);
				
				if(pad2.getY() < inset.top || pad2.getY() + pad2.getHeight() > inset.bottom)
					pad2.setDy(0);
				
				if(e.getKeyCode() == e.VK_SPACE)
				{
					if(lastScored == 1)
						ball.setDx(5);
					else if(lastScored == 2)
						ball.setDx(-5);
					ball.setDy(-5);
				}
			}
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_UP)
					pad2.setDy(0);
				else if(e.getKeyCode() == e.VK_DOWN)
					pad2.setDy(0);
				
				if(e.getKeyCode() == e.VK_W)
					pad1.setDy(0);
				else if(e.getKeyCode() == e.VK_S)
					pad1.setDy(0);
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
		if(pad1.getY() < inset.top)
			pad1.setLocation(pad1.getX(), inset.top);
		if(pad1.getY() + pad1.getHeight() > inset.bottom)
			pad1.setLocation(pad1.getX(),inset.bottom - pad1.getHeight());
		
		if(pad2.getY() < inset.top)
			pad2.setLocation(pad2.getX(), inset.top);
		if(pad2.getY() + pad2.getHeight() > inset.bottom)
			pad2.setLocation(pad2.getX(),inset.bottom - pad2.getHeight());
		
		if(ball.getY() <= 0)
			ball.setDy(5);
		if(ball.getY() + ball.getHeight() + 40 >= this.getHeight())
			ball.setDy(-5);

		if(ball.getX() <= pad1.getX()+pad1.getWidth()
		&& ball.getY()+ball.getHeight() > pad1.getY()
		&& ball.getY() < pad1.getY()+pad1.getHeight()
		&& ball.getX() >= pad1.getX())
			ball.setDx(5);
		if(ball.getX()+ball.getWidth() >= pad2.getX() 
		&& ball.getY()+ball.getHeight() > pad2.getY()
		&& ball.getY() < pad2.getY()+pad2.getHeight()
		&& ball.getX() <= pad2.getX() + pad2.getWidth())
			ball.setDx(-5);
		
		if(ball.getX()+ball.getWidth()<=inset.left)
		{
			ball.reset(350,(int)(Math.random()*400+50));
			score2++;
			lbl2.setText(String.valueOf(score2));
			lastScored=2;
			if(lastScored == 1)
				ball.setDx(5);
			else if(lastScored == 2)
				ball.setDx(-5);
			ball.setDy(-5);
		}
		if(ball.getX()>=inset.right)
		{
			ball.reset(350,(int)(Math.random()*400+50));
			score1++;
			lbl1.setText(String.valueOf(score1));
			lastScored=1;
			if(lastScored == 1)
				ball.setDx(5);
			else if(lastScored == 2)
				ball.setDx(-5);
			ball.setDy(-5);
		}
		
		if(score1==10)
		{
			score1=0;
			score2=0;
			JOptionPane.showMessageDialog(null, "Player One Wins!");
			dispose(); 
			System.exit(0);
		}
		if(score2==10)
		{
			score1=0;
			score2=0;
			JOptionPane.showMessageDialog(null, "Player Two Wins!");
			dispose();
			System.exit(0);
		}
		
		pad1.update();
		pad2.update();
		ball.update();
		
		repaint();
	}
}
