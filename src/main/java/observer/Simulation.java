package observer;

import data.SimulationPreparer;
import data.AirplaneSorter;
import factory.Airplane;
import factory.Airport;
import state.Passenger;
import java.util.ArrayList;

public class Simulation implements Subject {
    ArrayList<Observer> observers; //list of observers needed for simulation
    SimulationPreparer simulationPreparer; //prepares objects for each round of simulation
    int round; //current round of simulation

    Airport airport; //current airport of simulation round
    ArrayList<Airplane> airplanes; //list of airplanes for simulation
    ArrayList<Passenger> passengers; //list of passengers for simulation

    AirplaneSorter airplaneSorter = new AirplaneSorter(); //sorts airplanes by departure time

    public Simulation() {
        observers = new ArrayList<>();
        round = 1; //start on round 1
        simulationPreparer = new SimulationPreparer();

        airport = null; //none selected yet
        airplanes = null; //none made yet
        passengers = null; //node made yet

        //create Observers
        AirportObserver airportObserver = new AirportObserver(this);
        AirplaneObserver airplaneObserver = new AirplaneObserver(this);
        RoundObserver roundObserver = new RoundObserver(this);
        
        //add observers
        addObserver(airportObserver);
        addObserver(airplaneObserver);
        addObserver(roundObserver);
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
       //prepare objects for simulation
        simulationPreparer.setUp();
        setObjects();
 
        //notify observers of new round
        notifyObservers();

        //reset simulation objects before next round
        round++; //increment round
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
        return airplaneSorter.sortAirplanes(simulationPreparer.getAirplanes());
    }

    public ArrayList<Passenger> getPassengers() {
        return simulationPreparer.getPassengers();
    }
}