package data;

import factory.*;
import java.util.ArrayList;
import java.util.Random;
import state.Passenger;

public class SimulationPreparer {
    Random random = new Random();
    NameAssigner nameAssigner = new NameAssigner();
    AirplanePreparer preparer = new AirplanePreparer();

    Airport currentAirport = null; //airport for current round of simulation

    ArrayList<Airplane> airplanes = new ArrayList<>(); //all airplanes used for simulation
    ArrayList<Passenger> passengers = new ArrayList<>(); //all passengers used for simulation
    ArrayList<Flight> flights = new ArrayList<>(); //all flights used for simulation

    int airportType = -1; //keeps track of airportType

    /**
    *Sets up airports and airplanes for simulation.
    */
    public final void setUp() {
        generateAirport();
        nameAssigner.nameAirports(currentAirport, airportType);

        generateAirplanes();
        nameAssigner.nameAirplanes(airplanes);

        generateFlights(); //generate flights for passengers

        generatePassengers();
        nameAssigner.namePassengers(passengers);
    }

    /**
    *Generates 10 airports of random size.
    */
    public void generateAirport() {
        AirportCreator airportCreator;
        int rand = random.nextInt(3);

        switch (rand) { //randomly choose airport size
            case 0:
                airportCreator = new SmallAirportCreator();
                airportType = 0;
                break;
            case 1:
                airportCreator = new MediumAirportCreator();
                airportType = 1;
                break;
            default:
                airportCreator = new LargeAirportCreator();
                airportType = 2;
                break;
        }

        currentAirport = airportCreator.createAirport();
    }

    /**
    *Generates airplanes of random size, one for each gate.
    */
    public void generateAirplanes() {
        //create airports at random for simulation
        for (int i = 0; i < currentAirport.getGates(); i++) { 
            AirplaneCreator airplaneCreator;
            int rand = random.nextInt(3);

            switch (rand) { //randomly choose airport size
                case 0:
                    airplaneCreator = new SmallPlaneCreator();
                    break;
                case 1:
                    airplaneCreator = new MediumPlaneCreator();
                    break;
                default:
                    airplaneCreator = new LargePlaneCreator();
                    break;
            }
            Airplane airplane = airplaneCreator.createAirplane();

            //assigns gate, destination, and departure time
            preparer.prepareAirplane(airplane, currentAirport);

            airplanes.add(airplane);
        }
    }

    /**
    *Generates 20 passengers and assigns them to random flights.
    */
    public void generatePassengers() {
        for (int i = 0; i < currentAirport.getGates() + random.nextInt(5); i++) {
            int size = flights.size();
            int rand = random.nextInt(size); //choose random flight from list

            Flight flight = flights.get(rand);
            Passenger passenger = new Passenger(flight); //create passenger and assign to flight

            passengers.add(passenger);
        }
    }

    /**
    *Returns airport of current round of simulation.
    */
    public Airport getCurrentAirport() {
        return currentAirport.copy(currentAirport.getName()); //return copy
    }

    public ArrayList<Airplane> getAirplanes() {
        return new ArrayList<>(airplanes); //return copy of airplanes list
    }

    public ArrayList<Passenger> getPassengers() {
        return new ArrayList<>(passengers); //return copy of passengers list    
    }

    public ArrayList<Flight> getFlights() {
        return new ArrayList<>(flights); //return copy of flights list    
    }

    public void generateFlights() {
        for (Airplane airplane : airplanes) {
            flights.add(airplane.toFlight()); //create flight for every airplane
        }
    }

    /**
    *Resets all simulation attributes.
    */
    public void reset() {
        preparer.setUp();
        nameAssigner.reset();
        currentAirport = null;
        airplanes.clear();
        passengers.clear();
        flights.clear();
        airportType = -1;
    }
}