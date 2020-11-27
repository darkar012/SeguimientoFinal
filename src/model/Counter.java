package model;

import processing.core.PApplet;

public class Counter implements Comparable<Counter> {
	
	private PApplet app;
	private int quantity;
	private int r;
	private int g;
	private int b;
	private int color;
	private int state;
	private String name;
	
	public Counter(String name, int state, PApplet app) {
		this.app = app;
		this.name = name;
		this.state = state;
		quantity = 0;
		color = app.color(r,g,b);
	}
	
	public void drawCounter (int posY) {
		 switch (state) {
		case 1: {
			r=0;
		    g=255;
		    b=0;
			app.fill(r,g,b);
		}
		break;
		case 2: {
			r=255;
		    g=0;
		    b=0;
			app.fill(r,g,b);
		}
		break;
		case 3: {
			r=0;
		    g=0;
		    b=255;
			app.fill(r,g,b);
		}
		break;
		default:
		}
		app.text("Cantidad de personas "+ name + quantity, 200 , posY);
	}
	
	public int compareTo(Counter o) {
		return this.getColor()-o.getColor();
	}
	

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
