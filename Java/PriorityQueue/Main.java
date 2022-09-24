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
   
        // Print the head element using Peek () method 
        System.out.println("Peek at head: "  + numQueue.peek()); 
   
        // Printing all elements 
        System.out.print("\nThe PriorityQueue elements: "); 
        Iterator<?> iter1 = numQueue.iterator(); 
        while (iter1.hasNext()) 
            System.out.print(iter1.next() + " "); 
   
        // remove head with poll () 
        numQueue.poll(); 
        System.out.print("\n\nRemoved head element with poll function: "); 
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
        System.out.println("\n\nUse Contain to check PriorityQueue for Five return true or false: " + ret_val); 
   
        // cast to array with toArray () 
        Object[] numArr = numQueue.toArray(); 
        System.out.println("\nArray Contents: "); 
        for (int i = 0; i < numArr.length; i++) 
            System.out.print(numArr[i].toString() + " "); 
    } 
}