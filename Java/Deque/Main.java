//Deque interface supports resizable arrays that can grow as required.
//Array dequeues do not allow the use of Null values.
package Deque;
import java.util.*; 
public class Main { 
    public static void main(String[] args) { 
        //Declare Deque object using Array or LinkedList class to use the functionality of deque interface.
        Deque<String> deque = new ArrayDeque<String>(); 
        //Deque<String> deque = new LinkedList<String>(); 

        // Common methods 
        deque.add("One");           //add ()
        deque.addFirst("Two");      //addFirst ()
        deque.addLast("Three");     //addLast ()
        deque.push("Four");         //push ()
        deque.offer("Five");        //offer ()
        deque.offerFirst("Six");    //offerFirst ()
        deque.offerLast("Seven");   //offerLast ()

        // Print details
        System.out.println("\nDeque:");
        System.out.println(deque + " "); 
      
       // Iterate using forward iterator
        System.out.println("\nForward Iterator:"); 
        Iterator iterator = deque.iterator(); 
        while (iterator.hasNext()) 
            System.out.print(" " + iterator.next()); 
        
       // Iterate using Reverse iterator 
        Iterator reverse = deque.descendingIterator(); 
        System.out.println("\n\nReverse Iterator:"); 
        while (reverse.hasNext()) 
            System.out.print(" " + reverse.next()); 
          
        // Peek () method
        System.out.println("\n\nPeek:" + deque.peek()); 
        System.out.println("After peek:" + deque); 
        
         // Pop () method 
        System.out.println("\nPop:" + deque.pop()); 
        System.out.println("After pop:" + deque); 
   
        // contains () method
        System.out.println("\nDeque Contains Three: " +  deque.contains("Three")); 
   
        deque.removeFirst();        //removeFirst () 
        deque.removeLast();         //removeLast ()
        System.out.println("\nRemoved first and last elements: " + deque); 
   } 
}