package observer;

import data.SimulationPreparer;
import java.util.ArrayList;

public class Simulation implements Subject {
    ArrayList<Observer> observers = new ArrayList<>(); //list of observers needed for simulation
    int time = 0; //simulation time, resets every round
    SimulationPreparer simulationPreparer = new SimulationPreparer(); //prepares objects for each round of simulation

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int time) {
        for(Observer o : observers) {
            o.update(time);
        }
    }

    /**
    *Runs simulation.
    */
    public void runSimulation() {
        simulationPreparer.setUp();   
    }
}