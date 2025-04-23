import static org.junit.jupiter.api.Assertions.assertEquals;

import factory.Airplane;
import factory.AirplaneCreator;
import factory.SmallPlaneCreator;
import org.junit.jupiter.api.Test;

public class AirplaneTest {
    /**
    *This method tests that the fuel capacity of a boeing matches the expected set value.
    */
    @Test
    public void testGetCapacity() {
        AirplaneCreator creator = new SmallPlaneCreator();
        Airplane boeing = creator.createAirplane();
        assertEquals(500, boeing.getCapacity());
    }
}