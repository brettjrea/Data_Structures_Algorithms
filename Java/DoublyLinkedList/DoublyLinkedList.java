package DoublyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * provided file for DLinkedList Assignment 
 *
 * @author lkfritz
 */

public class DoublyLinkedList<T extends Comparable<T>> {

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.nanoTime();
		DoublyLinkedList<String> lst1 = new DoublyLinkedList<>();
		DoublyLinkedList<String> lst2 = new DoublyLinkedList<>();

		Scanner fin = new Scanner(new File("Java/DoublyLinkedList/text1.in"));
		String str;

		while (fin.hasNext()) {
			str = fin.next();
			str = cleanUp(str);
			lst1.insertOrderUnique(str);
		}
		fin.close();

		fin = new Scanner(new File("Java/DoublyLinkedList/text2.in"));
		while (fin.hasNext()) {
			str = fin.next();
			str = cleanUp(str);
			lst2.insertOrderUnique(str);
		}

        System.out.println("List 1: " + lst1);
        System.out.println("List 2: " + lst2);
        
        
        @SuppressWarnings("rawtypes")
		DoublyLinkedList combined = lst1.merge(lst2);
        
        System.out.println("\nAFTER MERGE");
        System.out.println("List 1: [" + lst1);
        System.out.println("List 2: [" + lst2);
        System.out.println("\n" + combined);
		long end = System.nanoTime();
		long elapsedTime = end - start; 
		double seconds = (double)elapsedTime / 1_000_000_000.0;
		System.out.println("\nBuild Successful (Total Time: " + seconds + " Seconds)");

	}

	/**
	 * ASSIGNED
	 * 
	 * @param str
	 * @return str in all lower case with LEADING and TRAILING non-alpha 
	 * chars removed
	 */
	public static String cleanUp(String str) {
		return str.toLowerCase().replaceAll("^[^a-z]+|[^a-z]+$", "");
	}

	// inner DNode class: PROVIDED
	private class DNode {

		private DNode next, prev;
		private T data;

		private DNode(T val) {
			this.data = val;
			next = prev = this;
		}
	}

	// DLinkedList fields: PROVIDED
	private DNode header;

	// create an empty list: PROVIDED
	public DoublyLinkedList() {
		header = new DNode(null);
	}

	/**
	 * PROVIDED add
	 *
	 * @param item return ref to newly inserted node
	 */
	//This operation is O(1), since it doesn't include traversing the list.
	public DNode add(T item) {
		// make a new node
		DNode newNode = new DNode(item);
		// update newNode
		newNode.prev = header;
		newNode.next = header.next;
		// update surrounding nodes
		header.next.prev = newNode;
		header.next = newNode;
		return newNode;
	}

	// PROVIDED
	public String toString() {
		String str = "[";
		DNode curr = header.next;
		while (curr != header) {
			str += curr.data + ","; //example showed commas
			curr = curr.next;
		}
		str = str.substring(0, str.length() - 1);
	
		return str + "]";
	}

	/**
	 * ASSIGNED remove val from the list
	 *
	 * @param val
	 * @return true if successful, false otherwise 
	 *
	 *        
	 */

	//At best can be O(1), but overall is O(n) because it traverses the list and compares values.
	public boolean remove(T val) {
		DNode current = header.next;
		while (current != header && current.data.compareTo(val) != 0) {
			current = current.next;
		}
		if (current == header) {
			return false;
		}
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.next = current;
		current.prev = current;
		return true;
	}

	/**
	 * ASSIGNED
	 *
	 * @param item
	 */
	public void insertOrder(T item) {
		DNode current = header.next;
		while (current != header && current.data.compareTo(item) < 0) {
			current = current.next;
		}
		DNode newNode = new DNode(item);
		newNode.prev = current.prev;
		newNode.next = current;
		current.prev.next = newNode;
		current.prev = newNode;

	}

	/**
	 * ASSIGNED
	 *
	 * @param item
	 *
	*
	*
	*/
	//At best can be O(1), but overall is O(n) because it traverses the list and compares values.
	public boolean insertOrderUnique(T item) {
		DNode current = header.next;
		while (current != header && current.data.compareTo(item) < 0) {
			current = current.next;
		}
		if (current != header && current.data.compareTo(item) == 0) {
			return false;
		}
		DNode newNode = new DNode(item);
		newNode.prev = current.prev;
		newNode.next = current;
		current.prev.next = newNode;
		current.prev = newNode;
		return true;
	}

	//At best can be O(1), but overall is O(n) because it traverses the list and compares values.
	public boolean addRHS(T item) {
		DNode current = header.next;
		while (current != header && current.data.compareTo(item) < 0) {
			current = current.next;
		}
		if (current != header && current.data.compareTo(item) == 0) {
			return false;
		}
		DNode newNode = new DNode(item);
		newNode.prev = current.prev;
		newNode.next = current;
		current.prev.next = newNode;
		current.prev = newNode;
		return true;
	}

	/**
	 * ASSIGNED PRE: this and rhs are sorted lists
	 * 
	 * @param rhs
	 * @return list that contains this and rhs merged into a sorted list POST:
	 *         returned list will not contain duplicates
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DoublyLinkedList merge(DoublyLinkedList rhs) {
		DoublyLinkedList result = new DoublyLinkedList();
		DNode current = this.header.prev;
		while (current != this.header) {
			result.add(current.data);
			current = current.prev;
		}
		current = rhs.header.next;
		while (current != rhs.header) {
			result.addRHS(current.data);
			current = current.next;
		}
		header.next = header;
        rhs.header.next = rhs.header;
		return result;
	}
}