package factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    //concrete subclass for testing
    static class DummyAirport extends Airport {
        public DummyAirport(int checks, int gates, int runways) {
            super(checks, gates, runways);
        }
        @Override
        public Airport copy(String name) {
            DummyAirport c = new DummyAirport(getSecurityChecks(), getGates(), getRunways());
            c.setName(name);
            return c;
        }
    }

    @Test
    void testGettersAndSetName() {
        //create airport with specific values
        DummyAirport a = new DummyAirport(4, 5, 2);
        //securityChecks, gates, runways from constructor
        assertEquals(4, a.getSecurityChecks());
        assertEquals(5, a.getGates());
        assertEquals(2, a.getRunways());
        //name is null until set
        assertNull(a.getName());
        a.setName("home");
        assertEquals("home", a.getName());
    }

    @Test
    void testCopyProducesNewInstanceWithSameProperties() {
        DummyAirport a = new DummyAirport(1, 3, 1);
        a.setName("orig");
        Airport copy = a.copy("copyName");

        //copy must not be the same
        assertNotSame(a, copy);

        assertEquals(a.getSecurityChecks(), copy.getSecurityChecks());
        assertEquals(a.getGates(), copy.getGates());
        assertEquals(a.getRunways(), copy.getRunways());

        //copy has new name
        assertEquals("copyName", copy.getName());

        //original name unchanged
        assertEquals("orig", a.getName());
    }
}