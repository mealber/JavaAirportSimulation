package state;

import factory.Airport;

public class BoardingState implements PassengerState {
    @Override
    public boolean handle(Passenger passenger, Airport airport) {
        //get random number between 0.0 and 1.0
        double failingChance = Math.random();
        if (failingChance < 0.10) { //10% chance to miss boarding time

            //passenger misses boarding their plane
            System.out.println(passenger.getName() 
                + " missed boarding at gate " 
                + passenger.getGate() + ".");   

            return false;
        }

        //passenger successfully boards plane
        System.out.println(passenger.getName() 
            + " has boarded " + passenger.getFlightName() + " at "
            + passenger.getBoardingTime() + ".");

        return false; //return false to indicate final state is reached
    }
}