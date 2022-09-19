package SinLinkedList;

public class Node<T> {
	
	public String data;
	public Node<?> next;
	public Node<?> previous;
	
	public Node(T data) {
		
		this.data = (String) data;
	}
	
	public String getData() {
		
		return data;
	}
	
	public void setData(T data) {
		
		this.data = (String) data;
	}
	
	public Node<?> getNext() {
		
		return next;
	}
	
	public void setNext(Node<?> next) {
		
		this.next = next;
	}
	
	
	@Override
	public String toString() {
		return  "" + data;
	}
	
}
