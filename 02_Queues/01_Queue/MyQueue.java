//Queue using array

public class MyQueue {
    static class Queue{
        static int arr[];
        static int size;
        static int rear = -1;

        Queue(int size){
            arr = new int[size];
            this.size = size;
        }

        static boolean isEmpty(){
            return rear == -1;
        }

        static void add(int data){
            if(rear == size-1){
                
                return;
            }
        }
    }
    public static void main(String args[]){




    }
}
