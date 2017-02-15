import java.util.EmptyStackException;
public class FixedMultiStack {

	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize){
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}
	public boolean isFull(int stackNum){
		if(sizes[stackNum] == stackCapacity){
			return true;
		}else{
			return false;
		}
	}
	public boolean isEmpty(int stackNum){
		
		if(sizes[stackNum] == 0){
			return true;
		}
		
		return false;
	}
	
	private int indexOfTop(int stackNum){

		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
	public void push(int stackNum, int value){// throws FullStackException{
		if(isFull(stackNum)){
			//throw new FullStackException();
		}else{
			sizes[stackNum] = sizes[stackNum] + 1;
			values[stackNum + sizes[stackNum]] = value;
		}
	}
	public int pop(int stackNum){
		if(isEmpty(stackNum)){
			System.out.println("Stack #" + stackNum + "is Empty");
			return 0;
		}else{
			int value = values[indexOfTop(stackNum)];
			values[indexOfTop(stackNum)] = 0;
			sizes[stackNum] = sizes[stackNum] - 1;
			return value;
		}
	}
	public int peek(int stackNum){
		if(isEmpty(stackNum)){
			System.out.println("Stack #" + stackNum + "is Empty");
			return 0;
			//throw new EmptyStackException(); //instead
		}else{
			return values[indexOfTop(stackNum)];
		}
	}
	
}
