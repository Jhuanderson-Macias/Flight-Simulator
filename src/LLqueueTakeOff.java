
public class LLqueueTakeOff {


	private Node head;
	private Node tail;
	private int count;
	
	public void add(int takeOffTime) {
		
			// First set up the Node
			Node n = new Node();
			// Add this node to the Queue
			
			if (count == 0) {
				// The queue is empty, add the first item
				head = tail = n;
				count = 1;
			} else {
				// There are already items in the queue, just add this to the tail
				
				// Make the new node the last item in the queue
				tail.setNext(n);
				tail = tail.getNext();
				
				// One more in the queue...
				count++;
			}
	}

	public boolean isEmpty() {
		return (count == 0);
	}
	

	public void remove() {
		if (isEmpty()) {
			return;
		}
		
		head = head.getNext();
		
		count--;
		return;
	}

	// Queue size - no used
	public int size() {		
		return count;
	}

}

