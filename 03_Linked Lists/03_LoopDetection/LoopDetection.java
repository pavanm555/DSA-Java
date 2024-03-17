

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
    public void insert(int data){
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

    }
    
    public void display(){
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

    public void createCycle(int a, int b){
        int cnta = 0, cntb = 0;
        Node currNodea = head;
        Node currNodeb = head;
        while(cnta != a || cntb != b){
            if(cnta != a){
                currNodea = currNodea.next;
                ++cnta;
            }
            if(cntb != b){
                currNodeb = currNodeb.next;
                ++cntb;
            }
            currNodeb.next = currNodea;
        }
    }

    public boolean detectCycle(){
        if(head == null){
            return false;
        }

        Node slow = head; 
        Node fast = head;
        
        while(fast.next != null && slow.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

public class LoopDetection{
    public static void main(String args[]){
        LL list = new LL();
       
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();
        list.createCycle(2, 5);
        System.out.println();
        System.out.println(list.detectCycle());

    }
}
