import java.util.ArrayList;
import factory.*;
import java.util.List;
import state.Passenger;
import java.util.Random;
import state.*;

/**
*This class chooses random names for Passengers,
*Airports, and Airplanes from name pools to,
*help automate the simulation.
*/
public class NameAssigner {
    ArrayList<String> passengerNames; //name pool for passengers
    ArrayList<String> airportNames; //name pool for airports
    ArrayList<String> airplaneNames; //name pool for airplanes

    /**
    *Initializes name lists by calling reset.
    */
    public NameAssigner() {
        reset(); //reset initializes names
    }

    /**
    *Names all passengers.
    *
    *@param passengers list of all passengers.
    */
    public void namePassengers(ArrayList<Passenger> passengers) {
        Random random = new Random();
        int size = passengerNames.size();

        for(Passenger p : passengers) {
            int rand = random.nextInt(size); //generate random index for name list

            while(passengerNames.get(rand) == null) {
                rand = random.nextInt(size); //generate new index if name has been used
            }
            p.setName(passengerNames.get(rand)); //set name using random index
            passengerNames.set(rand, null); //change used names to null to avoid duplicates
        }
    }

    /**
    *Names all airports.
    *
    *@param airports list of all airports.
    */
    public void nameAirports(ArrayList<Airport> airports) {
        Random random = new Random();
        int size = airportNames.size();

        for(Airport a : airports) {
            int rand = random.nextInt(size); //generate random index for name list

            while(airportNames.get(rand) == null) {
                rand = random.nextInt(size); //generate new index if name has been used
            }
            a.setName(airportNames.get(rand)); //set name using random index
            airportNames.set(rand, null); //change used names to null to avoid duplicates
        }
    }

    /**
    *Names all Airplanes.
    *
    *@param Airplanes list of all airplanes.
    */
    public void nameAirplanes(ArrayList<Airplane> airplanes) {
        Random random = new Random();
        int size = airplaneNames.size();

        for(Airplane a : airplanes) {
            int rand = random.nextInt(size); //generate random index for name list

            while(airplaneNames.get(rand) == null) {
                rand = random.nextInt(size); //generate new index if name has been used
            }
            a.setName(airplaneNames.get(rand)); //set name using random index
            airplaneNames.set(rand, null); //change used names to null to avoid duplicates
        }
    }

    /**
    *Resets name queues by re-initializing them.
    */
    public void reset() {
        airportNames = new ArrayList<>(List.of(
            "LAX", "JFK", "ORD", "ATL", "DFW",
            "DEN", "SFO", "SEA", "MIA", "PHX"
        ));

        passengerNames = new ArrayList<>(List.of(
            "Alice", "Bob", "Charlie", "Diana", "Ethan",
            "Fiona", "George", "Hannah", "Ian", "Jade",
            "Kevin", "Luna", "Mike", "Nina", "Oscar",
            "Paula", "Quinn", "Ryan", "Sophie", "Tom"
        ));

        airplaneNames = new ArrayList<>(List.of(
            "JetOne", "SkyFlyer", "CloudCruiser", "AirDart", "ZoomJet",
            "Falcon", "Comet", "AirNova", "JetStream", "Nimbus",
            "Eagle", "Starliner", "Thunderbird", "Voyager", "PulseJet",
            "AeroX", "LiftAir", "SkyRider", "Streak", "Winglet"
        ));
    }
}