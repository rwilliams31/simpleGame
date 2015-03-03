package drawn;
import java.awt.Color;


public abstract class DrawnObject {
	protected int x;
	protected int y;
	protected Color color;
	protected boolean filled;
	
	public DrawnObject(){
		x=0;
		y=0;
		color=StdDraw.BLACK;
		filled=true;
	}
	
	public DrawnObject(int xi, int yi){
		x=xi;
		y=yi;
		color=StdDraw.BLACK;
		filled=true;
	}
	public DrawnObject(int xi, int yi, boolean f){
		x=xi;
		y=yi;
		color=StdDraw.BLACK;
		filled=f;
	}	
	public DrawnObject(int xi, int yi, Color c){
		x=xi;
		y=yi;
		color=c;
		filled=true;
	}	
	public DrawnObject(int xi, int yi, boolean f, Color c){
		x=xi;
		y=yi;
		color=c;
		filled=f;
	}
	public DrawnObject(Color c){
		color=c;
	}
	public void move(int dx, int dy){
		x+=dx;
		y+=dy;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int newX){
		x=newX;
	}
	public void setY(int newY){
		y=newY;
	}
	public void setFilled(boolean f){
		filled = f;
	}
	public Color getColor(){
		return color;
	}
	public void setColor(Color c){
		color = c;
	}

	public abstract void draw();
}
