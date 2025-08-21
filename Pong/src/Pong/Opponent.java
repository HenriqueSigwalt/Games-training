package Pong;

public class Opponent extends Raquet{

	public Opponent(int width, int height, int x, int y, int speed) {
		super(width, height, x, y, speed);
	}
	
	public void chase(){
		if(y>Game.ball.y) {
			up=true;
			down=false;
		}
		if(y<Game.ball.y-60){
			up=false;
			down=true;
		}
	}

}
