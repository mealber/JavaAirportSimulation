package state;

import data.Flight;
import factory.Airplane;
import factory.Airport;

public class Passenger {
    private PassengerState state; //tracks state of passenger during airport processes
    private Flight flight; //passenger's assigned flight
    private String name; //passenger name

    /**
    *Creates new passenger initialized to arrived state,
    *meaning passenger has just arrived at airport.
    */
    public Passenger(Flight flight) {
        this.state = new ArrivedState(); //initial state of passenger     
        this.flight = flight; 
        this.name = null;
    }

    /**
    *Calls handle method of current state,
    *if passed, advances pasenger to next state.
    *
    *@param airport the airport passenger is at
    */
    public boolean updateState(Airport airport) {
        return state.handle(this, airport);
    }

    /**
    *Sets the current state of passenger.
    */
    public void setState(PassengerState state) {
        this.state = state;
    }

    public PassengerState getState() {
        return state;
    }

    public int getGate() {
        return flight.getGate();
    }

    public String getDestination() {
        return flight.getDestination();
    }

    public int getBoardingTime() {
        return flight.getBoardingTime();
    }

    public int getDepartureTime() {
        return flight.getBoardingTime() + 100;
    }

    public String getFlightName() {
        return flight.getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
