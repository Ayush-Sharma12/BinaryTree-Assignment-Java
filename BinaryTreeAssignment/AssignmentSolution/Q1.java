package Tree.Assignment;
/*
 *  processed level order Traversal in a zig zag way
 *  odd level Processed from left to right
 *  even level Processed from right to left
 */
import Tree.Tree1.*;
import Tree.Tree1.TreeNode;
import java.util.*;
class Assignment1<T>{

          public List<Integer> zigZagTraversal(Q1.Node<T> root)
          {
              List<Integer> result = new ArrayList<>();      
             Queue<TreeNode> q = new LinkedList<>();
              int countLevel = 1;
              while(!q.isEmpty())
              {
                    int Lsize = q.size(); 
                  
                     for(int i=0; i<Lsize; i++)
                    {
                              TreeNode x = q.poll();
                              if(x.left != null) {
                                      q.add(x.left);
                              }
                    }
                   
                     
                   
                  

                
                    
              }


                return result;
          }
}
public class Q1 {
           
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
          //       System.out.println(root.data);
                
             Assignment1<Integer> solution = new Assignment1<>();
             System.out.println(solution.zigZagTraversal(root));
             List<Integer> list = new ArrayList<>();
             
            Collections.reverse(list);
                

           }

            
}
