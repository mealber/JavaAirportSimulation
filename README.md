# Link to screencast:
https://drive.google.com/file/d/1N-t-LaenkawZs5J_Z5bYWLffr4ri3C7B/view?usp=sharing

*I showcased the main branch in this video but all code has been moved over to branch DelB, all functionality and reports are the same.

# Design Patterns Implemented:

## Factory Method Design Pattern:
I used the factory method design pattern to create different types of airplanes and airports. The different types of airplanes ranged from small, medium, and large. They had varying names, capacities, fuel capacities, and maintenance procedures. The different types of airports also ranged from small, medium and large. They had varying names, gates, runways, and security checkpoints. Each different type of airplane and airport had a corresponding creator. The SimulationPreparer class used these creators to generate these different types at random.

Requirements Fulfilled:
- Different types of airplanes with varying capacities and fuel efficiencies.
- Simulate refueling and maintenance procedures.
- Limited number of gates, runways, and security checkpoints.

## State Design Pattern:
I used the state design pattern to handle passenger processing. I used different concrete states to represent different stages of the passenger processing process, and passengers are only able to change their state if they successfully passed the previous processing state. Each different concrete state has different chances of success and prints different information out to the console.
 
Requirements Fulfilled:
- Passengers arrive at the airport for different flights.
- Passengers check-in, go through security, and board their assigned flights.
- Simulate delays or issues with passenger processing.

## Observer Design Pattern:
The simulation class was implemented as a subject, and different observers(airplaneObserver, airportObserver, and roundObserver) were responsible for handling different parts of the simulation. The AirportObserver class printed out the status of the airport, the AirplaneObserver class printed out the activity logs of airplanes and passengers, and the RoundObserver class was responsible for generate report logs and passing the simulation briefly between rounds. After each round completes the runSimulation()  method resets and starts over.

Requirements Fulfilled:
- Run the simulation in cycles(One cycle is one day at an airport).
- Display the status of the airport (plane arrivals, plane departures, gate assignments) at each cycle.
- Generate reports or logs of airport activity (planes landed and passengers serviced)
- Airplanes depart for pre-determined destinations after a set amount of time

