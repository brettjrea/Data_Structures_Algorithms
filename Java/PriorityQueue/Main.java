//PriorityQueue does not allow null values.
//For non-comparable objects, we cannot create a priority queue.
//The head or front of the queue contains the least element as per the natural ordering.
import java.util.*; 
   
class Main { 
    public static void main(String args[])  { 

        // Creating empty priority queue 
        PriorityQueue<String> numQueue = new PriorityQueue<String>();
         
        // add elements to numQueue using add() 
        numQueue.add("Five"); 
        numQueue.add("One"); 
        numQueue.add("Seven"); 
        numQueue.add("Three"); 
        numQueue.add("Eleven");
        numQueue.add("Nine"); 
   
        // Printing all elements 
        System.out.print("\nThe PriorityQueue elements: "); 
        Iterator<?> iter1 = numQueue.iterator(); 
        while (iter1.hasNext()) 
            System.out.print(iter1.next() + " "); 

        // Print the head element using Peek () method 
        System.out.println("\n\nPeek at head: "  + numQueue.peek()); 
   
        // return the head and remove the head with poll () 
        
        System.out.print("\nRemoved " + numQueue.poll() + " the head element with poll function: "); 
        Iterator<String> iter2 = numQueue.iterator(); 
        while (iter2.hasNext()) 
            System.out.print(iter2.next() + " "); 
   
        // Remove 'Three' using remove ()
        numQueue.remove("Three"); 
        System.out.print("\n\nRemoved 'Three' with remove function: "); 
        Iterator<String> iter3 = numQueue.iterator(); 
        
      while (iter3.hasNext()) 
            System.out.print(iter3.next() + " "); 
   
        // Check for five using contains() return true or false.
        boolean ret_val = numQueue.contains("Five"); 
        System.out.println("\n\nContains a five: " + ret_val); 
   
        // cast to array with toArray () 
        Object[] numArr = numQueue.toArray(); 
        System.out.print("\nArray Contents: "); 
        for (int i = 0; i < numArr.length; i++) 
            System.out.print(numArr[i].toString() + " "); 
    } 
}