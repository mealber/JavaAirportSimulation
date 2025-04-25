import data.AirplanePreparer;
import factory.Airplane;
import factory.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AirplanePreparerTest {

    private AirplanePreparer prep;

    @BeforeEach
    void setUp() {
        prep = new AirplanePreparer();
    }

    @Test
    void testPrepareAirplane_callsAllSetters() {
        //prepareAirplane should call setDestination, setGate, setDepartureTime on plane
        Airplane plane = mock(Airplane.class);
        Airport airport = mock(Airport.class);
        when(airport.getGates()).thenReturn(3);

        prep.prepareAirplane(plane, airport);

        verify(plane).setDestination(anyString());
        verify(plane).setGate(anyInt());
        verify(plane).setDepartureTime(anyInt());
    }

}