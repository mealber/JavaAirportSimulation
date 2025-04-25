package state;

import factory.Airport;

public class ArrivedState implements PassengerState {
    @Override
    public boolean handle(Passenger passenger, Airport airport) {
        System.out.println(passenger.getName() + " has arrived at " + airport.getName() + ".");
        System.out.println(passenger.getName() + " is approaching check-in.");
        passenger.setState(new CheckInState()); //change passenger state to check-in
        return true; //passenger has arrived
    }
}