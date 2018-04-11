
public class Node {
	private Integer data;
	private Node next;
	private int landTime;
	private int takeoffTime;
	private int AvgTimeLand;
	private int time;
	
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Integer getLandTime() {
		return landTime;
	}
	public void setLandTime(Integer landTime) {
		this.landTime = landTime;
	}
	public Integer getTakeoffTime() {
		return takeoffTime;
	}
	public void setTakeoffTime(Integer takeoffTime) {
		this.takeoffTime = takeoffTime;
	}
	public Integer getAvgTimeLand() {
		return AvgTimeLand;
	}
	public void setAvgTimeLand(Integer avgTimeLand) {
		AvgTimeLand = avgTimeLand;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(int totalTime) {
		this.time = totalTime;
	}
		
}
