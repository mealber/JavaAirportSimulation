package observer;

import factory.Airplane;
import factory.Airport;
import state.Passenger;

public class RoundObserver implements Observer {
    Simulation s;
    Airport a;

    public RoundObserver(Simulation s) {
        this.s = s;
        this.a = null;
    }

    @Override
    public void update() {
        a = s.getAirport();
        System.out.println("---------------------------------------------");
        System.out.println(a.getName() + " Airport Log");
        System.out.println("---------------------------------------------");
        System.out.println("Passengers Serviced: " + s.getPassengers().size());
        System.out.println("Planes Departed: " + s.getAirplanes().size());

        try {
            System.out.println("\n-----Starting next round in 10 seconds-----");
            Thread.sleep(10000); //pause for 10 seconds between rounds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}