package observer;

import factory.Airplane;
import factory.Airport;
import java.util.List;
import state.Passenger;

/** 
*Read-only version of the simulation state.
*/
public interface SimulationView {
    int getRound();

    Airport getAirport();

    List<Airplane> getAirplanes();

    List<Passenger> getPassengers();
}