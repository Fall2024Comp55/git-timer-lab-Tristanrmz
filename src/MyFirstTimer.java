import acm.graphics.*;

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFirstTimer extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	private GLabel myLabel;
	private Timer firstTimer;
	private int numTimes;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		myLabel.move(5, 0);
		numTimes = numTimes + 1;
		myLabel.setLabel("times called? " + numTimes);
		if(numTimes == 10) {
			firstTimer.stop();
		}
		
	}
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		numTimes = 0;
		myLabel = new GLabel("# of times called?", 0, 100);
		
		add(myLabel);
		firstTimer = new Timer(1000, this);
		firstTimer.setInitialDelay(3000);
		firstTimer.start();
		
	}
	
	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}