package observer;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import factory.Airplane;
import factory.Airport;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AirportObserverTest {

    //mock attributes
    @Mock
    private SimulationView sim;
    @Mock
    private Airport airportMock;
    @Mock
    private Airplane plane1;
    @Mock
    private Airplane plane2;

    private AirportObserver obs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        obs = new AirportObserver(sim);
    }

    @Test
    void testConstructorInitialState() {
        //airport starts null
        assertNull(obs.airport);
    }

    @Test
    void testUpdate() {
        //setup sim to return an airport and two planes
        when(sim.getAirport()).thenReturn(airportMock);
        when(sim.getAirplanes()).thenReturn(List.of(plane1, plane2));

        obs.update();

        //airport updated
        assertSame(airportMock, obs.airport);
        //maintenance called on each plane
        verify(plane1).doMaintenance();
        verify(plane2).doMaintenance();
    }
}