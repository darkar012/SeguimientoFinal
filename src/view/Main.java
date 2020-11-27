package view;

import controller.ControlMain;
import model.Logic;
import processing.core.PApplet;

public class Main extends PApplet {

	ControlMain control;
	Logic logic;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}
	public void settings() {

		size(1200,800);
	}

	public void setup() {

		control = new ControlMain(this);
		logic = new Logic(this);
	}

	public void draw() {
		background(255);
		fill(222);
		rect(250, 160, 700, 500);
		control.draw();
		Thread reboundThread = new Thread (logic);
		reboundThread.start();
	}

	public void keyPressed() {
		
		control.sortList(key);
		
	}
}
