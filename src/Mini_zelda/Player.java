package Mini_zelda;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle{
	
	public boolean right,up,down,left;
	public int speed=2;
	int sprite_num=0;
	int rate=8;
	int cur_frame=0;
	public BufferedImage sprite_cur=Spritesheet.player_front[0];
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	
	public Player(int x, int y, int heigth, int width) {
		super(x,y,heigth,width);
	}
	
	public boolean shoot=false;
	public int shoot_dir=1;
	public int shoot_delay=10;
	
	public void ticK() {
		if(shoot_delay==10) {
			if(shoot) {
				bullets.add(new Bullet(x+width,y+height/2,shoot_dir,4));
				shoot=false;
				shoot_delay=0;
			}
		}
		else {
			shoot_delay++;
		}
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).tick();
		}
		if(right&&x+speed<(Game.WIDTH-width)&&(World.isFree(x+speed, y, width, height))) {
			x+=speed;
			cur_frame++;
			if(cur_frame==rate) {
				cur_frame=0;
				if(sprite_num+1<Spritesheet.player_right.length) {
					sprite_num++;
				}
				else {
					sprite_num=0;
				}
			}
			sprite_cur=Spritesheet.player_right[sprite_num];
			shoot_dir=1;
		}
		if(left&&x>0&&(World.isFree(x-speed, y, width, height))) {
			x-=speed;
			cur_frame++;
			if(cur_frame==rate) {
				cur_frame=0;
				if(sprite_num+1<Spritesheet.player_left.length) {
					sprite_num++;
				}
				else {
					sprite_num=0;
				}
			}
			sprite_cur=Spritesheet.player_left[sprite_num];
			shoot_dir=-1;
		}
		if(up&&y>0&&(World.isFree(x, y-speed, width, height))) {
			y-=speed;
			cur_frame++;
			if(cur_frame==rate) {
				cur_frame=0;
				if(sprite_num+1<Spritesheet.player_back.length) {
					sprite_num++;
				}
				else {
					sprite_num=0;
				}
			}
			sprite_cur=Spritesheet.player_back[sprite_num];
			shoot_dir=-2;
		}
		if(down&&y+speed<(Game.HEIGTH-height)&&(World.isFree(x, y+speed, width, height))) {
			y+=speed;
			cur_frame++;
			if(cur_frame==rate) {
				cur_frame=0;
				if(sprite_num+1<Spritesheet.player_front.length) {
					sprite_num++;
				}
				else {
					sprite_num=0;
				}
			}
			sprite_cur=Spritesheet.player_front[sprite_num];
			shoot_dir=2;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite_cur,x,y,width,height,null);
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).render(g);
		}
	}
}
