package state;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import factory.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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