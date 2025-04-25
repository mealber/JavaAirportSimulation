package state;

import factory.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ArrivedStateTest {

    private ArrivedState arrived;
    private Passenger mockPassenger;
    private Airport mockAirport;

    @BeforeEach
    void setUp() {
        arrived = new ArrivedState();
        mockPassenger = mock(Passenger.class);
        when(mockPassenger.getName()).thenReturn("p");
        mockAirport = mock(Airport.class);
        when(mockAirport.getName()).thenReturn("a");
    }

    @Test
    void testHandle_returnsTrueAndSetsCheckInState() {
        //arrived.handle should always return true and transition to CheckInState
        boolean result = arrived.handle(mockPassenger, mockAirport);
        assertTrue(result);
        verify(mockPassenger).setState(isA(CheckInState.class));
    }
}