import java.util.*;

class Graph{
    ArrayList<LinkedList<Node>> alist;
    Graph(){
        alist = new ArrayList<>();
    }

    public void addNode(char data){
        LinkedList<Node> currList = new LinkedList<>();
        Node newNode = new Node(data);
        currList.add(newNode);
        alist.add(currList);
    }

    public void addEdge(int src, int dst){
        LinkedList<Node> currList = alist.get(src);
        Node dstNode = alist.get(dst).get(0);
        currList.add(dstNode);
    }

    public void checkEdge(){

    }

}

class Node{
    char data;
    Node(char data){
        this.data = data;
    }
}

public class Graphs{
    public static void main(String args[]){
        Graph graph = new Graph();

        graph.addNode('a');
        graph.addNode('b');
        graph.addNode('c');
        graph.addNode('d');
        graph.addNode('e');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,0);
        graph.addEdge(4,2); 

    }
}