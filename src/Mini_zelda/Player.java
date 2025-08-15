package Mini_zelda;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Rectangle{
	
	public boolean right,up,down,left;
	public int speed=2;
	int sprite_num=0;
	int rate=8;
	int cur_frame=0;
	public BufferedImage sprite_cur=Spritesheet.player_front[0];
	
	public Player(int x, int y, int heigth, int width) {
		super(x,y,heigth,width);
	}
	
	public void ticK() {
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
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite_cur,x,y,width,height,null);
	}
}
