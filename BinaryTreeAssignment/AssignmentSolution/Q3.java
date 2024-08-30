package Tree.Assignment;

import java.util.*;
class Assignment2<T>{
  
    public List<Integer> reverseLevelOrderTraversal(Q3.Node<T> root)
    {
          Queue<Q3.Node<T>> q = new LinkedList<>();
          List<Integer> result = new ArrayList<>();

          q.add(root);

          while(!q.isEmpty())
          {
                 Collections.reverseOrder();  
                 Q3.Node<T> x = q.remove();
                 
                 if(x.right != null)
                          q.add(x.right);
                 if(x.left != null)
                          q.add(x.left);
                 
                 result.add(x.data);          
                     
          }
           
           Collections.reverse(result);

           return result;
    } 

}
public class Q3 {
       
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
                               
                          int[] nodes = {1, 2, 4, -1, -1, -1, 3, 5, 7, -1, -1, 8, -1, -1, 6, -1, -1};
                          
                          BinaryTree<Integer> tree = new BinaryTree<>();
                          Node<Integer> root = tree.buildTree(nodes);
       
                          Assignment2<Integer> solution = new Assignment2<>();
                          System.out.println(solution.reverseLevelOrderTraversal(root));

                        

}

}