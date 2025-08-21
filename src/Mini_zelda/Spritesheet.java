package Mini_zelda;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet;
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_back;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage enemy_front;
	
	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		player_front = new BufferedImage[2];
		player_back = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);
		player_back[0] = Spritesheet.getSprite(69, 11, 16, 16);
		player_left[0] = Spritesheet.getSprite(35, 27, 16, 16);
		player_right[0] = Spritesheet.getSprite(35, 11, 16, 16);
		player_front[1] = Spritesheet.getSprite(16, 11, 16, 16);
		player_back[1] = Spritesheet.getSprite(86, 11, 16, 16);
		player_left[1] = Spritesheet.getSprite(52, 27, 16, 16);
		player_right[1] = Spritesheet.getSprite(52, 11, 16, 16);
		enemy_front = Spritesheet.getSprite(92, 224, 16, 16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
	
}
