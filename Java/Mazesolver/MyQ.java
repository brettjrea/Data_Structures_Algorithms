package Mazesolver;

public class MyQ<T> {
	
	T[] queue;
	int size;
	int back = 0;
	
	@SuppressWarnings("unchecked")
	public MyQ() {
		
		queue = (T[]) new Object[50];
	}
	
	//push
	public void push(T v) {
		
		queue[back] = v;
		back++;
	}
	
	//pop
	public T pop() {
		
		@SuppressWarnings("unchecked")
		T[] newQueue = (T[]) new Object[50];
		T data = queue[0];
		
		for (int i = 1; i < queue.length - 1; i++) {
			newQueue[i - 1] = queue[i];
		}
		queue = newQueue;
		back--;
		return data;
	}
	//empty
	public Boolean empty() {
		
		if (queue[0] == null) {
			return true;
		}
		return false;
	}
	//front
	public T front() {
		
		return queue[0];
	}
	//print contents
	public void printQueue() {
		
		String str = "[";
		
		for (int i = 0; i < this.queue.length; i++) {
			if (queue[i] != null) {
				str += queue[i].toString();
			}
		}
		str += "]";
		System.out.println(str);
	}

}
