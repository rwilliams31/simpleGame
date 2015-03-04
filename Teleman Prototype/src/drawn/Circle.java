package drawn;
import java.awt.Color;


public class Circle extends DrawnObject{

	private int radius;
	
	public Circle(){
		super();
		radius=10;
	}
	public Circle(int xi, int yi){
		super(xi, yi);
		radius=10;
	}
	public Circle(int xi, int yi, Color c){
		super(xi, yi, c);
		radius=10;
	}
	public Circle(int xi, int yi, int r){
		super(xi, yi);
		radius=r;
	}
	public Circle(int xi, int yi, int r, Color c){
		super(xi, yi, c);
		radius=r;
	}

	@Override
	public void draw() {
		Color tmp = StdDraw.getPenColor();
		StdDraw.setPenColor(color);
		if(filled){
			StdDraw.filledCircle(x, y, radius);
		}
		else{
			StdDraw.circle(x, y, radius);
		}
		StdDraw.setPenColor(tmp);
	}
	
	public int getRadius(){
		return radius;
	}
	public void setRadius(int r){
		radius=r;
	}

	public boolean collidesWith(Circle other){
		return Math.sqrt((this.x-other.x)*(this.x-other.x) - (this.y-other.y)*(this.y-other.y)) <= (this.radius+other.radius);
	}
	public boolean collidesWith(Rectangle other){
		return this.x + this.radius >= other.x - other.getWidth()/2 && 
				this.x - this.radius <= other.x + other.getWidth()/2 &&
				this.y + this.radius >= other.y - other.getHeight()/2 &&
				this.y - this.radius <= other.y + other.getHeight()/2;
	}
}
