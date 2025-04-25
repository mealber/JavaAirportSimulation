package state;

import factory.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SecurityStateTest {

    private SecurityState security;
    private Airport airport;
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        security = new SecurityState();
        airport = mock(Airport.class);
        passenger = mock(Passenger.class);
        when(passenger.getName()).thenReturn("tester");
    }

    @Test
    void testHandle_zeroSecurityChecks_immediatelyBoards() {
        boolean result = security.handle(passenger, airport);

        assertTrue(result);
        verify(passenger).setState(isA(BoardingState.class));
    }

    @Test
    void testHandle_eventuallyFailsAtCheckpoint() {
        //simulate multiple checkpoints, expect at least one failure
        when(airport.getSecurityChecks()).thenReturn(3);

        boolean sawFalse = false;
        for (int i = 0; i < 200 && !sawFalse; i++) {
            reset(passenger);
            when(passenger.getName()).thenReturn("tester");
            boolean res = security.handle(passenger, airport);
            if (!res) {
                sawFalse = true;
                verify(passenger, never()).setState(any());
            }
        }
        assertTrue(sawFalse);
    }

    @Test
    void testHandle_eventuallySucceedsAllCheckpoints() {
        //simulate multiple checkpoints, expect at least one full success
        when(airport.getSecurityChecks()).thenReturn(3);

        boolean sawTrue = false;
        for (int i = 0; i < 200 && !sawTrue; i++) {
            reset(passenger);
            when(passenger.getName()).thenReturn("tester");
            boolean res = security.handle(passenger, airport);
            if (res) {
                sawTrue = true;
                verify(passenger).setState(isA(BoardingState.class));
            }
        }
        assertTrue(sawTrue);
    }
}