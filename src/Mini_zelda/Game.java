package Mini_zelda;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int WIDTH=480, HEIGTH=480;
	public static Player player;
	public World world;
	public List<Enemy> enemies= new ArrayList<Enemy>();
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		new Spritesheet();
		world = new World();
		player = new Player(32,32,32,32);
		enemies.add(new Enemy(300,250,32,32));
	}
	
	public void tick() {
		world.tick();
		player.ticK();
		for(int i=0;i<enemies.size();i++) {
			enemies.get(i).ticK();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, WIDTH, HEIGTH);
		world.render(g);
		player.render(g);
		for(int i=0;i<enemies.size();i++) {
			enemies.get(i).render(g);
		}
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setTitle("Mini-Zelda");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		new Thread(game).start();
	}
	
	@Override
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

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			player.up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			player.shoot=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			player.up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down=false;
		}
	}
	
}
