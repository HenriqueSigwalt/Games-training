package Mini_zelda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle{

	public int dir=1;
	public int speed=8;
	
	public Bullet(int x, int y, int dir, int speed) {
		super(x,y,4,4);
		this.dir=dir;
		this.speed=speed;
	}
	
	public void tick() {
		if(dir%2==0) {
			y+=speed*dir/2;
		}
		else {
			x+=speed*dir;
		}
		if(x>Game.WIDTH||y>Game.HEIGTH) {
			Player.bullets.remove(this);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, width, height);
	}
	
}
