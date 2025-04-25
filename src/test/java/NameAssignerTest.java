import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import data.NameAssigner;
import factory.Airplane;
import factory.Airport;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.Passenger;

class NameAssignerTest {

    private NameAssigner na;

    //set private random
    private void injectRandom(Random r) throws Exception {
        Field f = NameAssigner.class.getDeclaredField("random");
        f.setAccessible(true);
        f.set(na, r);
    }

    //read private lists
    @SuppressWarnings("unchecked")
    private <T> List<T> getList(String fieldName) throws Exception {
        Field f = NameAssigner.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        return (List<T>) f.get(na);
    }

    @BeforeEach
    void setUp() throws Exception {
        na = new NameAssigner();
    }

    @Test
    void testResetInitializesAllPools() throws Exception {
        na.reset();
        //verify all pools are initialized
        assertEquals(3, getList("smallAirportNames").size());
        assertEquals(3, getList("mediumAirportNames").size());
        assertEquals(3, getList("largeAirportNames").size());
        assertEquals(20, getList("passengerNames").size());
        assertEquals(20, getList("airplaneNames").size());
    }

    @Test
    void testNameAirports_smallMediumLarge() throws Exception {
        //make random pick index 2
        injectRandom(new AlwaysTwoRandom());
        Airport mockA = mock(Airport.class);

        //test type small
        na.nameAirports(mockA, 0);
        verify(mockA).setName("PHX");

        //test type medium
        na.nameAirports(mockA, 1);
        verify(mockA).setName("DEN");

        //test type large
        na.nameAirports(mockA, 2);
        verify(mockA).setName("ORD");
    }

    @Test
    void testNameAirplanes_single() throws Exception {
        //make random pick 1
        injectRandom(new AlwaysOneRandom());
        Airplane p = mock(Airplane.class);
        ArrayList<Airplane> list = new ArrayList<>();
        list.add(p);

        na.nameAirplanes(list);

        verify(p).setName("SkyFlyer");
        //check taken name slot is set to null
        List<String> names = getList("airplaneNames");
        assertNull(names.get(1));
    }

    @Test
    void testNamePassengers_single() throws Exception {
        //make random pick 0
        injectRandom(new AlwaysZeroRandom());
        Passenger p = mock(Passenger.class);
        ArrayList<Passenger> list = new ArrayList<>();
        list.add(p);

        na.namePassengers(list);

        verify(p).setName("Alice");
        //taken slot should be null
        List<String> names = getList("passengerNames");
        assertNull(names.get(0));
    }

    //custom random class to always return 1
    private static class AlwaysOneRandom extends Random {
        //serialVersionUID to avoid SpotBugs warning
        private static final long serialVersionUID = 1L;
        
        @Override
        public int nextInt(int bound) {
            return 1;
        }
    }

    //custom random class to always return 2
    private static class AlwaysTwoRandom extends Random {
        //serialVersionUID to avoid SpotBugs warning
        private static final long serialVersionUID = 1L;
        
        @Override
        public int nextInt(int bound) {
            return 2;
        }
    }

    //custom random class to always return 0
    private static class AlwaysZeroRandom extends Random {
        //serialVersionUID to avoid SpotBugs warning
        private static final long serialVersionUID = 1L;
        
        @Override
        public int nextInt(int bound) {
            return 0;
        }
    }
}

