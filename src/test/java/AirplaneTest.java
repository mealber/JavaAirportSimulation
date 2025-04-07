import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AirplaneTest {
    @Test
    public void testGetCapacity() {
        Airplane boeing = new Boeing();
        assertEquals(300, boeing.getCapacity());
    }
}