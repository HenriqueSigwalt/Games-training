package Pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

	public static int WIDTH = 600, HEIGHT = 600;
	public static Raquet player;
	public static Opponent opponent;
	public static Ball ball;
	public static int level=1;
	public static Font font = new Font("Arial", Font.PLAIN, 40);
	public static int state=0;
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		player = new Raquet(10,60,0,270,4);
		opponent = new Opponent(10,60,590,270,4);
		ball = new Ball(4,4,298,298,2);
		ball.startBall(level, 0);
	}
	
	public void tick() {
		if(state==1){
			player.tick();
			opponent.tick();
			opponent.chase();
			ball.tick();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 600, 600);
		if(state==1){
			player.render(g);
			opponent.render(g);
			ball.render(g);
			g.setFont(font);
			g.drawString(String.valueOf(player.score), 200, 60);
			g.drawString(String.valueOf(opponent.score), 400, 60);
		}
		if(state==0){
			g.setColor(Color.white);
			g.setFont(font);
			g.drawString("Pong", 250, 200);
			g.drawString("Press enter to start", 125, 300);
		}
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.setTitle("Pong");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.requestFocus();
		new Thread(game).start();
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			player.up=true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			player.down=true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_ENTER){
			state=1;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			player.up=false;
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			player.down=false;
		}
	}

	public void run() {
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
