import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.mockito.Mockito.*;

import observer.*;

class SimulationTest {

    private Simulation simulation;

    @BeforeEach
    void setUp() throws Exception {
        simulation = new Simulation();

        //clear simulation observers for sake of testing
        Field obsField = Simulation.class.getDeclaredField("observers");
        obsField.setAccessible(true);
        List<Observer> obsList = (List<Observer>) obsField.get(simulation);
        obsList.clear();
    }

    @Test
    void testObserversAreNotifiedDuringRunSimulation() {
        Observer observer = mock(Observer.class);
        simulation.addObserver(observer);

        simulation.runSimulation();

        verify(observer, times(1)).update();
    }

    @Test
    void testRoundIncrementsEachSimulation() {
        // runSimulation will return immediately
        simulation.runSimulation();
        simulation.runSimulation();
        //round starts at 1, now should be 3
        assertEquals(3, simulation.getRound());
    }

    @Test
    void testCanAddAndRemoveObserver() {
        Observer observer = mock(Observer.class);
        simulation.addObserver(observer);
        simulation.removeObserver(observer);

        simulation.runSimulation(); 
        verify(observer, never()).update();
    }
}