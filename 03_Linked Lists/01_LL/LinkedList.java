class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LL{
    Node head;
    int size;
    LL(){
        size = 0;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        
        newNode.next = head;
        head = newNode;

        size++;

    }

    public void addLast(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }


        Node currNode = head;

        while(currNode.next != null){
            currNode = currNode.next;
        }

        currNode.next = newNode;
        size++;

    }

    public void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print("null");
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }

        currNode.next = null;

        size--;

    }

    public void insert(int pos, int data){
        Node newNode = new Node(data);

        if(pos == 0 || head == null){
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        if(pos > size || pos < 0){
            System.out.println("Invalid Index");
            return;
        }

        Node currNode = head;
        Node prevNode = null;
        int headcnt = 0;
        while(headcnt != pos){
            prevNode = currNode;
            currNode = currNode.next;
            headcnt++;
        }
        prevNode.next = newNode;
        newNode.next = currNode;
        size++;

    }

    public int getSize(){
        return size;
    }

    public void reverseIterate(){
        if(head == null) return;
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
        while(currNode!= null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }

}

public class LinkedList {
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst(1);  
        list.addFirst(2);    
        list.addFirst(3);    
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        System.out.println(list.getSize());
        list.printList();
        list.removeFirst();
        System.out.println();
        System.out.println(list.getSize());
        list.removeLast();
        System.out.println(list.getSize());
        list.printList();
        list.insert(3, 9);
        System.out.println();
        list.printList();
        System.out.println();
        list.reverseIterate();
        list.printList();
    }
}
