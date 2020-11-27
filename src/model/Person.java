package model;

import processing.core.PApplet;

public class Person implements Runnable{

	PApplet app;
	protected int posX;
	protected int posY;
	protected int speedY;
	protected int speedX;
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
	protected int dirXRandom;


	public Person(boolean infected, boolean healthy, boolean recovered, PApplet app) {
		
		this.app = app;
		this.infected = infected;
		this.healthy = healthy;
		this.recovered = recovered;
		posX=(int) (app.random(258, 942));
		posY=(int) (app.random(172, 628));
		color= app.color(r,g,b);
		size = 7;
		speedY = (int) (app.random(1, 5));
		speedX = (int) (app.random(1, 5));
		dirXRandom = (int) (app.random(1,4));
		
	}
	
	public void drawPerson() {
		
		if (!healthy && !infected && recovered) {
			r= 0;
			g= 0;
			b = 255;	
			app.fill(r,g,b);
			app.ellipse(posX, posY, size, size);
			
		} else if (!healthy && infected && !recovered) {
			r= 255;
			g= 0;
			b = 0;	
			app.fill(r,g,b);
			app.ellipse(posX, posY, size, size);
		} else {
			r= 0;
			g= 255;
			b = 0;	
			app.fill(r,g,b);
			app.ellipse(posX, posY, size, size);
			
		}
	}
	
	public void move() {
		
			if(posY < 172){
				speedY = speedY*-1;
				}
				else if (posY > 172 + 456){
				speedY = -speedY;
				}
			posX += speedX;
			posY += speedY;
				if (posX < 258){
				speedX = speedX*-1;
				}
				else if (posX > 258 + 684){
				speedX = -5;
				}
	}
	
	public void run() {
		
			move();
		
		
		if(infected) {

			try {
			
			Thread.sleep(15000);
			recovered = true;
			healthy = false;
			infected = false;
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
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


	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getDirXRandom() {
		return dirXRandom;
	}

	public void setDirXRandom(int dirXRandom) {
		this.dirXRandom = dirXRandom;
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

