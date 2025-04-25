package state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import data.Flight;
import factory.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.ArrivedState;
import state.CheckInState;

class PassengerTest {

    private Passenger passenger;
    private Flight mockFlight;

    @BeforeEach
    void setUp() {
        mockFlight = mock(Flight.class);
        when(mockFlight.getGate()).thenReturn(5);
        when(mockFlight.getDestination()).thenReturn("dest");
        when(mockFlight.getBoardingTime()).thenReturn(400);
        when(mockFlight.getName()).thenReturn("FL123");
        passenger = new Passenger(mockFlight);
    }

    @Test
    void testGettersAndSetName() {
        //setName and getName
        passenger.setName("n");
        assertEquals("n", passenger.getName());
        //flight-based getters
        assertEquals(5, passenger.getGate());
        assertEquals("dest", passenger.getDestination());
        assertEquals(400, passenger.getBoardingTime());
        assertEquals(400 + 100, passenger.getDepartureTime());
        assertEquals("FL123", passenger.getFlightName());
    }

    @Test
    void testUpdateState_advancesFromArrivedToCheckIn() {
        //mock airport only for name
        Airport airport = mock(Airport.class);
        when(airport.getName()).thenReturn("x");
        //initial state is ArrivedState
        assertTrue(passenger.getState() instanceof ArrivedState);
        boolean ok = passenger.updateState(airport);
        assertTrue(ok);
        assertTrue(passenger.getState() instanceof CheckInState);
    }
}