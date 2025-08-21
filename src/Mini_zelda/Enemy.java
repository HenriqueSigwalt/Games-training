package Mini_zelda;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends Rectangle{

	public boolean right,up,down,left;
	public int speed=1;
	public BufferedImage sprite_cur=Spritesheet.enemy_front;
	
	public Enemy(int x, int y, int heigth, int width) {
		super(x,y,heigth,width);
	}
	
	public void ticK() {
		
		Player p = Game.player;
		
		if(p.x>x) {
			right=true;
		}
		if(p.x<x) {
			left=true;
		}
		if(p.y<y) {
			up=true;
		}
		if(p.y>y) {
			down=true;
		}
		
		if(right&&x+speed<(Game.WIDTH-width)&&(World.isFree(x+speed, y, width, height))) {
			x+=speed;
			right=false;
		}
		if(left&&x>0&&(World.isFree(x-speed, y, width, height))) {
			x-=speed;
			left=false;
		}
		if(up&&y>0&&(World.isFree(x, y-speed, width, height))) {
			y-=speed;
			up=false;
		}
		if(down&&y+speed<(Game.HEIGTH-height)&&(World.isFree(x, y+speed, width, height))) {
			y+=speed;
			down=false;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite_cur,x,y,width,height,null);
	}
	
}
