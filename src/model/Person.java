package model;

import processing.core.PApplet;

public class Person {

	PApplet app;
	protected int posX;
	protected int posY;
	protected int speed;
	protected int size;
	protected int r;
	protected int g;
	protected int b;
	protected int color;
	protected float dirX;
	protected float dirY;
	protected boolean infected;
	protected boolean healthy;
	protected boolean recovered;


	public Person(boolean infected, boolean healthy, boolean recovered, PApplet app) {
		
		this.app = app;
		this.infected = infected;
		this.healthy = healthy;
		posX=(int) (app.random(258, 942));
		posY=(int) (app.random(172, 628));
		color= app.color(r,g,b);
		size = 7;
		speed = 5;
		
	}
	
	public void drawPerson() {
		
		if (!healthy && !infected && recovered) {
			r= 0;
			g= 0;
			b = 255;	
			app.fill(r,g,b);
			app.ellipse(posX, posY, 7, 7);
			System.out.println(posX);
		} else if (!healthy && infected && !recovered) {
			r= 255;
			g= 0;
			b = 0;	
			app.fill(r,g,b);
			app.ellipse(posX, posY, 7, 7);
		} else {
			r= 0;
			g= 255;
			b = 0;	
			app.fill(r,g,b);
			app.ellipse(posX, posY, 7, 7);
			
		}
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public float getDirX() {
		return dirX;
	}

	public void setDirX(float dirX) {
		this.dirX = dirX;
	}

	public float getDirY() {
		return dirY;
	}

	public void setDirY(float dirY) {
		this.dirY = dirY;
	}

	public boolean isInfected() {
		return infected;
	}

	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}

	public boolean isRecovered() {
		return recovered;
	}

	public void setRecovered(boolean recovered) {
		this.recovered = recovered;
	}
	
}

