package observer;

import data.AirplaneSorter;
import data.SimulationPreparer;
import factory.Airplane;
import factory.Airport;
import java.util.ArrayList;
import state.Passenger;

public class Simulation implements Subject, SimulationView {
    private ArrayList<Observer> observers; //list of observers needed for simulation
    private SimulationPreparer simulationPreparer; //prepares objects for each round of simulation
    private int round; //current round of simulation

    //sorts airplanes by departure time
    private AirplaneSorter airplaneSorter = new AirplaneSorter();

    private AirportObserver airportObserver;
    private AirplaneObserver airplaneObserver;
    private RoundObserver roundObserver;

    /**
    *Creates new simulation object,
    *initializes observers and round number.
    */
    public Simulation() {
        observers = new ArrayList<>();
        round = 1; //start on round 1
        simulationPreparer = new SimulationPreparer();

        //initialize Observers
        airportObserver = new AirportObserver(this);
        airplaneObserver = new AirplaneObserver(this);
        roundObserver = new RoundObserver(this);
        
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
        for (Observer o : observers) {
            o.update();
        }
    }

    /**
    *Runs simulation.
    */
    public void runSimulation() {
        //prepare objects for simulation
        simulationPreparer.setUp();
 
        //notify observers of new round
        notifyObservers();

        //reset simulation objects before next round
        round++; //increment round
        simulationPreparer.reset();
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