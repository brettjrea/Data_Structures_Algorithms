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
        System.out.println("Head element using peek method:"  + numQueue.peek()); 
   
        // Printing all elements 
        System.out.println("\n\nThe PriorityQueue elements:"); 
        Iterator<?> iter1 = numQueue.iterator(); 
        while (iter1.hasNext()) 
            System.out.print(iter1.next() + " "); 
   
        // remove head with poll () 
        numQueue.poll(); 
        System.out.println("\n\nAfter removing an element" +  "with poll function:"); 
        Iterator<String> iter2 = numQueue.iterator(); 
        while (iter2.hasNext()) 
            System.out.print(iter2.next() + " "); 
   
        // Remove 'Three' using remove ()
        numQueue.remove("Three"); 
        System.out.println("\n\nElement 'Three' with"
                           + " remove function:"); 
        Iterator<String> iter3 = numQueue.iterator(); 
        
      while (iter3.hasNext()) 
            System.out.print(iter3.next() + " "); 
   
        // Check if an element is present in PriorityQueue using contains() 
        boolean ret_val = numQueue.contains("Five"); 
        System.out.println("\n\nPriority queue contains 'Five' "
                           + "or not?: " + ret_val); 
   
        // get array equivalent of PriorityQueue with toArray () 
        Object[] numArr = numQueue.toArray(); 
        System.out.println("\nArray Contents: "); 
        for (int i = 0; i < numArr.length; i++) 
            System.out.print(numArr[i].toString() + " "); 
    } 
}