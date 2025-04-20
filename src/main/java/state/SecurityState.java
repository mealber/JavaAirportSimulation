import factorymethod.Airport;

public class SecurityState implements PassengerState {
    @Override
    public boolean handle(Passenger passenger, Airport airport) {
        for (int i = 0; i < airport.getSecurityChecks(); i++) {
            double failingChance = Math.random();
            if (failingChance < 0.05) { //5% chance to fail security check points

                System.out.println(passenger.getName() 
                    + " failed security checkpoint " 
                    + (i + 1) + ".");   

                return false;
            }

            System.out.println(passenger.getName() 
                + " passed security checkpoint " 
                + (i + 1) + ".");
        }

        passenger.setState(new BoardingState()); //change state if all security points are passed
        return true;
    }
}