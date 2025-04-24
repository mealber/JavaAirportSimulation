package observer;

import factory.Airplane;
import factory.Airport;
import state.Passenger;

public class RoundObserver implements Observer {
    SimulationView sim;
    Airport air;

    public RoundObserver(SimulationView sim) {
        this.sim = sim;
        this.air = null;
    }

    @Override
    public void update() {
        air = sim.getAirport();
       
        //print airport log
        System.out.println("---------------------------------------------");
        System.out.println(air.getName() + " Airport Log");
        System.out.println("---------------------------------------------");
        System.out.println("Passengers Serviced: " + sim.getPassengers().size());
        System.out.println("Planes Departed: " + sim.getAirplanes().size());

        //pause simulation for 10 seconds between rounds
        try {
            System.out.println("\n-----Starting next round in 10 seconds-----");
            Thread.sleep(10000); //pause for 10 seconds between rounds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}