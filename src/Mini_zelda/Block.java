package Mini_zelda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle{

	public Block(int x, int y, int heigth, int width) {
		super(x,y,heigth,width);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}