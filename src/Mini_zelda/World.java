package Mini_zelda;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {

	public static List<Block> blocks = new ArrayList<Block>();
	
	public World() {
		for(int x=0;x<(Game.WIDTH/32);x++) {
			blocks.add(new Block(x*32,0,32,32));
		}
		for(int x=0;x<(Game.WIDTH/32);x++) {
			blocks.add(new Block(0,x*32,32,32));
		}
		for(int x=0;x<(Game.WIDTH/32);x++) {
			blocks.add(new Block(x*32,Game.WIDTH-32,32,32));
		}
		for(int x=0;x<(Game.WIDTH/32);x++) {
			blocks.add(new Block(Game.WIDTH-32,x*32,32,32));
		}
	}
	
	public static boolean isFree(int x, int y, int width,int hegth) {
		for(int i=0;i<blocks.size();i++) {
			Block block_cur=blocks.get(i);
			if(block_cur.intersects(new Rectangle(x,y,width,hegth))) {
				return false;
			}
		}
		return true;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int i=0;i<blocks.size();i++) {
			blocks.get(i).render(g);
		}
	}
	
}
