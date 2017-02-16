/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Austin
 * Last Name: Raun
 * Lab Section: 3A
 * email address: araun@uci.edu
 *
 *
 * Assignment: assn4
 * Filename : PQ.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class PQ {
	
	//PQ.Node is a raw type. References to generic type PQ.Node<T> should be parameterized
	@SuppressWarnings("rawtypes")
	public Node [] h; //internal array to hold heap items
	//SuppressWarnings("rawtypes")

	private int currentSize;
	private static final int CAPACITY = 100;
	
	private class Node<T>{
		private int key;
		private T item; 
		
		private Node(int key, T item){
			this.keySetter(key);
			this.item = item;
		}
		private void keySetter(int key){
			this.key = key; 
		}
		private int keyGetter(){
			return key;
		}
	}
	
	public boolean isEmpty(){
		return (currentSize == 0);
	}
	
	/**
	 * Default constructor that will create an empty minHeap
	 */
	public PQ() {
		currentSize = 0;
		h = new Node[CAPACITY];
		//Initialize h of size CAPACITY 
	}
	
	private void buildPQ() {
		for(int i =(currentSize/2) - 1;i >= 0; i--) {
			trickleDown(i);
		}
	}
	
	public void extractMin() {
		if(currentSize == 0) {
			throw new IndexOutOfBoundsException("Minheap empty.");
		}
		h[0] = h[currentSize-1];
		h[currentSize-1] = null;
		currentSize--;
		buildPQ();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getMin() {
		if(currentSize == 0) {
			throw new IndexOutOfBoundsException("Minheap empty.");
		}
		//@SuppressWarnings("unchecked")
		return (T) h[0].item; 
		//Warning: Type safety: Unchecked cast from Object to T
	}
	
	public <T> void insert(T item, int key) {
		for(int i = 0; i < currentSize; i++) {
			if(item.equals(h[i].item)) {
				h[i].keySetter(key);
				buildPQ();
				return;
			}
		}
		
		Node<T> temp = new Node<T>(key,item);
		
		if(currentSize >= CAPACITY) {
			throw new IndexOutOfBoundsException("The minheap is full.");
		}
		h[currentSize] = temp;
		++currentSize;
		trickleUp(currentSize-1);
	}
	
	//private helper function - Maintains the heap property
	//between a node located at index in array, and its parent. 
	//Use in minHeapInsert(int key). (See Lecture 6 slides)
	private void trickleUp(int index) {
		int parent = (index - 1)/2;
		
		//return if at top
		if(index == 0){
			return;
		}
		//return if parent has smaller key
		else if(h[index].keyGetter() > h[parent].keyGetter()) {
			return;
			
		} else {
			@SuppressWarnings("rawtypes")
			Node temp = h[index];
			h[index] = h[parent];
			h[parent] = temp;
			trickleUp(parent);
		}
	}
	
	//private helper function - Maintains the heap
	//property between a parent node located at index in array, and its children. Used in
	//buildMinHeap(). (See Lecture 6 slides)
		private void trickleDown(int index) {
			int leftChild = (2*index) + 1;
			int rightChild = (2*index) + 2;

			if(rightChild >= currentSize || leftChild >= currentSize){
				return; 
			}
			else if((h[leftChild].keyGetter() > h[index].keyGetter())|| (h[leftChild].keyGetter() > h[index].keyGetter() && h[rightChild].keyGetter() > h[index].keyGetter())) {
				return;
			} 
			else if(h[leftChild].keyGetter() < h[index].keyGetter() && rightChild >= currentSize) {
				@SuppressWarnings("rawtypes")
				Node temp = h[index];
				h[index] = h[leftChild];
				h[leftChild] = temp;
				trickleDown(leftChild);
			}else{
				if(h[leftChild].keyGetter() < h[rightChild].keyGetter()) {
					@SuppressWarnings("rawtypes")
					Node temp = h[index];
					h[index] = h[leftChild];
					h[leftChild] = temp;
					trickleDown(leftChild);
				} else{
					@SuppressWarnings("rawtypes")
					Node temp = h[index];
					h[index] = h[rightChild];
					h[rightChild] = temp;
					trickleDown(rightChild);
				}
			}
		}
	
	public void display() {
		int j = 0;
		int factor = 1;
		System.out.println("\nPQ Displayer:");
		for(int i = 0; i < currentSize; i++) {
			if(j == factor) {
				j = 0;
				factor = factor * 2;
				System.out.println("\n");
			}
			j++;
			System.out.print("(" + h[i].item + "," + h[i].keyGetter() + ") ");
		}
		
	}
}
