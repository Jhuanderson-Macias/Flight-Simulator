
import java.util.Random;


public class ProbilityCalculator {
	
	private double landingProb;
	private double takeOffProb;
	private boolean planeInAir;
	private boolean planeTakeOff;
	
	public ProbilityCalculator(){
		planeInAir = false;
		planeTakeOff = false;
	}
	
	public double getLandingProb() {
		return landingProb;
	}

	// calculates the probolity of a plane arriving at any given minute
	public boolean isPlaneInAir(double getAvgTimeLand) {	
		
		double nProb = (1/getAvgTimeLand) * 100;		
		this.landingProb = nProb;
		Random num = new Random();
		int randNum = num.nextInt(100)+1;
		
		if ((randNum < nProb) || (randNum == nProb)){
			return true;
		}				
		return false;
	}
	
	// calculates the probolity of a plane departing at any given minute
	public boolean isPlaneTakeOff(double getAvgTimeTakeOff) {
		double nProb = (1/getAvgTimeTakeOff)  * 100;		
		this.takeOffProb = nProb;
		Random num = new Random();
		int randNum = num.nextInt(100)+1;
		
		if ((randNum < nProb) || (randNum == nProb)){
			return this.planeTakeOff  = true;
		}				
		return this.planeTakeOff  = false;
	}

	public double getTakeOffProb() {
		return this.takeOffProb;
	}
	
	public double getPlaneTakeOff() {
		return this.takeOffProb;
	}
	
	public double getPlaneInAir() {
		return this.takeOffProb;
	}
	


}

