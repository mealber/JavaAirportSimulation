import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import data.Flight;
import factory.Airplane;
import org.junit.jupiter.api.Test;

public class AirplaneTest {

    //concrete subclass for testing abstract Airplane
    static class DummyAirplane extends Airplane {
        public DummyAirplane(int capacity, int fuelCap) {
            super(capacity, fuelCap);
        }

        @Override
        public void doMaintenance() {
            //dummy implementation for testing
        }
    }

    @Test
    public void testAirplanePropertiesAndToFlight() {
        DummyAirplane plane = new DummyAirplane(100, 2000);

        //check constructor values
        assertEquals(100, plane.getCapacity());
        assertEquals(2000, plane.getFuelCap());
        assertEquals(-1, plane.getGate());
        assertNull(plane.getDestination());
        assertEquals(-1, plane.getDepartureTime());
        assertNull(plane.getName());

        //set values
        plane.setGate(3);
        plane.setDestination("New York");
        plane.setDepartureTime(1500);
        plane.setName("Flight 101");

        //check setters and getters
        assertEquals(3, plane.getGate());
        assertEquals("New York", plane.getDestination());
        assertEquals(1500, plane.getDepartureTime());
        assertEquals("Flight 101", plane.getName());

        //test toFlight
        Flight flight = plane.toFlight();
        assertEquals("New York", flight.getDestination());
        assertEquals(3, flight.getGate());
        assertEquals(1400, flight.getBoardingTime());
        assertEquals("Flight 101", flight.getName());
    }
}