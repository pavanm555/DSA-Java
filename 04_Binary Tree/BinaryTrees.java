import java.util.*;

public class BinaryTrees{
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
    static int idx = -1;
    
    public static Node buildTree(int nodes[]){ 
        idx++;
        if(nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;

    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left); 
        postOrder(root.right);
        System.out.print(root.data + " ");
        
    }

    public static void levelOrder(Node root){
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countofNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countofNodes(root.left);
        int rightNodes = countofNodes(root.right);
        return leftNodes+rightNodes+1;
    }

    public static int sumofNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = sumofNodes(root.left);
        int rightsum = sumofNodes(root.right);
        return leftsum+rightsum+root.data;
    }

    public static int height(Node root){
        if(root == null) return 0;

        int leftheight = height(root.left);
        int rightheight = height(root.right);
        return Math.max(leftheight,rightheight) + 1;
    }

    public static int diameter(Node root){
        if(root == null) return 0;

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;
        
        return Math.max(diam3, Math.max(diam1,diam2));
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTrees BT = new BinaryTrees();
        Node root = buildTree(nodes);

       // preOrder(root);
       // inOrder(root);
       // postOrder(root);
        levelOrder(root);
        System.out.println(countofNodes(root));
        System.out.println(sumofNodes(root));
        System.out.println(height(root));
        System.out.println(diameter(root));
    }
}
