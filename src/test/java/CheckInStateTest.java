package state;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import factory.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.CheckInState;
import state.Passenger;
import state.PassengerState;
import state.SecurityState;

class CheckInStateTest {

    private CheckInState checkIn;
    private Airport airport;
    private Passenger mockPassenger;

    @BeforeEach
    void setUp() {
        checkIn = new CheckInState();
        airport = mock(Airport.class);
        when(airport.getName()).thenReturn("XYZ");
        //mock passenger
        mockPassenger = mock(Passenger.class);
        when(mockPassenger.getName()).thenReturn("tester");
    }

    @Test
    void testHandleEventuallyFails_withoutChangingState() {
        //observe the false branch at least once in 200 tries
        boolean sawFalse = false;
        for (int i = 0; i < 200 && !sawFalse; i++) {
            //reset interactions
            reset(mockPassenger);
            boolean result = checkIn.handle(mockPassenger, airport);
            if (!result) {
                sawFalse = true;
                //on failure, setState should not be called
                verify(mockPassenger, never()).setState(any());
            }
        }
        assertTrue(sawFalse);
    }

    @Test
    void testHandleEventuallySucceeds_andTransitionsState() {
        //observe the true branch at least once in 200 tries
        boolean sawTrue = false;
        for (int i = 0; i < 200 && !sawTrue; i++) {
            reset(mockPassenger);
            boolean result = checkIn.handle(mockPassenger, airport);
            if (result) {
                sawTrue = true;
                //on success, passenger.state must be set to SecurityState
                verify(mockPassenger).setState(isA(SecurityState.class));
            }
        }
        assertTrue(sawTrue);
    }
}