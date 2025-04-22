import java.util.ArrayList;
import factory.*;
import state.*;
import data.*;

public class Simulation {

    public void setUp() {
        AirplaneCreator airplaneCreator = new BoeingCreator(); //TODO decided to group creators into small medium and large, pass name through constructor
        AirportCreator airportCreator = new LaxAirportCreator(); //TODO same for airports 

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Airport> airports = new ArrayList<>();
        ArrayList<Airplane> airplanes = new ArrayList<>();
        ArrayList<Flight> flights = new ArrayList<>();

        names.add("Bob");
        names.add("Sarah");

        Airport lax = airportCreator.createAirport();
        airports.add(lax);

        Airplane boeing = airplaneCreator.prepareAirplane("Paris", 3, 1200);
        airplanes.add(boeing);

        flights.add(boeing.toFlight());

        Passenger p1 = new Passenger(names.get(0),flights.get(0));

        //testing changing through different passenger states
        while(p1.updateState(airports.get(0))) {
            p1.updateState(airports.get(0));

            if(p1.getState() instanceof BoardingState) {
                break;
            }
        }
System.out.println("Loop exited");
    }
}