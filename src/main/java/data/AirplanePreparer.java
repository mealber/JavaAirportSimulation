package data;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import factory.*;

public class AirplanePreparer {
    Random random = new Random();

    ArrayList<String> destinations;
    ArrayList<Integer> departures;
    ArrayList<Integer> takenGates = new ArrayList<>();

    public AirplanePreparer() {
        setUp();
    }

    /**
    *Prepares airplane for flight simulation by setting, 
    *destination, gate number, and departure time.
    *
    *@param airplane airplane to be prepared.
    */
    public void prepareAirplane(Airplane plane, Airport airport) {
        plane.setDestination(assignDestination());
        plane.setGate(assignGate(airport));
        plane.setDepartureTime(assignDepartureTime());
    }

    private int assignGate(Airport airport) {
        int numGates = airport.getGates();
        int rand = random.nextInt(numGates); //choose random gate

        do {
            rand = random.nextInt(numGates) + 1; //get values 1 to numGates
        } while (takenGates.contains(rand)); //re-pick if taken

        takenGates.add(rand); //mark gate as taken
        return rand;
    }

    private String assignDestination() {
        int size = destinations.size();
        int rand = random.nextInt(size); //choose random destination

        while(destinations.get(rand) == null) { //re-pick if destination has been taken
            rand = random.nextInt(size);
        }

        String destination = destinations.get(rand);
        destinations.set(rand,null);

        return destination;
    }

    private int assignDepartureTime() {
        int size = departures.size();
        int rand = random.nextInt(size); //choose random departure time

        while(departures.get(rand) == -1) { //re-pick if departure time has been taken
            rand = random.nextInt(size);
        }

        int departure = departures.get(rand);
        departures.set(rand, -1);

        return departure;
    }

    public final void setUp() {
        //initialize list of 20 destinations
        destinations = new ArrayList<>(Arrays.asList(
            "New York", "Los Angeles", "Chicago", "Dallas", "Denver",
            "Seattle", "San Francisco", "Boston", "Miami", "Atlanta",
            "Houston", "Phoenix", "Orlando", "Las Vegas", "Detroit",
            "Minneapolis", "Philadelphia", "San Diego", "Charlotte", "Salt Lake City"
        ));

        //initialize list of 20 departure times in 24hr format
        departures = new ArrayList<>(Arrays.asList(
            600, 645, 700, 730, 800,
            900, 945, 1030, 1100, 1145,
            1200, 1245, 1345, 1430, 1530,
            1600, 1700, 1800, 1900, 2030
        ));

        takenGates.clear();
        takenGates.add(-1);
    }
}