package drawn;
import java.awt.Color;


public class Rectangle extends DrawnObject {
	private	int width;
	private int height;
	
	public Rectangle(){
		super();
		width=10;
		height=10;
	}
	public Rectangle(int xi, int yi, int w, int h){
		super(xi,yi);
		width=w;
		height=h;
	}
	public Rectangle(int xi, int yi, int w, int h, Color c){
		super(xi, yi, c);
		width=w;
		height=h;
	}

	@Override
	public void draw() {
		Color tmp = StdDraw.getPenColor();
		StdDraw.setPenColor(color);
		if(filled){
			StdDraw.filledRectangle(x, y, width/2, height/2);
		}
		else{
			StdDraw.rectangle(x, y, width/2, height/2);
		}
		StdDraw.setPenColor(tmp);
	}

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void setWidth(int w){
		width=w;
	}
	public void setHeight(int h){
		height=h;
	}
	
	public boolean collidesWith(Rectangle other){
		return this.x + this.width/2 >= other.x - other.getWidth()/2 && 
				this.x - this.width/2 <= other.x + other.getWidth()/2 &&
				this.y + this.height/2 >= other.y - other.getHeight()/2 &&
				this.y - this.height/2 <= other.y + other.getHeight()/2;
	}
	public boolean collidesWith(Circle other){
		return this.x + this.width/2 >= other.x - other.getRadius() && 
				this.x - this.width/2 <= other.x + other.getRadius() &&
				this.y + this.height/2 >= other.y - other.getRadius() &&
				this.y - this.height/2 <= other.y + other.getRadius();
	}
}
