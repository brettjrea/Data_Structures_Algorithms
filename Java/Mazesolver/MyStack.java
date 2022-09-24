package Mazesolver;

public class MyStack<T> {
	T[] stack;
    int top = 0;
    
    //Constructor
    @SuppressWarnings("unchecked")
    public MyStack(){
            
            stack = (T[]) new Object[20]; 
            
    }
    
    public void push(T v) {
            stack[top] = v;
            top++;
    }
    
    public Boolean empty() {
            if(top == 0) {
                    return true;
            }
            return false;
            
    }
    public T top() {
            return stack[top - 1];
    }
    public T pop() {
            T data = stack[top - 1];
            stack[top - 1] = null;
            top--;
            return data;
    }
    
    //Print the contents of the stack for testing
    public void printStack() {
            String str = "[";
            
            for(int i = 0; i < this.stack.length; i++) {
                    if(stack[i] != null) {
                            str += stack[i].toString();
                    }
            }
            str += "]";
            
            System.out.println(str);
    }
    
}

