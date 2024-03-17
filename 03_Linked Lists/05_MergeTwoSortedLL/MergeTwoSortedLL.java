import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LL {
    Node head;
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;

    }

    public void printList(){
        
        if(head == null){
            System.out.println("List is empty");
			return;
        }
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.print("null");
    }    
}

public class MergeTwoSortedLL{
	public static void main(String args[]){
        LL list1 = new LL();
        list1.add(3);
        list1.add(7);
        list1.add(10);

        LL list2 = new LL();
        list2.add(1);
        list2.add(2);
        list2.add(5);
        list2.add(8);
        list2.add(10);

		
        ArrayList<Integer> arr = new ArrayList<>();

        Node node = list1.head;
        while(node != null){
            arr.add(node.data);
            node = node.next;
        }
		
		Node node2 = list2.head;
        while(node2 != null){
            arr.add(node2.data);
            node2 = node2.next;
        }

        Collections.sort(arr);

		LL list3 = new LL();
		for(int i : arr){
			list3.add(i);
		}
        
        list1.printList();
        System.out.println();
		list2.printList();
        System.out.println();
		list3.printList();

    }
}
