import factorymethod.Airport;

public class CheckInState implements PassengerState {
    @Override
    public boolean handle(Passenger passenger, Airport airport) {
        double failingChance = Math.random();
        if (failingChance < 0.05) { //5% chance to fail check-in

            System.out.println(passenger.getName() 
                + " has failed to check in at " 
                + airport.getName() + ".");

            return false;
        }

        System.out.println(passenger.getName() + " has checked-in at " + airport.getName() + ".");
        System.out.println(passenger.getName() + " is approaching security check point.");
        passenger.setState(new SecurityState()); //change state if check-in is successful
        return true;
    }
}