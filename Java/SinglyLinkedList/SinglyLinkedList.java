package SinglyLinkedList;

/* Declaration of class for a Singly Linked List */

public class SinglyLinkedList {

// data members for front and tail of the linked list

private SinglyLinkedNode front, tail;

// default constructor, creates an empty list

public SinglyLinkedList() {

front = tail = null;

}

// copy constructor, creates a deep copy of the list passed

public SinglyLinkedList(SinglyLinkedList aList) {

// create a new node, with data same as first data

// value of aList.

front = new SinglyLinkedNode(aList.front().data);

// temporary variables to iterate through linked list

// temp : iterates through all nodes of aList

// temp1 : stores references to last node of the copy

// being created.

// temp2 : stores a reference to the newly created node.

SinglyLinkedNode temp1, temp2;

// Since we have already created a copy of first node of aList

// so we begin from the second node.

SinglyLinkedNode temp = aList.front().next;

temp1 = front;

// temp would be null, when all nodes of aList have been visited,

// so we end loop here.

while (temp != null) {

// create a new copy of current node (one to which temp points)

// of aList

temp2 = new SinglyLinkedNode(temp.data);

// set this as the last node of the copy of list

temp1.next = temp2;

// update temp1 to point to last node of copy

temp1 = temp1.next;

// update temp to move to next node of aList.

temp = temp.next;

}

// since temp1, points to last node of copy, when complete

// copy has been created, we set tail pointer to temp1 i.e.

// last node of copy.

tail = temp1;

}

// returns reference to front node

public SinglyLinkedNode front() {

return front;

}

// returns reference to last node.

public SinglyLinkedNode back() {

return tail;

}

// inserts a new node to it's appropriate position

// to maintain ascending order of nodes.

public void insert(int val) {

// create a new node with data = val

SinglyLinkedNode temp = new SinglyLinkedNode(val);

// temporary pointers :

// temp2 : pointer to last node X, such that X.data < val

// i.e. it points to last node whose data is less than data

// of node to be inserted, so new node would be inserted after temp2.

// temp1 : points to first node whose data is greater than val.

// so new node would be inserted before temp1.

// For eg if original list is 12 -> 15 -> 18

// and we need to insert 16 then temp1 = 18 and temp2 = 15.

SinglyLinkedNode temp1 = front, temp2 = null;

// loop though the nodes, till we move temp1 to it's appropriate

// position

while (temp1 != null && temp1.data < val) {

temp2 = temp1;

temp1 = temp1.next;

}

// if temp2 is null, this means that new node is to be inserted in

// first position.

if (temp2 == null) {

temp.next = front;

front = temp;

} // if temp1 is null, that means new node is to inserted at last

// position

else if (temp1 == null) {

temp2.next = temp;

tail = temp;

} // otherwise new node is to be inserted somewhere in middle in the list.

else {

temp.next = temp2.next;

temp2.next = temp;

}

}

// function to delete the first node of list

public SinglyLinkedNode pop_front() {

// store a reference to first node.

SinglyLinkedNode temp = front;

// move front to next node(i.e. 2nd node)

front = front.next;

// delete link from first node to second node

temp.next = null;

// return front node.

return temp;

}

// function to delete the last node of list

public SinglyLinkedNode pop_back() {

SinglyLinkedNode temp = front;

// loop through all nodes, till we reach the second last node.

while (temp.next != tail)

temp = temp.next;

// store a reference to last node. temp would be second last

// node, so temp.next points to last node.

SinglyLinkedNode returnNode = temp.next;

// delete link between second last and last node

temp.next = null;

// update tail to point to second last node, which is

// the last node after deletion

tail = temp;

// return reference to the deleted node.

return returnNode;

}

// if tail is null, that means list is empty

public boolean empty() {

return tail == null;

}

// function to return size of list

public int size() {

SinglyLinkedNode temp = front;

int count = 0;

// loop through all the nodes and keep counter

// to calculate number of nodes.

while (temp != null) {

temp = temp.next;

count++;

}

return count;

}

// function to reverse the linked list

public void reverse() {

// create three temp pointers,

// temp1: points to node, which is being reversed i.e. for which

// next pointer is being updated.

// temp : points to node one before temp1

// temp2: points to node one after temp1.

// What we are doing is this function is dividing list into

// 3 parts , part 1 would be sublist which has been reversed.

// part 2 would be the node that is being reversed

// part 3 is the sublist which needs to be reversed and is in

// original order currently.

// So if our original list is like 2 -> 4 -> 6 -> 8 -> 12

// then while this function runs, list would be as

// 2 <- 4 6 8 -> 12, where 2 <- 4 represents reversed list, 6

// is node to be reversed and 8-> 12 represents unreversed list.

// so temp1 = 6, temp = 4 and temp2 = 8.

SinglyLinkedNode temp = null, temp1, temp2;

// initially reverse the first node, so temp1 = front.

temp1 = front;

temp2 = front.next;

// since in new list, tail would be at 2 and head at 12 (list example above)

// so we set tail to 2 (i.e. front)

tail = front;

// loop through all the nodes, when temp2 = null all nodes

// but the last one have been reversed

while (temp2 != null) {

// reverse the direction to link of current node

temp1.next = temp;

// move all pointers one step forward to reverse the next node.

temp = temp1;

temp1 = temp2;

temp2 = temp2.next;

}

// reverse the last node.

temp1.next = temp;

// set front to last node i.e. 12

front = temp1;

}

// function to merge two lists

public void merge(SinglyLinkedList aList) {

// this function merges aList with the current list, to

// create a new list in ascending order. It assumes that

// both aList and current list are in ascending order.

// create three pointers,

// temp1 : points to node of current list

// temp2 : points to node of aList

// temp : points to node of merged (required) list.

SinglyLinkedNode temp, temp1 = front, temp2 = aList.front();

// we compare temp1 and temp2's data.

// which ever is smaller, that node would go first

// in the merged list.

// Consider an example of 2 -> 3 -> 4 and 1 -> 5 as two lists to be merged

// so initially temp1 = 2 , temp2 = 1 and temp = null.

// we see that 1 < 2, so temp = 1,temp1 = 2 and temp2 = 5.

// then we again compare temp1 and temp2 , 2 < 5

// so after this iteration temp = 2, temp1 = 3 adn temp2 = 5

// and the merged list would be 1 -> 2. So temp points to last

// node of merged list.

// set initial value of temp, depending on where temp1 <= temp2

if (temp1.data <= temp2.data) {

temp = temp1;

temp1 = temp1.next;

} else {

temp = temp2;

temp2 = temp2.next;

}

// at this point, merged list would have only one node, to which temp points

// set the front of merged list to temp.

front = temp;

// loop thorough all the nodes of lists and keep merging them

// when temp1 =null, this means that we have iterated through

// all nodes of list 1 and so we don't need to compare and we

// simply append list 2, to get the merged list.

// similar is the case when temp2 = null, at that time list 2 has been

// completely iterated over.

while (temp1 != null && temp2 != null) {

if (temp1.data <= temp2.data) {

temp.next = temp1;

temp1 = temp1.next;

} else {

temp.next = temp2;

temp2 = temp2.next;

}

temp = temp.next;

}

// above while loop will break whenever either of temp1 or temp2 is null

// so with below loops, we iterate over remaining nodes of the other list

// and append them to merged list.

// NOTE : only one of these loops will run at any time. Because when above

// while loop ends, then either temp1 = null, in which case 2nd of below loops

// would run, otherwise, first of below loops would run.

// This way we are saving ourself from checking whether temp1 is null or temp2

// is null.

while (temp1 != null) {

temp.next = temp1;

temp1 = temp1.next;

temp = temp.next;

}

while (temp2 != null) {

temp.next = temp2;

temp2 = temp2.next;

temp = temp.next;

}

// set tail to point to last node of merged list.

tail = temp;

}

// testing code.

public static void main(String[] args) {

// test default constructor.

SinglyLinkedList myList = new SinglyLinkedList();

// insert 5 elements, this tests insert function

// for all three cases of insertion : in beginning, at end

// and somewhere in the middle

myList.insert(10);

myList.insert(12);

myList.insert(18);

myList.insert(5);

myList.insert(15);

// test the copy constructor.

SinglyLinkedList myListCopy = new SinglyLinkedList(myList);

// test front() function

System.out.println("First Data value : " + myList.front().data);

// test back() function

System.out.println("Last Data value : " + myList.back().data);

// test pop_front() and pop_back() functions

myList.pop_front();

System.out.println("First Data value after pop_front: " + myList.front().data);

myList.pop_back();

System.out.println("Last Data value after pop_back: " + myList.back().data);

// test empty() function

System.out.println("List Empty : " + myList.empty());

// test size() function

System.out.println("No of elements in list : " + myList.size());

// test reverse() function

myListCopy.reverse();

System.out.println("List copy after reversing");

SinglyLinkedNode frontNode = myListCopy.front();

while (frontNode != myListCopy.back()) {

System.out.print(frontNode.data + " -> ");

frontNode = frontNode.next;

}

System.out.println(myListCopy.back().data);

// reverse the list again to get it back in ascending order

myListCopy.reverse();

// test merge function

myList.merge(myListCopy);

System.out.println("Lists after merging");

frontNode = myList.front();

while (frontNode != myList.back()) {

System.out.print(frontNode.data + " -> ");

frontNode = frontNode.next;

}

System.out.println(myList.back().data);

}

}