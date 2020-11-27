package model;

import java.util.ArrayList;
import java.util.LinkedList;

import exceptions.Contagion;
import exceptions.Thirty;
import processing.core.PApplet;

public class Logic implements Runnable {
	private PApplet app;
	private ArrayList <Person> population;
	private LinkedList <Counter> counterList;
	private String[] people;
	private boolean stop = true; 

	public Logic (PApplet app) {
		this.app = app;
		population = new ArrayList <Person> ();
		counterList = new LinkedList <Counter> ();
		people = app.loadStrings("../data/people.txt");

		readTXT();
		createCounter();
	}

	private void createCounter () {
		counterList.add(new Counter("Infectados:", 2, app));
		counterList.add(new Counter("Sanos:", 1, app));
		counterList.add(new Counter("Recuperados:", 3, app));
	}

	private void addCounter() {

		int infected = 0;
		int healthy = 0;
		int recovered = 0;

		for (int i = 0; i < population.size(); i++) {

			if (population.get(i).isHealthy()) {
				healthy++;
			} else if (population.get(i).isInfected()) {
				infected++;
			} else {
				recovered++;
			}
		}

		float percentage= (infected*100/population.size()); 

		if (percentage == 30) {
			try {
				throw new Thirty("Más del 30% infectado. Alerta");
			} catch (Thirty e) {
				System.out.println("Más del 30% infectado. Alerta");
			}
		}

		for (int r = 0; r < counterList.size(); r++) {
			if (counterList.get(r).getName().equals("Infectados:")) {
				counterList.get(r).setQuantity(infected);
			} else if (counterList.get(r).getName().equals("Sanos:")) {
				counterList.get(r).setQuantity(healthy);
			} else {
				counterList.get(r).setQuantity(recovered);
			}
		}
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

			if (population.get(i).isHealthy()==false) {
				stop=true;
			} else if (population.get(i).isHealthy()) {
				stop = false;
			}

			if (stop == false) {
				try {
					contagion();
				} catch (Contagion e) {
					// TODO Auto-generated catch block
					System.out.println("new infection");
				}
			}
		}
		for (int c = 0; c < counterList.size(); c++) {
			counterList.get(c).drawCounter((c * 20) + 100);
		}
		addCounter();
	}

	public void  run() {
		try {
			Thread.sleep((int)(1000));
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

						population.get(i).setSpeedX((int) app.random(-2, 2));
						population.get(j).setSpeedX((int) app.random(-2, 2));

					}
				}
			}
		}
	}

	private void contagion() throws Contagion {
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

						throw new Contagion("new infected");

					}
				} 
			}
		}
	}
}
