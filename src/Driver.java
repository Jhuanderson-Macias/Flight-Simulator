/*
 Jhuanderson Macias
 
Write a simulation for a small airport that has one runway. 
There will be a queue of planes waiting to land and an queue of planes waiting to takeoff. 
However, only one plane can use the runway at a time. So there can be only one takeoff or 
one landing in progress at any one time. Assume that all takeoffs take the same amount of 
time. Assume that all landings take the same amount of time, although this does not need to 
be the same as the takeoff time. Assume that planes arrive for landing at random times, but 
with a specified probability of a plane arriving during any given minute. Similarly, assume 
that the planes arrive at the takeoff queue at random times, but with a (possibly different) 
specified probability of a departure. (Despite the fact that takeoffs and landings are scheduled, 
delays make this a reasonable assumption.) Since it is more expensive, and more dangerous to keep 
a plane waiting to land than it is to keep a plane waiting to takeoff, landings will have a priority 
over takeoffs. Thus, as long as some plane is waiting to land, no plane can takeoff. Use a clock that 
is an unsigned integer variable that counts the number of minutes simulated. Use the random number 
generator to simulate arrival and departure times of airplanes.
 
Inputs: 
(1) The amount of time needed for one plane to land;
(2) the amount of time needed for one plane to takeoff. (3) the average amount of time between arrival of planes to the landing queue.
(4) the average amount of time between arrival of planes to the takeoff queue.
(5) the maximum amount of time that a plane can stay in the landing queue without running out of fuel and crashing.
(6) the total length of time to be simulated.

 Outpus: 
(1) The number of planes that took off in the simulated time.
(2) the number of planes that landed in the simulated time.
(3) the number of planes that crashed because they ran out of fuel before they could land.
(4) the average time a plane spent in the takeoff queue. (5) the average time that a plane spent in the landing queue.
 * 
 */


public class Driver {

	public static void main(String[] args) {

		Driver me = new Driver();
		me.doIt();
		}


public void doIt() {
		Simulate sim = new Simulate();
		sim.simulate();
	
	}

}
