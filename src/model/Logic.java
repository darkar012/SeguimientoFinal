package model;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PApplet;

public class Logic implements Runnable {
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
			} else if (type.equals("recuperadas")) {
				population.add(new RecoveredPerson(false, false, true, app));
				System.out.println("recuperada");
			}
		}
	}

	public void drawPopulation() {

		for (int i = 0; i < population.size(); i++) {
			population.get(i).drawPerson();
			Thread moveThread = new Thread (population.get(i));
			moveThread.start();
			
			contagion();
		}
	}

	public void  run() {
		try {
			Thread.sleep((int)(Math.random() * 100));
			rebound();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void rebound() {
		for (int i = 0; i < population.size(); i++) {
			for (int j = 0; j < population.size(); j++) {

				int posX1 = population.get(i).getPosX();
				int posY1 = population.get(i).getPosY();
				int posX2 = population.get(j).getPosX();
				int posY2 = population.get(j).getPosY();
				int size = population.get(j).getSize();

				if (app.dist(posX1, posY1, posX2, posY2) < size) {

					if (population.get(i)!= population.get(j)) {

						//if(posX1 <= 250 && posX1 >= 250 + 676 && posY1 < 164 && posY1 <164 + 448 && posX2 <= 250 && posX2 >= 250 + 676 && posY2 < 164 && posY2 <164 + 448)

						//population.get(i).setSpeedY(-1);
						population.get(i).setSpeedX((int) app.random(-2, 2));
						population.get(j).setSpeedX((int) app.random(-2, 2));
						//population.get(j).setSpeedY(-1);

						/*if (population.get(j).isHealthy() && population.get(i).isInfected()){

							System.out.println("sio");
							population.add(new InfectedPerson(true, false, false, app));
							population.get(population.size()-1).setPosX(population.get(j).posX);
							population.get(population.size()-1).setPosY(population.get(j).posY);
							population.remove(population.get(j));

						}*/
					}
				}
			}
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
				int size = population.get(j).getSize();
				boolean health = population.get(j).isHealthy();
				boolean infect = population.get(i).isInfected();
				
				if (percentage <= 9 && app.dist(posX1, posY1, posX2, posY2) < size) {
					if (health && infect) {
						
						population.add(new InfectedPerson(true, false, false, app));
						population.get(population.size()-1).setPosX(population.get(j).posX);
						population.get(population.size()-1).setPosY(population.get(j).posY);
						population.remove(population.get(j));
		
					}
				}
			}
		}
	}
}

