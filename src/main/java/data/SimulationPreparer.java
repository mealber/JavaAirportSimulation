
package data;

import java.util.ArrayList;
import factory.*;
import state.*;
import java.util.Random;

public class SimulationPreparer {
    Random random = new Random();
    NameAssigner nameAssigner = new NameAssigner();
    AirplanePreparer preparer = new AirplanePreparer();

    public Airport currentAirport; //airport for current round of simulation

    ArrayList<Airplane> airplanes = new ArrayList<>(); //all airplanes used for simulation
    ArrayList<Passenger> passengers = new ArrayList<>(); //all passengers used for simulation
    ArrayList<Flight> flights = new ArrayList<>(); //all flights used for simulation

    /**
    *Sets up airports and airplanes for simulation.
    */
    public void setUp() {
        generateAirport();
        generateAirplanes();
        generatePassengers();

        nameAssigner.nameAirports(currentAirport);
        nameAssigner.nameAirplanes(airplanes);
        nameAssigner.namePassengers(passengers);
    }

    /**
    *Generates 10 airports of random size.
    */
    private void generateAirport() {
        AirportCreator airportCreator;
        int rand = random.nextInt(3);

        switch(rand) { //randomly choose airport size
            case 0:
                airportCreator = new SmallAirportCreator();
                break;
            case 1:
                airportCreator = new MediumAirportCreator();
                break;
            case 2:
                airportCreator = new LargeAirportCreator();
                break;
            default:
                airportCreator = new SmallAirportCreator();
                break;
            }

        currentAirport = airportCreator.createAirport();
    }

    /**
    *Generates 10 airplanes of random size and prepares them for simulation.
    */
    private void generateAirplanes() {
        for(int i = 0; i < 10; i++) { //create 10 airports at random for simulation
            AirplaneCreator airplaneCreator;
            int rand = random.nextInt(3);

            switch(rand) { //randomly choose airport size
                case 0:
                    airplaneCreator = new SmallPlaneCreator();
                    break;
                case 1:
                    airplaneCreator = new MediumPlaneCreator();
                    break;
                case 2:
                    airplaneCreator = new LargePlaneCreator();
                    break;
                default:
                    airplaneCreator = new SmallPlaneCreator();
                    break;
            }
            Airplane airplane = airplaneCreator.createAirplane();

            //assigns gate, destination, and departure time
            preparer.prepareAirplane(airplane, currentAirport);

            flights.add(airplane.toFlight()); //create flight for airplane

            airplanes.add(airplane);
        }
    }

    /**
    *Generates 20 passengers and assigns them to random flights.
    */
    private void generatePassengers() {
        for(int i = 0; i < 20; i++) {
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
        return currentAirport;
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;    
    }

    public void reset() {
        preparer.setUp();
        currentAirport = null;
        airplanes.clear();
        passengers.clear();
    }
}