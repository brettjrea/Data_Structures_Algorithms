package SinglyLinkedList;

/* Declaration of class for node of linked list */

class SinglyLinkedNode {

    // each node has a data and a pointer to
    
    // next node (required to create SinglyLinkedList)
    
    public int data;
    
    public SinglyLinkedNode next;
    
    // default constructor
    
    public SinglyLinkedNode() {
    
    data = -1;
    
    next = null;
    
    }
    
    // constructor to initialise data of the node.
    
    public SinglyLinkedNode(int value) {
    
    data = value;
    
    next = null;
    
    }
    
    }
    
    