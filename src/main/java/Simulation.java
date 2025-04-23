import java.util.ArrayList;
import factory.*;
import state.*;
import data.*;

public class Simulation {
//initialize, then name, then use observer to call things when appropriate,
//clear list and display logs at the end of every simulation

    public void setUp() {
        AirplaneCreator airplaneCreator = new SmallPlaneCreator(); //TODO decided to group creators into small medium and large, pass name through constructor
        AirportCreator airportCreator = new SmallAirportCreator(); //TODO same for airports 

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Airport> airports = new ArrayList<>();
        ArrayList<Airplane> airplanes = new ArrayList<>();
        ArrayList<Flight> flights = new ArrayList<>();

        names.add("Bob");
        names.add("Sarah");

        Airport lax = airportCreator.createAirport();
        airports.add(lax);

        Airplane boeing = airplaneCreator.prepareAirplane("Paris", 3, 1200); //TODO create set/get name methods for the airplanes
        airplanes.add(boeing);

        flights.add(boeing.toFlight());

        Passenger p1 = new Passenger(flights.get(0));
        p1.setName(names.get(0));

        //testing changing through different passenger states
        while(p1.updateState(airports.get(0))) {
            p1.updateState(airports.get(0));

            if(p1.getState() instanceof BoardingState) {
                break;
            }
        }
    }
}