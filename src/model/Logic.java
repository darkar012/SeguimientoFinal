package model;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {
	private PApplet app;
	private ArrayList <Person> population;
	private LinkedList <Counter> counterList;
	private String[] people;

	public Logic (PApplet app) {
		this.app = app;
		population = new ArrayList <Person> ();
		counterList = new LinkedList <Counter> ();
		people = app.loadStrings("../data/people.txt");

		readTXT();
	}

	private void readTXT() {
		for (int i = 0; i < people.length; i++) {
			String[] divPopulation = people[i].split(":");

			String type = divPopulation[0];
			int peopleHealthy = Integer.parseInt(divPopulation[1]);
			//int peopleInfected = Integer.parseInt(divPopulation[3]);

			if (type.equals("sanas")) {
				for (int j = 0; j < peopleHealthy; j++) {
					population.add(new HealthyPerson(false, true, false, app));
				}
			} else if (type.equals("infectadas")) {
				//for (int j = 0; j < peopleInfected; j++) {
				population.add(new InfectedPerson(true, false, false, app));
			} else {
				population.add(new RecoveredPerson(false, false, true, app));
			}
		}
	}

	public void drawPopulation() {

		for (int i = 0; i < population.size(); i++) {
			population.get(i).drawPerson();
			Thread moveThread = new Thread (population.get(i));
			moveThread.start();
		}
	}
	public void contagion() {
		for (int i = 0; i < population.size(); i++) {
			for (int j = 0; j < population.size(); j++) {
					float percentage = (app.random(0, 10));
					int posX1 = population.get(i).getPosX();
					int posY1 = population.get(i).getPosY();
					int posX2 = population.get(j).getPosX();
					int posY2 = population.get(j).getPosY();
					
				}
			}
		}
	

}
