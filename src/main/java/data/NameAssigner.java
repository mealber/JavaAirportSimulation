package data;

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
    ArrayList<String> smallAirportNames; //name pool for small airports
    ArrayList<String> mediumAirportNames; //name pool for medium airports
    ArrayList<String> largeAirportNames; //name pool for large airports
    ArrayList<String> airplaneNames; //name pool for airplanes
    private Random random;

    /**
    *Initializes name lists by calling reset.
    */
    public NameAssigner() {
        reset(); //reset initializes names
        this.random = new Random(); //initializes random instance
    }

    /**
    *Names all passengers.
    *
    *@param passengers list of all passengers.
    */
    public void namePassengers(ArrayList<Passenger> passengers) {
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
    *Randomly names airport.
    *
    *@param airport the current airport.
    */
    public void nameAirports(Airport airport, int type) {
        int size = smallAirportNames.size();
        int rand = random.nextInt(size); //generate random index for name list

        switch(type) { //chooses name pool based on airport size
            case 0:
                airport.setName(smallAirportNames.get(rand)); //set name using random index
                break;
            case 1:
                airport.setName(mediumAirportNames.get(rand));
                break;
            default:
                airport.setName(largeAirportNames.get(rand));
                break;
        }
    }

    /**
    *Names all Airplanes.
    *
    *@param Airplanes list of all airplanes.
    */
    public void nameAirplanes(ArrayList<Airplane> airplanes) {
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
    public final void reset() {
        smallAirportNames = new ArrayList<>(List.of(
            "SEA", "MIA", "PHX"
        ));

        mediumAirportNames = new ArrayList<>(List.of(
            "ATL", "IAH", "DEN"
        ));

        largeAirportNames = new ArrayList<>(List.of(
            "LAX", "JFK", "ORD"
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