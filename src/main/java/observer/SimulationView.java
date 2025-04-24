package observer;

import factory.Airplane;
import factory.Airport;
import state.Passenger;
import java.util.List;

/** 
*Read-only version of the simulation state.
*/
public interface SimulationView {
    int getRound();
    Airport getAirport();
    List<Airplane> getAirplanes();
    List<Passenger> getPassengers();
}