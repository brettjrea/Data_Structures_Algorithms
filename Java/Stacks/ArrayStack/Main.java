package Stacks.ArrayStack;
//Stack class
class Stack {  
    int top;            //define top of stack
    int maxsize = 5;    //max size of the stack  
    int[] stack_array = new int[maxsize];  //define array that will hold stack elements
    Stack(){            //stack constructor; initially top = -1
        top = -1;  
    }    
    boolean isEmpty(){          //isEmpty () method
        return (top < 0);  
    }  
   boolean push (int val){     //push () method  
        if(top == maxsize-1) {  
            System.out.println("Stack Overflow !!");  
            return false;  
        }  
        else  {  
            top++;  
            stack_array[top]=val;  
            return true;  
        }  
    }  
    boolean pop () {            //pop () method
        if (top == -1) {  
            System.out.println("Stack Underflow !!");  
            return false;  
        }  
        else   {  
             
            System.out.println("\nItem popped: " + stack_array[top--]);  
            return true;  
        }  
    }  
    void display () {           //print the stack elements  
        System.out.println("Printing stack elements .....");  
        for(int i = top; i>=0;i--) {  
            System.out.print(stack_array[i] + " ");  
        }  
    }  
}  
 
public class Main {  
public static void main(String[] args) {  
    //define a stack object
    Stack stack = new Stack();
    System.out.println("Initial Stack Empty : " + stack.isEmpty());
    //push elements
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    System.out.println("After Push Operation...");
    //print the elements
    stack.display();
    //pop two elements from stack
    stack.pop();
    stack.pop();
    System.out.println("After Pop Operation...");
    //print the stack again
    stack.display();
}  
}    