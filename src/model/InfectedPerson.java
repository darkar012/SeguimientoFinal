package model;

import processing.core.PApplet;

public class InfectedPerson extends Person{
	
	public InfectedPerson(boolean infected, boolean healthy, boolean recovered, PApplet app) {
		super (infected, healthy, recovered, app);
	}

}
