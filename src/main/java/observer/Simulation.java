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
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }

    /**
    *Runs simulation.
    */
    public void runSimulation() {
        //create Observers
        AirportObserver airportObserver = new AirportObserver(this);
        AirplaneObserver airplaneObserver = new AirplaneObserver(this);
        RoundObserver roundObserver = new RoundObserver(this);
        
        //add observers
        addObserver(airportObserver);
        addObserver(airplaneObserver);
        addObserver(roundObserver);

        //prepare objects for simulation
        simulationPreparer.setUp();
        setObjects();
        //sort airplane list by departure time
 
        //notify observers of new round
        notifyObservers();

        //reset simulation objects before next round
        simulationPreparer.reset();
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






