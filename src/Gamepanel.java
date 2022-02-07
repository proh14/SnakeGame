//imports

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
//***********************************


public class Gamepanel extends JPanel implements ActionListener {

	//Fields
	
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 100;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char dir = 'R';
	boolean running = false;
	boolean restart = false;
	javax.swing.Timer timer;
	Random random;
	
//**********************************************************	
	
	
	
	
	Gamepanel(){
		
		
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH , SCREEN_HEIGHT ));
		this.setBackground(Color.blue);
		this.setFocusable(true);
		this.addKeyListener(new Mykeyadapter());
		Startgame();
	} // End of Gamepanel(){}
	
	
	
	//Methods
	
	
	
		
	
	
	public void Startgame() {
		
		Newapple();
		running = true;
		timer = new javax.swing.Timer(DELAY , this);
		timer.start();
		
		
	} //End of Startgame
	
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
		
	} // End of paintComponent
	
		public void draw(Graphics g)  {
			
				//for (int i = 0; i<SCREEN_HEIGHT/UNIT_SIZE; i++) {
					//g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
					//g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			//	}	
			
				g.setColor(Color.red);
				g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
				for(int i = 0; i<bodyParts; i++) {
				
				if (i == 0) {
					
					
					   
					
					
						g.setColor(Color.GREEN);
						g.fillRect(x[i], y[i],UNIT_SIZE, UNIT_SIZE);
					
				} else  {
					g.setColor(new Color(45,180,0));
					g.fillRect(x[i], y[i],UNIT_SIZE, UNIT_SIZE);

					
					
					
				}
				
			}
			
		  if (running == false) {
			
			
			  Gameover(g);
			 
		  
		  }
			
		
			
			
			
			else if (bodyParts ==  48) {
			running = false;
			Winner(g);
			
			
			
			

			
			
			
		}
			
	} // End of draw 
		
		
		public void Newapple() {
			
			appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE ; 
			appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE ;
			
			
			
		} // End of Newapple
	
		public void move() {
			
			for (int i = bodyParts; i>0; i-- ) {
				x[i] = x[i -1] ;
				y[i] = y[i -1] ;
				
			} 
			
			switch (dir) {
			case 'U':
				y[0] = y[0] - UNIT_SIZE;
				break;
			case 'D' :
				y[0] = y[0] + UNIT_SIZE;
				break;
			case 'L' :
				x[0] = x[0] - UNIT_SIZE;
				break;
			case 'R' : 
				x[0] = x[0] + UNIT_SIZE;
				
				break;
				}
		
		
		
	} // End of move
	
		public void Checkapple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			Newapple();
			
			
			
			
		}
			
		
		
		
	} // End of Checkapple
	
	
		public void Checkcolli() {
			
			for(int i = bodyParts; i>0; i--) {
				
				
				if ((x[0] == x[i]) && (y[0] == y[i])) 
					running = false;
	
			}
				
				
				if (x[0] < 0)
					running = false;
				
				if (x[0] > SCREEN_WIDTH)
					running = false;
				
				if (y[0] < 0)
					running = false;
				
				if (y[0] > SCREEN_HEIGHT)
					running = false;	
			
				if (!running)
					timer.stop();
				
			}// End of Checkcolli
			
			
			
	 
		
			public void Gameover(Graphics g) {
				
		

			
			g.setColor(Color.red);
			g.setFont(new Font("Times New Roman",Font.BOLD,75));
			g.drawString("Game Over", 120 , 120);
			  
			
		} // End of Gameover
			
			public void Winner(Graphics g) {
				
				
					
					g.setColor(Color.green);
					g.setFont(new Font("Times New Roman",Font.BOLD,75));
					g.drawString("   Winner", 120 , 120);
					
				

				
				
			}	
			
				
			
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(running) {
					move();
					Checkapple();
					Checkcolli();
					
					
				}
				repaint();
				
				
				
				
				}// End of actionPerformed
			
//**************************************************
	
	
	
	//Classes

	
	public class Mykeyadapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e){
			
			
			switch (e.getKeyCode()) {
				case KeyEvent.VK_A :
					 
					if (dir != 'R') 
						dir = 'L';
					break;
					
				case KeyEvent.VK_D :
					 
					if (dir != 'L') 
						dir = 'R';
					break;
					
				case KeyEvent.VK_W :
					 
					if (dir != 'D') 
						dir = 'U';
					break;
					
				case KeyEvent.VK_S :
					 
					if (dir != 'U') 
						dir = 'D';
					break;
						
						
						
					
					
					
					
				}
				
					} //End of keyPressed
					
				
				
			} //End of Mykeyadapter
	
	

	
	
	
	} //End of Gamepanel










	
