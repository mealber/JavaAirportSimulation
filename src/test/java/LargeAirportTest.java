import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import factory.Airport;
import factory.LargeAirport;
import factory.LargeAirportCreator;
import org.junit.jupiter.api.Test;

public class LargeAirportTest {
    
    @Test
    public void testLargeAirportProperties() {
        Airport airport = new LargeAirport();

        assertEquals(3, airport.getSecurityChecks());
        assertEquals(7, airport.getGates());
        assertEquals(6, airport.getRunways());
    }

    @Test
    public void testLargeAirportCopy() {
        Airport original = new LargeAirport();
        original.setName("Phoenix Sky Harbor");

        Airport copy = original.copy("LAX");

        assertNotNull(copy);
        assertEquals("LAX", copy.getName());
        assertEquals(3, copy.getSecurityChecks());
        assertEquals(7, copy.getGates());
        assertEquals(6, copy.getRunways());
    }

    @Test
    public void testLargeAirportCreator() {
        LargeAirportCreator creator = new LargeAirportCreator();
        Airport airport = creator.createAirport();

        assertNotNull(airport);
        assertEquals(3, airport.getSecurityChecks());
        assertEquals(7, airport.getGates());
        assertEquals(6, airport.getRunways());
    }
}