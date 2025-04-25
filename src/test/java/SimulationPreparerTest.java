import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import data.Flight;
import data.SimulationPreparer;
import factory.Airplane;
import factory.Airport;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.Passenger;

class SimulationPreparerTest {

    private SimulationPreparer prep;

    @BeforeEach
    void setUp() {
        prep = new SimulationPreparer();
    }

    @Test
    void testGenerateAirport() {
        //generate airport and check if non-null
        prep.generateAirport();
        Airport a = prep.getCurrentAirport();
        assertNotNull(a);
    }

    @Test
    void testGenerateAirplanes() {
        //need airport
        prep.generateAirport();
        Airport a = prep.getCurrentAirport();
        int gates = a.getGates();

        prep.generateAirplanes();
        List<Airplane> planes = prep.getAirplanes();
        //one airplane per gate
        assertEquals(gates, planes.size());
    }

    @Test
    void testGenerateFlights() {
        //generate airplanes
        prep.generateAirport();
        prep.generateAirplanes();

        prep.generateFlights();
        List<Flight> flights = prep.getFlights();
        //one flight per airplane
        assertEquals(prep.getAirplanes().size(), flights.size());
    }

    @Test
    void testResetClearsLists() {
        //run a full setup
        prep.setUp();
        assertFalse(prep.getAirplanes().isEmpty());
        assertFalse(prep.getFlights().isEmpty());

        //reset
        prep.reset();
        //lists should be empty
        assertEquals(0, prep.getAirplanes().size());
        assertEquals(0, prep.getFlights().size());
        assertEquals(0, prep.getPassengers().size());
    }
}