package observer;

import factory.Airplane;
import factory.Airport;

public class AirportObserver implements Observer {
    SimulationView simulation;
    Airport airport;

    public AirportObserver(SimulationView s) {
        this.simulation = s;
        airport = null; //no airport yet
    }

    @Override
    public void update() {
        airport = simulation.getAirport(); //update airport to current airport
        System.out.println("---------------------------------------------");
        System.out.println("Simulation Round " + simulation.getRound() + ":");
        System.out.println("---------------------------------------------");

        //display airport resources
        System.out.println("Current Airport: " + airport.getName());
        System.out.println("Gates Available: " + airport.getGates());
        System.out.println("Runways Available: " + airport.getRunways());
        System.out.println("Security Checks Required: " + airport.getSecurityChecks());
        System.out.println("---------------------------------------------");

        //display airplanes and gate assignments
        for (Airplane a : simulation.getAirplanes()) {
            System.out.println(a.getName() + " has landed at " + airport.getName() 
                + " Airport. Gate Assignment: " + a.getGate()
            );
            //display maintenance for each plane
            a.doMaintenance();
        }
        System.out.println("---------------------------------------------");
    }
}