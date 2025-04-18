import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import factoryMethod.*;

public class AirplaneTest {
    @Test
    public void testGetCapacity() {
        AirplaneCreator creator = new BoeingCreator();
        Airplane boeing = creator.createAirplane();
        assertEquals(500, boeing.getCapacity());
    }
}