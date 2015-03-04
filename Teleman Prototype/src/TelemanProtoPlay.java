import java.awt.event.KeyEvent;
import drawn.*;

public class TelemanProtoPlay {

	private static int teleCharge;
	private static int teleChargeMax;
	public static void main(String[] args) {
		initCanvas();
		play();
	}
	
	static void initCanvas(){
		StdDraw.setCanvasSize(800,600);
		StdDraw.setXscale(-400, 400);
		StdDraw.setYscale(-300, 300);
	}
	
	static void play(){
		Character player = new Character(0, 0, 10, StdDraw.RED);
		player.setAcc(-2);
		DrawnObject[] objList = new DrawnObject[10];
		objList[0]=player;
		objList[1] = new Rectangle(0, -270, 350, 15, StdDraw.BLUE); //teleCharge bar container
		objList[1].setFilled(false);
		Rectangle chargeBar = new Rectangle(0, -270, 1, 15, StdDraw.BLUE);
		objList[2] = chargeBar;
		teleCharge=0;
		teleChargeMax=350;
		Rectangle ground = new Rectangle(0,-100,800,100); // the ground
		objList[3]=ground;
		
		while(true){
			StdDraw.clear();
			for(int i=0; i<objList.length; i++){
				if(objList[i]!=null){
					objList[i].draw();
				}
			}
			
			StdDraw.show(10);
			int[] playerMoves = keyListen(player);
			player.move(playerMoves[0], playerMoves[1]);
			gravity(player, ground);
			mouseListen(player, chargeBar);
		}
	}

	static int[] keyListen(Character player){
		int dx=0;
		int dy=0;
		if(StdDraw.isKeyPressed(KeyEvent.VK_A)){
			dx+=-5;
		}
		if(StdDraw.isKeyPressed(KeyEvent.VK_D)){
			dx+=5;
		}
		if(StdDraw.isKeyPressed(KeyEvent.VK_W) && player.canJump()){
			dy+=1; //used to get the player off of the ground initially
			player.setDy(20);
			player.canJump(false);
		}
		if(StdDraw.isKeyPressed(KeyEvent.VK_S)){
			dy+=-5;
		}
		int[] result = {dx, dy};
		return result;
	}
	static void mouseListen(Circle player, Rectangle bar){
		if(StdDraw.mousePressed())
		{
			if(teleCharge<teleChargeMax)
				teleCharge+=3;
		}
		else if(teleCharge>0){
			double playerToMouse = Math.sqrt(
					((double)player.getX()-StdDraw.mouseX())*((double)player.getX()-StdDraw.mouseX()) + 
					((double)player.getY()-StdDraw.mouseY())*((double)player.getY()-StdDraw.mouseY()));
			double dxhat = -1*((double)player.getX()-StdDraw.mouseX())/playerToMouse;
			double dyhat = -1*((double)player.getY()-StdDraw.mouseY())/playerToMouse;
			
			player.move((int)(teleCharge*dxhat), (int)(teleCharge*dyhat));
			teleCharge=0;
		}
		bar.setWidth(teleCharge);
		bar.setX(-175 + teleCharge/2);
	}
	static void gravity(Character player, Rectangle ground){
		if(!player.collidesWith(ground)){
			player.fall();
			player.move(0, player.getDy());
		}
		else {
			player.setY(ground.getY()+ground.getHeight()/2+player.getRadius());
			player.setDy(0);
			player.canJump(true);
		}
		
		if(player.getY()<-300){
			player.setY(300);
		}
	}
}
