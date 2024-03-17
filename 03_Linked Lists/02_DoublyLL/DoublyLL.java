/* 
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class DLL{
    Node head;
    Node tail;
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = newNode;
            tail = newNode;
            return;
        }
        Node currNode = tail;
        currNode.next = newNode;
        newNode.prev = currNode;
        tail = newNode;
    }
    public void insertAtPos(int pos, int data){
        Node newNode = new Node(data);
        int count = 0;
        Node currNode = head;

        if(pos == 0){
            newNode.next = currNode;
            currNode.prev = newNode;
            head = newNode;
            return;
        }

        while(count != pos){
            currNode = currNode.next;
            count++; 
        }

        if(currNode == null){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            return;
        }

        newNode.next = currNode;
        newNode.prev = currNode.prev;
        currNode.prev.next = newNode;
        currNode.prev = newNode;
 

    }
    public void display(){
        if(head == null){
            System.out.println("List is empty");
        }
        Node currNode = head;
        while(currNode != tail){
            System.out.print(currNode.data + "<->");
            currNode = currNode.next;
        }
        System.out.print(currNode.data);


    }
}
public class DoublyLL {
    public static void main(String args[]){
        DLL list = new DLL();
        list.insertAtEnd(5);
        list.insertAtEnd(4);
        list.insertAtEnd(9);
        list.insertAtEnd(3);
        list.insertAtEnd(7);
        list.insertAtEnd(6);
        System.out.println(list.head.data);
        System.out.println(list.tail.data);
        list.display();
        list.insertAtPos(6, 2);
        System.out.println();
        list.display();




    }
    
}
*/

class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        Node prev = null;
        Node next = null;
        this.data = data;
    }
}

class DLL{
    Node head;
    Node tail;

    public void insertAtBegin(int data){
        Node newNode = new Node(data);
        if(head == null){
            head =newNode;
            tail = newNode;
            return;
        }
        newNode.prev = null;
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head =newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void display(){
        if(head == null){
            System.out.println("List is empty");
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "<->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
}

public class DoublyLL{
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertAtBegin(2);
        list.insertAtBegin(3);
        list.insertAtBegin(4);
        list.insertAtBegin(5);
        list.display();
        System.out.println(list.head.data);
        System.out.println(list.tail.data);
        list.insertAtEnd(6);
        list.display();

    }
}