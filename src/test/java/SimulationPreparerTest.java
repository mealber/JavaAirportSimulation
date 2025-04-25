import data.SimulationPreparer;
import factory.Airport;
import factory.Airplane;
import data.Flight;
import state.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void testSetUpChainsAll() {
        //setUp must run all phases in order
        prep.setUp();
        //airport non-null
        assertNotNull(prep.getCurrentAirport());
        //airplanes = gates
        assertEquals(prep.getCurrentAirport().getGates(), prep.getAirplanes().size());
        //flights = airplanes
        assertEquals(prep.getAirplanes().size(), prep.getFlights().size());
        //passengers >= 0
        assertTrue(prep.getPassengers().size() >= 0);
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