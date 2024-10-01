import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

//when pushing add "all balls move across the screen"
public class BallLauncher extends GraphicsProgram{
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int SIZE = 25;
	
	
	private ArrayList<GOval> balls;
	public static final int Ms = 50;
	public static final int SPEED = 2;
	private Timer balltimer;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(GOval ball:balls) {
			ball.move(SPEED, 0);
			
		}
		
	}
	
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		balls = new ArrayList<GOval>(); //<GOval>
		addMouseListeners();
		balltimer = new Timer(Ms, this);
		balltimer.start();
		
	}
	
	public void mousePressed(MouseEvent e) {
		//// check if ball x is less than 100
		
		for (GOval ball : balls) {
            if (ball.getX() < 100) {
                return; 
            }
        }
        
		GOval ball = makeBall(SIZE/2, e.getY());
		add(ball);
	}
	
	public GOval makeBall(double x, double y) {
		GOval temp = new GOval(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
		temp.setColor(Color.RED);
		temp.setFilled(true);
		balls.add(temp);
		return temp;
		
	}
	
	public static void main(String[] args) {
		new BallLauncher().start();
	}

}
