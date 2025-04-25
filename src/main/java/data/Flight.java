package data;

public class Flight {
    private String destination;
    private int gate;
    private int boardingTime;
    private String name;

    /**
    *Creates immutable flight object,
    *contains neccesary info for passengers,
    *this includes destination, gate number, and boarding time.
    */
    public Flight(String destination, int gate, int departureTime, String name) {
        this.destination = destination;
        this.gate = gate;
        this.boardingTime = calculateBoardingTime(departureTime);
        this.name = name;
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

    public String getDestination() {
        return destination;
    }

    public int getGate() {
        return gate;
    }

    public int getBoardingTime() {
        return boardingTime;
    }

    public String getName() {
        return name;
    }
}