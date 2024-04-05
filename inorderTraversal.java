import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
 
         List<Integer> list=new LinkedList<>();
         Stack <TreeNode> stack=new Stack<>();
 
         TreeNode currentRoot=root;
 
         while(true){
             while(currentRoot !=null){
                 stack.add(currentRoot);
                 currentRoot=currentRoot.left;
             }
             if(stack.isEmpty()==true) break;
             currentRoot =stack.pop();
             list.add(currentRoot.value);
             currentRoot=currentRoot.right;
         }
         return list;
     }
 }