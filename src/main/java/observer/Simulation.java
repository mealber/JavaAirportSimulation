package observer;

import data.SimulationPreparer;
import factory.Airport;
import java.util.ArrayList;

public class Simulation implements Subject {
    ArrayList<Observer> observers; //list of observers needed for simulation
    SimulationPreparer simulationPreparer; //prepares objects for each round of simulation
    Airport airport; //current airport of simulation round
    int time; //simulation time, resets every round

    public Simulation() {
        observers = new ArrayList<>();
        time = 0;
        simulationPreparer = new SimulationPreparer();
        airport = null; //none selected yet
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }

    /**
    *Runs simulation.
    */
    public void runSimulation() {
        simulationPreparer.setUp(); //set up objects for simulation

        airport = simulationPreparer.getCurrentAirport(); //set current airport

        System.out.println("New simulation round has started.");

        //notify airplanes to arrive at airport
        //notify passengers to start their cycles     
        //notify airports at end of round to report status

        simulationPreparer.reset(); //resets simulation before next round
    }
}