import java.util.LinkedList;
import java.util.Queue;

//Write a Java class which implements a stack of integers using 2 queues
//Suppose q1 has all the elements, q2 is empty
//push: enqueue in q2, then enqueue all the elements in q1 to q2, switch the name
//pop:dequeue q1


public class StackUsingQueues {
	
	private Queue<Object> queue1 = new LinkedList<>();
	private Queue<Object> queue2 = new LinkedList<>();
	// indicator which queue should be used
	// if flag is true, then queue1 should be used, false then queue2
	private boolean flag = true;
	
	public void push(Object obj) {
		if(flag) { // flag true - should use queue1
			while(!queue1.isEmpty()) {
				Object extracted = queue1.poll(); //retreive & remove head or ret null if empty
				queue2.offer(extracted); //inserts element - return true if success
			}
			queue1.offer(obj);
		}
		else { //should use queue2
			while(!queue2.isEmpty()) {
				Object extracted = queue2.poll(); //returns head or null if empty
				queue1.offer(extracted); //inserts element - return true if success
			}
			queue2.offer(obj);
		}
	}
	
	public Object pop() {
		Object ret = null; //object to return
		if(flag) {
			ret = queue1.poll(); //ret head or null if empty
			
			while(queue2.size() > 1) {
				Object extracted = queue2.poll();
				queue1.offer(extracted);
			}
		}
		else {
			ret = queue2.poll();
			while(queue1.size() > 1) {
				Object extracted = queue1.poll();
				queue2.offer(extracted);
			}
		}
		
		flag = !flag; //switch queue to use
		return ret;
	}
}