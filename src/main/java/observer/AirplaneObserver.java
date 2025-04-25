package observer;

import factory.Airplane;
import factory.Airport;
import state.Passenger;

public class AirplaneObserver implements Observer {
    SimulationView sim;

    public AirplaneObserver(SimulationView sim) {
        this.sim = sim;
    }

    @Override
    public void update() {
        for (Airplane air : sim.getAirplanes()) {
            System.out.println("Now boarding " + air.getName() + " at gate " 
                + air.getGate() + " .\n"
            );
            for (Passenger pas : sim.getPassengers()) {
                //checks if passengers are on the next flight to depart
                if (air.getDepartureTime() == pas.getDepartureTime()) { 
                    while (true) {
                        //runs boarding simulation for passengers on next flight
                        boolean advanced = pas.updateState(sim.getAirport());
                        if (!advanced) {
                            break; //passenger fails a boarding stage or finishes boarding
                        }
                    }
                }
            }
            //simulates plane departure
            System.out.println("");
            System.out.println(air.getName()
                + " is now departing at " + air.getDepartureTime() 
                + " to " + air.getDestination() + "."
            );
            System.out.println("---------------------------------------------");
        }
    }
}