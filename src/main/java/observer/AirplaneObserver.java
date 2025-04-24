package observer;
import state.*;
import factory.*;

public class AirplaneObserver implements Observer {
    Simulation s;

    public AirplaneObserver(Simulation s) {
        this.s = s;
    }

    @Override
    public void update() {
        for(Airplane a : s.getAirplanes()) {
            for(Passenger p : s.getPassengers()) {
                if(a.getDepartureTime() == p.getDepartureTime()) { //checks if passengers are on the next flight to depart
                    while(!(p.getState() instanceof BoardingState)) {
                        boolean advanced = p.updateState(s.getAirport()); //runs boarding simulation for passengers on next flight
                        if(!advanced) {
                            break; //breaks loop if passengers fail a boarding stage
                        }
                    }
                }
            }
        System.out.println(a.getName() + " is now departing at " + a.getDepartureTime() + " to " + a.getDestination() + ".");
        }
    }
}