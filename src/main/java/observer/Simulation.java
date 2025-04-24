package observer;

import data.SimulationPreparer;
import factory.*;
import state.*;
import java.util.ArrayList;

public class Simulation implements Subject {
    ArrayList<Observer> observers; //list of observers needed for simulation
    SimulationPreparer simulationPreparer; //prepares objects for each round of simulation
    int round; //current round of simulation

    Airport airport; //current airport of simulation round
    ArrayList<Airplane> airplanes; //list of airplanes for simulation
    ArrayList<Passenger> passengers; //list of passengers for simulation

    public Simulation() {
        observers = new ArrayList<>();
        round = 1; //start on round 1
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
    public void notifyObservers(Observer observer) {
        observer.update();
    }

    /**
    *Runs simulation.
    */
    public void runSimulation() {
        //create Observers
        AirportObserver airportObserver = new AirportObserver(this);
        AirplaneObserver airplaneObserver = new AirplaneObserver(this);
        //PassengerObserver passengerObserver = new PassengerObserver(this);

        simulationPreparer.setUp(); //create objects for simulation
        setObjects(); //set objects for simualtion
        //sort airplane list by departure time

        notifyObservers(airportObserver); //displays state of current airport
        notifyObservers(airplaneObserver); //simulations boarding and departures 

        simulationPreparer.reset(); //resets simulation before next round
        round++; //increment round tracker
    }

    private void setObjects() {
        airport = getAirport(); //set current airport
        airplanes = getAirplanes(); //get list of airplanes
        passengers = getPassengers(); //get list of passenegrs   
    }

    public int getRound() {
        return round;
    }

    public Airport getAirport() {
        return simulationPreparer.getCurrentAirport();
    }

    public ArrayList<Airplane> getAirplanes() {
        return simulationPreparer.getAirplanes();
    }

    public ArrayList<Passenger> getPassengers() {
        return simulationPreparer.getPassengers();
    }
}






