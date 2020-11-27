package controller;

import model.Logic;
import processing.core.PApplet;

public class ControlMain {

	private PApplet app;
	private Logic logic;
	
	public ControlMain(PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		logic = new Logic(app);
	}
	
	public void draw () {
		logic.drawPopulation();
	}
	
	public void sortList (char key) {
		
		logic.sortList(key);
		
	}
}
