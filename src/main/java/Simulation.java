import java.util.ArrayList;
import factory.*;
import state.*;
import data.*;
import java.util.Random;

public class Simulation {
    Random random = new Random();
    NameAssigner nameAssigner = new NameAssigner();
    AirplanePreparer preparer = new AirplanePreparer();
    public Airport currentAirport; //airport for current round of simulation

    ArrayList<Airport> airports = new ArrayList<>(); //all airports used for simulation
    ArrayList<Airplane> airplanes = new ArrayList<>(); //all airplanes used for simulation
    ArrayList<Passenger> passengers = new ArrayList<>(); //all passengers used for simulation
    ArrayList<Flight> flights = new ArrayList<>(); //all flights used for simulation

    /**
    *Sets up airports and airplanes for simulation.
    */
    public void setUp() {
        generateAirports();
        currentAirport = getCurrentAirport();

        generateAirplanes();
        generatePassengers();

        nameAssigner.nameAirports(airports);
        nameAssigner.nameAirplanes(airplanes);
        nameAssigner.namePassengers(passengers);
    }

    /**
    *Generates 10 airports of random size.
    */
    public void generateAirports() {
        for(int i = 0; i < 10; i++) { //create 10 airports at random for simulation
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
            Airport airport = airportCreator.createAirport();
            airports.add(airport);
        }
    }

    /**
    *Generates 10 airplanes of random size and prepares them for simulation.
    */
    public void generateAirplanes() {
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
            preparer.prepareAirplane(airplane, getCurrentAirport());

            flights.add(airplane.toFlight()); //create flight for airplane

            airplanes.add(airplane);
        }
    }

    /**
    *Generates 20 passengers and assigns them to random flights.
    */
    public void generatePassengers() {
        for(int i = 0; i < 20; i++) {
            int size = flights.size();
            int rand = random.nextInt(size); //choose random flight from list

            Flight flight = flights.get(rand);
            Passenger passenger = new Passenger(flight); //create passenger and assign to flight

            passengers.add(passenger);
        }
    }

    public Airport getCurrentAirport() {
        int size = airports.size();
        int rand = random.nextInt(size); //choose random airport from list

        return airports.get(rand);
    }
}