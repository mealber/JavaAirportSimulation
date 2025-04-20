import factorymethod.Airport;

public interface PassengerState {
    boolean handle(Passenger passenger, Airport airport);
}