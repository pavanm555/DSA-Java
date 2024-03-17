import java.util.*;

public class BinarySearchTree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node root = null;
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null) 
            return false;

        if(root.data == key){
            return true;
        }
        else if(root.data > key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }

        else{//root.data == val
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInrange(Node root, int x, int y){
        if(root == null) return;

        if(root.data >= x && root.data <= y){
            printInrange(root.left, x, y);
            System.out.print(root.data + " ");
            printInrange(root.right, x, y);
        }
        else if(root.data >= y){
            printInrange(root.left, x, y);
        }
        else{
            printInrange(root.right, x, y);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size();i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }
    public static void rootToleaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        if (root.right == null && root.left == null) {
            printPath(path);
        }
        else{
            rootToleaf(root.left, path);
            rootToleaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String args[]){
        int values[] = {8,5,3,1,4,6,10,11,14};

        for(int i : values){
            root = insert(root, i);
        }
        inorder(root);
        System.out.println();

        if(search(root, 0)){
             System.out.println("found");
        }
        else{
            System.out.println("Not found");
        }

       // delete(root, 8);
        inorder(root);
        System.out.println();
        System.out.println(root.data);

        System.out.println();
        printInrange(root, 5, 10);
        System.out.println();
        rootToleaf(root, new ArrayList<>());

    }
}