import java.util.Scanner;	

public class Simulate {
	
	private int runway;
	private Inputs userInput;
	private ProbilityCalculator probCalc;
	private LLqueueTakeOff qTakeOff;
	private LLqueueLanding qLand;
	private int crashed;
	private int landed;
	private int takeOff;
	private int takingOff;
	private int landing;
	private int timeWaitingForTakeOff;
	private int timeWaitingForLand;
	private int TotalLandAttempts;
	private int TotalDepAttempts;
	
	
	public Simulate(){
		userInput = new Inputs();
		probCalc = new ProbilityCalculator();
		qTakeOff = new LLqueueTakeOff();
		qLand = new LLqueueLanding();
		runway = 0;
		takeOff = 0;
		landed = 0;
		takingOff = 0;
		landing =0;
		TotalDepAttempts = 0;
		TotalLandAttempts = 0;
	}
	
	// Reads all inputs
	public void userInputs() {
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("Welcome to the airport simulation");
		System.out.println("Please enter the following information.");
		
		System.out.println("Time in minutes to Land:");
		int input = kbd.nextInt();
		this.userInput.setLandTime(input); 
		
		System.out.println("Time in minutes to Takeoff  ");
		input = kbd.nextInt();		
		this.userInput.setTakeoffTime(input);
		
		System.out.println("Average time between arrivals  ");
		input = kbd.nextInt();
		this.userInput.setAvgTimeLand(input);
		
		System.out.println("Average time between departures ");
		input = kbd.nextInt();
		this.userInput.setAvgTimeTakeOff(input);
		
		System.out.println("Maximum time in arrival queue   ");
		input = kbd.nextInt();
		this.userInput.setMaxQueueTime(input);
		
		System.out.println("Number of minutes in Simulation ");
		input = kbd.nextInt();
		this.userInput.setTotalTime(input);
	}
	
	// Simulates the airport runway
	public void simulate() {
		userInputs();
		int firstTime;
		// Start of simulation
		for (int clock = 0; clock < this.userInput.getTotalTime(); clock++) {
			

			// Calculates if a plane has arrived in the air
			if (probCalc.isPlaneInAir(this.userInput.getAvgTimeLand()) == true){
				
				qLand.add(clock, (int)(this.userInput.getMaxQueueTime()));
				TotalLandAttempts++;
			}
			
			//Calculate if a plane is ready for take off
			if (probCalc.isPlaneTakeOff(this.userInput.getAvgTimeTakeOff()) == true){
				qTakeOff.add(clock);	
				TotalDepAttempts++;
			}
			
			
			
			// if runway = 0 then the runway is free.
			if (runway == 0) {
				// check if there is an plane in the landing queue
				if(qLand.isEmpty() == false) {
					runway = 1;								
				}
				// check if there is a plane in the taking off queue
				else if(qTakeOff.isEmpty() == false) {
					runway = 2;			
				} 
			}
			
		
			
			// There is a plane trying to take off
			if (runway == 2) {
				if(takingOff == userInput.getTakeoffTime()){
					// remove if the plane has used the runway for total amount needed to depart
					qTakeOff.remove();
					//plane took off
					takeOff++;	
					// run way is free
					runway = 0;
					// reset time needed in runway to take off 
					takingOff = 0;
					
			}
				if(qLand.isEmpty() == false) {
					// check to see if a plane has crashed while a plane was trying to depart
					firstTime = qLand.peekTimeOnFirstQueue();
					//System.out.println(firstTime);
					//System.out.println(clock);
					if (firstTime < clock) {
						// remove it from the landing queue
						qLand.remove();
						// it crashed - keeps count
						crashed++;
					}						
				}
				// time needed to runway for plane to depart
				takingOff++;
				
				// checks how long a plane was waiting while plane was departing
				if(qLand.isEmpty() == false) {
					timeWaitingForLand++;	
				}	
		
			}
			
			
			
			// There is a plane trying to land		
			if (runway == 1) {
				// plane has lasted the amount of time needed in runway to land
				if(landing == userInput.getLandTime()) {					
					qLand.remove();	
					runway = 0;
					landed++;
					landing = 0;
					
				}if(qLand.isEmpty() == false) {
					// plane can only last as long as their MaxQueued time before running of fuel
					// plane crashes if the clock passess that time and they haven't landed
					firstTime = qLand.peekTimeOnFirstQueue();
					if (firstTime < clock) {
						qLand.remove();
						crashed++;
						landing = 0;
						runway = 0;
					}
					
			} 
				landing++;
			
			
			if(qTakeOff.isEmpty() == false) {
				timeWaitingForTakeOff++;
			}
		}			
				
	}
		
		System.out.println("Planes Departed                 : " + takeOff);
		System.out.println("Planes Landed                   : " + landed);
		System.out.println("Planes Crashed                  : " + crashed);
		double AvgDepQ;
		if (TotalDepAttempts == 0) {
			AvgDepQ = 0;
		}else
			AvgDepQ = (timeWaitingForTakeOff/TotalDepAttempts);
		
		System.out.println("Average Time in Departure Queue : " + AvgDepQ);
		double AvgArrivQ = (timeWaitingForLand/TotalLandAttempts);
		System.out.println("Average Time in Arrival Queue  : " + AvgArrivQ);



	}
}
