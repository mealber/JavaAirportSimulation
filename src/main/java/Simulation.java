import java.util.ArrayList;
import factory.*;
import state.*;
import data.*;

public class Simulation {

    public void setUp() {
        AirplaneCreator airplaneCreator = new BoeingCreator();
        AirportCreator airportCreator = new LaxAirportCreator();

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
    }
}