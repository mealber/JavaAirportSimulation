import factory.Airport;

public interface PassengerState {
    /**
    *Method that contains the events of each state.
    */
    boolean handle(Passenger passenger, Airport airport);
}