package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Raquet extends Rectangle{
	
	public boolean up, down = false;
	public int speed;
	public int score=0;
	
	public Raquet(int width, int height, int x, int y, int speed) {
		super(x,y,width,height);
		this.speed=speed;
	}
	
	public void tick() {
		if(up&&y>0){
			y-=speed;
		}
		if(down&&y<(Game.HEIGHT-height)){
			y+=speed;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
	
}
