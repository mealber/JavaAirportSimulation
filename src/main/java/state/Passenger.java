import factorymethod.Airplane;
import factorymethod.Airport;

public class Passenger {
    private PassengerState state; //tracks state of passenger during airport processes
    private Airplane flight; //passenger's assigned flight
    private String name; //passenger name

    /**
    *Creates new passenger initialized to arrived state.
    */
    public Passenger(Airplane flight) {
        this.state = new ArrivedState(); //initial state of passenger     
        this.flight = flight;
        this.name = null;  
    }

    public void updateState(Airport airport) {
        state.handle(this, airport);
    }

    public void setState(PassengerState state) {
        this.state = state;
    }

    public PassengerState getState() {
        return state;
    }

    public Airplane getFlight() {
        return flight;
    }

    public String getDestination() {
        return flight.getDestination();
    }

    public int getBoardingTime() {
        return calculateBoardingTime(flight.getDepartureTime());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
    *Calculates the boarding time of flight,
    *based on departure time.
    *
    *@param departureTime the time the flight departs
    *@return boarding time of flight
    */
    private int calculateBoardingTime(int departureTime) {
        return departureTime - 100; //board one hour before departure
    }
}
