package Tree.Assignment;

import java.util.*;
class Assignment4<T>{

    public List<Integer> leftView(Q4.Node<T> root) // using Bfs
    {
         Queue<Q4.Node<T>> q = new LinkedList<>();
         q.add(root);

   
         List<Integer> sol = new ArrayList<>();
          if(root == null) return sol;
       
         int level = 0;
         while(!q.isEmpty())
         {
              
            int size = q.size();
              for(int i=0; i<size; i++)
              {
               Q4.Node<T> x = q.remove();
              
                if(x.left!= null)
                {
                    q.add(x.left);
                }
 
                if(x.right != null)
                {
                   q.add(x.right);
                }

                if(level == sol.size())
                     sol.add(x.data);
                
              }

              level++;
                

             
           
         }

       

       return sol;
           
    }

    public List<Integer> leftViewDfs(Q4.Node<T> root) // using dfs
    {
         List<Integer> result = new ArrayList<>();
        

         dfs(root, result, 0);

         return result;
    }

    public void dfs(Q4.Node<T> root, List<Integer> result, int level)
    {  
        if(root == null)
          return;

        if(level == result.size())
           result.add(root.data);  
                  
        dfs(root.left, result, level+1);
        dfs(root.right, result, level+1);
    }

}
public class Q4 {
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
                               
                          int[] nodes = {1, 2, -1, -1, 3, 5, 7, -1, -1, 8, -1, -1, 6, -1 ,-1};
                          
                          BinaryTree<Integer> tree = new BinaryTree<>();
                          Node<Integer> root = tree.buildTree(nodes);

                          Assignment4<Integer> solution = new Assignment4<>();
                         //  System.out.println("Left View: " + solution.leftView(root));
                          System.out.println("Left View: " + solution.leftViewDfs(root));
  }
}