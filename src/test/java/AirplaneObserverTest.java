import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import factory.Airplane;
import factory.Airport;
import java.util.List;
import observer.AirplaneObserver;
import observer.SimulationView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import state.Passenger;

class AirplaneObserverTest {

    @Mock
    private SimulationView sim;
    @Mock
    private Airplane plane;
    @Mock
    private Passenger matchingPas;
    @Mock
    private Passenger nonMatchingPas;
    @Mock
    private Airport airportMock;

    private AirplaneObserver obs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        obs = new AirplaneObserver(sim);
        //mock airport
        when(sim.getAirport()).thenReturn(airportMock);
    }

    @Test
    void testUpdate_runsBoarding() {
        //setup one airplane with departureTime 42
        when(plane.getDepartureTime()).thenReturn(42);
        when(plane.getName()).thenReturn("X");
        when(plane.getGate()).thenReturn(7);
        //passenger matches departureTime
        when(matchingPas.getDepartureTime()).thenReturn(42);
        //boarding advances twice then stops
        when(matchingPas.updateState(airportMock)).thenReturn(true, true, false);

        when(sim.getAirplanes()).thenReturn(List.of(plane));
        when(sim.getPassengers()).thenReturn(List.of(matchingPas));

        obs.update();

        //verify updateState called until false returned
        verify(matchingPas, times(3)).updateState(airportMock);
    }

    @Test
    void testUpdate_skipsPassengers() {
        //setup airplane departureTime 10
        when(plane.getDepartureTime()).thenReturn(10);
        when(plane.getName()).thenReturn("Y");
        when(plane.getGate()).thenReturn(3);
        //passenger has different departureTime
        when(nonMatchingPas.getDepartureTime()).thenReturn(5);

        when(sim.getAirplanes()).thenReturn(List.of(plane));
        when(sim.getPassengers()).thenReturn(List.of(nonMatchingPas));

        obs.update();

        //verify no boarding attempted
        verify(nonMatchingPas, never()).updateState(any());
    }
}