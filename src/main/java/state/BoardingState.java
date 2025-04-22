import factory.Airport;

public class BoardingState implements PassengerState {
    @Override
    public boolean handle(Passenger passenger, Airport airport) {
        //get random number between 0.0 and 1.0
        double failingChance = Math.random();
        if (failingChance < 0.05) { //5% chance to miss boarding time

            //passenger misses boarding their plane
            System.out.println(passenger.getName() 
                + " missed boarding at gate " 
                + passenger.getFlight().getGate() + ".");   

            return false;
        }

        //passenger successfully boards plane
        System.out.println(passenger.getName() 
            + " has boarded at gate " 
            + passenger.getFlight().getGate() + ".");

        return true;
    }
}