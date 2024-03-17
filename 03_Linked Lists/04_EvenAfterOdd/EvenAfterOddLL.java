
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

    public void Segregate(){
        Node EvenStart = null;
        Node EvenEnd = null;
        Node OddStart = null;
        Node OddEnd = null;
        Node currNode = head;
        while(currNode != null){
            if(currNode.data % 2 == 0){
                if(EvenStart == null){
                    EvenStart = currNode;
                    EvenEnd = currNode;
                }
                else{
                    EvenEnd.next = currNode;
                    EvenEnd =  EvenEnd.next;
                }
            }
            else{
                if(OddStart == null){
                    OddStart = currNode;
                    OddEnd = currNode;
                }
                else{
                    OddEnd.next = currNode;
                    OddEnd =  EvenEnd.next;
                }
            }
            currNode = currNode.next;
        }
        OddEnd.next = EvenStart;
        EvenEnd.next = null;
        OddStart = head;
    }
}
public class EvenAfterOddLL {
    public static void main(String[] args) {
        LL list = new LL();
        for(int i=1;i<7;i++){
            list.insert(i);
        }
        list.display();
        list.Segregate();
        System.out.println();
        list.display();
    }
}
