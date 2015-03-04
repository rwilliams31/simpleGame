import java.awt.Color;

import drawn.Circle;


public class Character extends Circle {
	private int dy;
	private int acc;
	private final int maxDy=-25;
	private boolean jumpable;
	
	public Character(){
		super();
		dy=0;
		jumpable=true;
	}
	public Character(int xi, int yi){
		super(xi, yi);
		dy=0;
		jumpable=true;
	}
	public Character(int xi, int yi, Color c){
		super(xi, yi, c);
		dy=0;
		jumpable=true;
	}
	public Character(int xi, int yi, int r){
		super(xi, yi,r);
		dy=0;
		jumpable=true;
	}
	public Character(int xi, int yi, int r, Color c){
		super(xi, yi, r, c);
		dy=0;
		jumpable=true;
	}
	public int getDy(){
		return dy;
	}
	public void setDy(int val){
		dy=val;
	}
	public int getAcc(){
		return acc;
	}
	public void setAcc(int val){
		acc=val;
	}	
	public void fall(){
		dy+=acc;
		if(dy<maxDy) dy=maxDy; //maxDy is actually lowest possible value
	}
	
	public boolean canJump(){
		return jumpable;
	}
	public void canJump(boolean val){
		jumpable=val;
	}
}
