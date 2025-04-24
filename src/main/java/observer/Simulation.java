package observer;

import data.SimulationPreparer;
import factory.*;
import state.*;
import java.util.ArrayList;

public class Simulation implements Subject {
    ArrayList<Observer> observers; //list of observers needed for simulation
    SimulationPreparer simulationPreparer; //prepares objects for each round of simulation
    int time; //simulation time, resets every round

    Airport airport; //current airport of simulation round
    ArrayList<Airplane> airplanes; //list of airplanes for simulation
    ArrayList<Passenger> passengers; //list of passengers for simulation

    public Simulation() {
        observers = new ArrayList<>();
        time = 0;
        simulationPreparer = new SimulationPreparer();

        airport = null; //none selected yet
        airplanes = null; //none made yet
        passengers = null; //node made yet
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
        simulationPreparer.setUp(); //create objects for simulation
        setObjects(); //set objects for simualtion
        printHelper(); //begining print statements of simulation

        //notify airplanes to arrive at airport
        //notify passengers to start their cycles     
        //notify airports at end of round to report status

        simulationPreparer.reset(); //resets simulation before next round
    }

    private void setObjects() {
        airport = simulationPreparer.getCurrentAirport(); //set current airport
        airplanes = simulationPreparer.getAirplanes(); //get list of airplanes
        passengers = simulationPreparer.getPassengers(); //get list of passenegrs   
    }

    private void printHelper() {
        System.out.println("New simulation round has started.");
        for(Airplane a : airplanes) {
            System.out.println(a.getName() + " has landed at " + airport.getName() + " Airport.");
        }
    }
}






