package Tree.Assignment;

import java.util.*;
public class Q5 {
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

               public static  List<Integer> mirrorImage(Node<Integer> root)
               {
                       convert(root.left, root.right);
                       List<Integer> result = preorder(root);
                       return result;
               }

               public static void convert(Node<Integer> left, Node<Integer> right)
               {
                   if(left == null || right == null)
                            return;

                   swap(left, right);

                   
                   convert(left.left, right.right);
                   convert(left.right, right.left);
                      
                     
               }

               public static void swap(Node<Integer> a, Node<Integer> b)
               {
                    int temp = a.data;
                    a.data = b.data;
                    b.data = temp;
                     
               }
             
             
            static List<Integer> list = new ArrayList<>();
            public static List<Integer> preorder(Node<Integer> root)
               {
                      if(root == null)
                         return list;

                         

                     list.add(root.data);
                     preorder(root.left);
                     preorder(root.right);
                     
                     return list;
                     
               }


               public static void main(String[] args) {
                     
                    int[] nodes = {1, 2, 4, -1 , -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
                    
                    BinaryTree<Integer> tree = new BinaryTree<>();
                    Node<Integer> root = tree.buildTree(nodes);

                    System.out.println("Mirror Image preorder: " + mirrorImage(root)); 
                   Math.min(a, b)

                     
               }
}
