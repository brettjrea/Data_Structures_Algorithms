package SinLinkedList;
public class SinglyLinkedList<T extends Comparable<T>> {
    public static void main(String[] args) {
	    SinglyLinkedList<String> myList = new SinglyLinkedList<String>();
	    SinglyLinkedList<String> aList = new SinglyLinkedList<String>();
		
		//Check that both lists are empty
		System.out.println("Make sure myList is empty?" + myList.isEmpty());
		System.out.println("Make sure aList is empty?" + aList.isEmpty());

		System.out.println("<<Inserted some sample data>>");
		
		//inserting new data into myList
        myList.insert("Ace");
		myList.insert("King");
		myList.insert("Queen");
		myList.insert("Jack");
        myList.insert("Joker");
		
		
		//create and insert data into a aList to merge
		aList.insert("Hearts");
		aList.insert("Diamonds");
		aList.insert("Clubs");
		aList.insert("Spades");
		
		//testing isEmpty after insertion
		System.out.println("Make sure myList is not empty? " + myList.isEmpty());
		System.out.println("Make sure aList is not empty?" + aList.isEmpty());

		//reverse order of the list
		System.out.print("The myList contains: ");
		myList.forward();
        System.out.print("\n");

        System.out.print("The myList reversed is: ");
		myList.reversed();
        System.out.print("\n");
		
		//check size of list
		System.out.println("The size of the myList is " + myList.size() + " strings");
		
		//print whats after the head
		System.out.println("The second node is: " + myList.headNode().next);

		//print whats after the tail
		System.out.println("Check for null after Tail: " + myList.tailNode().next);

		//print whats before the tail
		System.out.println("The second to last node is: " + myList.tailNode().previous);

		//print front of list
		System.out.println("The head node is: " + myList.front());
		//print end of list
		System.out.println("The tail node is: " + myList.back());
		
		//remove head and replace it with next node
		myList.pop_front();
		System.out.println("New head after popping head: " + myList.front());
		//check the size after removing original head
		System.out.println("New size after popping head is " + myList.size() + " strings");
		//remove tail via pop_back
		myList.pop_back();
		System.out.println("New tail after popping tail is: " + myList.back());
		//check list size after removing tail
		System.out.println("New list size after popping tail is " + myList.size() + " strings");
		
		//merge both lists
		myList.merge(aList);

        System.out.println("<<Merged the sample data>>");
        System.out.print("myList now contains: ");
		myList.forward(); aList.forward();
        System.out.print("\n");
		
		System.out.println("New tail after merging the lists is: " + myList.back());

		System.out.println("List size after popping the head and tail and merging: " + myList.size());

	}
	
	private Node<?> head;
	private Node<?> tail;
	private int listSize;
	
	public SinglyLinkedList() {
		
	}
	
	public SinglyLinkedList(Node<?> head, Node<?> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public SinglyLinkedList(SinglyLinkedList<?> singlyLinkedList) {
		head = singlyLinkedList.head;
		tail = singlyLinkedList.tail;
	}
	
	@SuppressWarnings("unchecked")
	public T front() {
		if (head != null) {
			return (T) this.head.getData();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public T back() {
		if (tail != null) {
			return (T) this.tail.getData();
		}
		return null;
	}
	public Node<?> headNode() {
		return this.head;
	}
	public Node<?> tailNode() {
		return this.tail;
	}
	//time complexity is this operation runs in a constant time, therefore adding n elements requires O(n) time.
	public void insert(T data) {
		Node<?> newNode = new Node<Object>(data);
		if (head == null) {
			head = newNode;
			listSize++;
			return;
		}
		if (tail == null) {
			tail = newNode;
			head.next = newNode;
			tail.previous = head;
			listSize++;
			return;
		}
		tail.next = newNode;
		newNode.previous = tail;
		tail = newNode;
		listSize++;
	}
	
	public void pop_front() {
		this.head = this.head.next;
		listSize--;
	}
	
	public void pop_back() {
		this.tail = this.tail.previous;
		listSize--;
	}
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
	//it is O(1) because the list is linked, it keeps references to both head and tail.
	public int size() {
		return listSize;
	}

    public void forward() {
		Node<?> currentNode = head;
		if (head == null) {
			currentNode = tail;
		}
		while (currentNode != null) {
			System.out.print(currentNode + " ");
			currentNode = currentNode.next;
		}
	}

	public void reversed() {
		Node<?> currentNode = tail;
		if (tail == null) {
			currentNode = head;
		}
		while (currentNode != null) {
			System.out.print(currentNode + " ");
			currentNode = currentNode.previous;
		}
	}
	
	public void merge(SinglyLinkedList<?> aList) {
		if (this.tail == null) {
			this.tail = aList.head;
		}
		this.tail = aList.tail;
	}
     
    /*
    public boolean add(T data) {
		Node<?> currentNode = this.head;
		while (currentNode != this.head && (currentNode.data).compareTo(currentNode.data) < 0) {
			currentNode = currentNode.next;
		}
		if (currentNode != this.head && (currentNode.data).compareTo(currentNode.data) == 0) {
			return false;
		}
		Node<?> newNode = new Node<Object>(data);
		newNode.next = currentNode;
		return true;
	}
    public boolean addRHS(T data) {
		Node<?> currentNode = this.head;
		while (currentNode != head && (currentNode.data).compareTo(currentNode.data) < 0) {
			currentNode = currentNode.next;
		}
		if (currentNode != head && (currentNode.data).compareTo(currentNode.data) == 0) {
			return false;
		}
		Node<?> newNode = new Node<Object>(data);
		newNode.next = currentNode;
		return true;
	}
    public SinglyLinkedList<T> merge(SinglyLinkedList<T> aList) {
		SinglyLinkedList<T> result = new SinglyLinkedList<T>();
		Node<?> currentNode = this.head;
		while (currentNode != this.head) {
			result.add((T) currentNode.data);
            currentNode = currentNode.previous;
		}
		currentNode = this.head;
		while (currentNode != this.head) {
			result.addRHS((T) currentNode.data);
			currentNode = currentNode.next;
		}
		return result;
	}*/
}