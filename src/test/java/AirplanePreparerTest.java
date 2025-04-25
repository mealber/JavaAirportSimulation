import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import data.AirplanePreparer;
import factory.Airplane;
import factory.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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