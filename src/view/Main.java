package view;

import controller.ControlMain;
import processing.core.PApplet;

public class Main extends PApplet {

	ControlMain control;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}
	public void settings() {

		size(1200,800);
	}

	public void setup() {

		control = new ControlMain(this);



	}

	public void draw() {
		background(255);
		control.draw();


	}



	public void keyPressed() {
	}
}
