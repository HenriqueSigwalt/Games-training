package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends Rectangle{

	public int yspeed;
	public int speed;
	public int dir;
	
	public Ball(int width, int height, int x, int y, int speed) {
		super(x,y,width,height);
		this.speed=speed;
	}
	
	public void startBall(int level, int start_dir) {
		dir=start_dir;
		yspeed=(int) (Math.random() * (6 - (-6) + 1)) + (-6);
		speed=level*2;
		x=298;
		y=298;
	}
	
	public void tick() {
		if((y+yspeed)<0){
			yspeed=yspeed*(-1);
		}
		if((y+yspeed)>Game.HEIGHT){
			yspeed=yspeed*(-1);
		}
		
		y+=yspeed;
		
		if(dir==1){
			x+=speed;
		}
		else{
			x-=speed;
		}
		
		if(x>Game.WIDTH){
			Game.player.score++;
			if(Game.player.score==5){
				Game.level++;
				Game.opponent.speed+=2;
				Game.player.speed+=2;
				Game.player.score=0;
				Game.opponent.score=0;
			}
			startBall(Game.level,0);
		}
		if(x<0){
			Game.opponent.score++;
			if(Game.opponent.score==5){
				Game.level=1;
				Game.opponent.speed=2;
				Game.player.speed=2;
				Game.player.score=0;
				Game.opponent.score=0;
			}
			startBall(Game.level,1);
		}
		
		if(this.intersects(Game.player)) {
			dir=1;
			yspeed=(int) (Math.random() * (6 - (-6) + 1)) + (-6);
		}
		if(this.intersects(Game.opponent)) {
			dir=0;
			yspeed=(int) (Math.random() * (6 - (-6) + 1)) + (-6);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
	
}
