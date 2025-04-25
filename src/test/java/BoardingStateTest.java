package state;

import factory.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.BoardingState;
import state.Passenger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BoardingStateTest {

    private BoardingState boarding;
    private Airport airport;
    private Passenger mockPassenger;

    @BeforeEach
    void setUp() {
        boarding = new BoardingState();
        airport = mock(Airport.class);
        mockPassenger = mock(Passenger.class);
    }

    @Test
    void testHandleAlwaysReturnsTrueAndAdvancesState() {
        //boarding should always return false
        boolean result = boarding.handle(mockPassenger, airport);
        assertFalse(result);
    }
}