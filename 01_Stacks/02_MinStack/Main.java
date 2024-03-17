import java.util.*;

class MyStack{
    Stack<Integer> s;
    Stack<Integer> p;
    MyStack(){
        s = new Stack<>();
        p = new Stack<>();
    }

    public void push(int data){
        if(s.isEmpty()){
            s.push(data);
            p.push(data);
        }
        else{
            s.push(data);
            if(p.peek() > data){
                p.push(data);
            }
        }
    }

    public void pop(){
        if(s.isEmpty()){
            System.out.println("Stack is empty");
            return;
        }

        int t = s.pop();
        System.out.println("Removed: " + t);
        if(t == p.peek()){
            p.pop();
        }
    }

    public void peek(){
        if(s.isEmpty()){
            System.out.println("Stack is empty");
        }
        System.out.println(s.peek()); 
    }

    public void getMin(){
        if(s.isEmpty()){
            System.out.println("Stack is empty");
        }
        System.out.println(p.peek());
    }
}

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(8);
        stack.push(9);
        stack.pop();
        stack.peek();
        stack.getMin();
        
    }
}
