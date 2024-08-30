package Tree.Assignment;

import java.util.ArrayDeque;
import java.util.Queue;


public class Q2 {
        
       public static boolean isComplete(Node root)
        {
        // return if the tree is empty
        if (root == null) {
            return true;
        }
 
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // to store the current node
        Node front;
 
        // flag to mark the end of full nodes
        boolean flag = false;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // dequeue front node
            front = queue.poll();
 
            // if we have encountered a non-full node before and the current node
            // is not a leaf, a tree cannot be complete
            if (flag && (front.left != null || front.right != null)) {
                return false;
            }
 
            // if the left child is empty and the right child exists,
            // a tree cannot be complete
            if (front.left == null && front.right != null) {
                return false;
            }
 
            // if the left child exists, enqueue it
            if (front.left != null) {
                queue.add(front.left);
            }
            // if the current node is a non-full node, set the flag to true
            else {
                flag = true;
            }
 
            // if the right child exists, enqueue it
            if (front.right != null) {
                queue.add(front.right);
            }
            // if the current node is a non-full node, set the flag to true
            else {
                flag = true;
            }
        }
 
        return true;
    }
          
    static class Node<T>{
          
          Node<T> right;
          Node<T> left; 
          int data;
          
          Node(int data)
          {
                    this.data = data;
                    this.left = this.right = null;
          }

    } 

     static class BinaryTree<T> // Binary Tree is a Tree which has atMax two childeren
     {
           int idx = -1;
           
           public Node<T> buildTree(int[] nodes)
           {
                    idx++;
                  if(nodes[idx] == -1)
                          return null;
          
                  Node<T> newNode = new Node<>(nodes[idx]);
                  newNode.left = buildTree(nodes);
                  newNode.right = buildTree(nodes);


                  return newNode;
                  
 
           }
        
     }
           public static void main(String[] args) {
                    
                 int nodes[] = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1};
                 BinaryTree<Integer> tree = new BinaryTree<>();
                 Node<Integer> root = tree.buildTree(nodes); 
                 
                 System.out.println(isComplete(root));
                 
           }
}
