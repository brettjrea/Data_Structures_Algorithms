package Stacks.Stack;

import java.util.Stack;
 
public class Main {
    public static void main(String a[]){
        //declare a stack object
        Stack<Integer> stack = new Stack<>();
        //print initial stack
        System.out.println("Initial stack : "  + stack);
        //isEmpty ()
        System.out.println("Is stack Empty? : "  + stack.isEmpty());
        //push () operation
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        //print non-empty stack
        System.out.println("Stack after push operation: "  + stack);
        //pop () operation
        System.out.println("Element popped out:"  + stack.pop());
        System.out.println("Stack after Pop Operation : "  + stack);
        //search () operation
        System.out.println("Element 10 found at position: "  + stack.search(10));
        System.out.println("Is Stack empty? : "  + stack.isEmpty());
    }
}   