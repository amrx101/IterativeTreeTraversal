/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
import java.util.*;
public class IterativeTraversal {
    public static void main(String [] args){
        BinarySearchTree myTree = new BinarySearchTree();
        int [] arr = {8,2,0,1,4,5,3};
        for(Integer x: arr){
            myTree.insert(x);
        }
        myTree.inOrder();
        myTree.iterativeInorder();
        
        myTree.preOrder();
        myTree.iterativePreOrder();
        
        myTree.postOrder();
        myTree.iterativePostOrder();
        
    }
    
}
class BinarySearchTree{
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int data){
            this.data = data;
        }
    }
    
    private TreeNode root;
    public BinarySearchTree(){};
    
    public void insert(int data){
        root = insert(root,data);
    }
    private TreeNode insert(TreeNode root, int data){
        if(root == null){
            return new TreeNode(data);
        }
        else if(root.data > data){
            root.left = insert(root.left, data);
        }
        else if(root.data < data){
            root.right = insert(root.right,data);
        }
        else {}
        return root;
    }
    public void inOrder(){
        inOrder(root);
        System.out.println("");  
    }
    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
            
        }
    }
    public void iterativeInorder(){
        Stack <TreeNode> myStack = new Stack();
        iterativeInorder(root,myStack);
        System.out.println("");
    }
    private void iterativeInorder(TreeNode root, Stack<TreeNode> myStack){
        TreeNode node = root;
        if(node == null){
            System.out.println("Tree is empty ");
            return ;
        }
        myStack.push(node);
        while(!myStack.isEmpty()){
            while(node.left != null){
                node = node.left;
                myStack.push(node);
            }
            node = myStack.pop();
            System.out.print(node.data+" ");
            if(node.right != null){
                node = node.right;
                myStack.push(node);
            }
            else{
                node = myStack.pop();
                System.out.print(node.data+" ");
                if(node.right != null){
                    node = node.right;
                    myStack.push(node);
                }
                else{
                    while(node.right == null && !myStack.isEmpty()){
                        node = myStack.pop();
                        System.out.print(node.data +" ");
                        
                    }
                    if(node.right != null){
                        node = node.right;
                        myStack.push(node);
                    }
                }
            }
        }
        
    }
    public void preOrder(){
        preOrder(root);
        System.out.println("");
    }
    private void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.data +" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        
    }
    public void iterativePreOrder(){
        Stack<TreeNode > myStack = new Stack();
        iterativePreOrder(root,myStack);
        System.out.println("");
    }
    private void iterativePreOrder(TreeNode root, Stack<TreeNode> myStack){
        if(root == null){
            System.out.println("No nodes in tree");
            return ;
        }
        TreeNode node = root;
        myStack.push(node);
        while(!myStack.isEmpty()){
            node = myStack.pop();
            System.out.print(node.data+" ");
            if(node.right != null){
                myStack.push(node.right);
            }
            if(node.left != null){
                myStack.push(node.left);
            }
        }
    }
    public void postOrder(){
        postOrder(root);
        System.out.println("");
    }
    private void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data +" ");
            
        }
    }
    private boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }
    public void iterativePostOrder(){
        Stack <TreeNode> myStack = new Stack();
        iterativePostOrder(root,myStack);
        System.out.println("");
    }
    private void iterativePostOrder(TreeNode root, Stack<TreeNode> myStack){
        if(root == null){
            System.out.println("No nodes in the tree");
            return;
        }
        myStack.push(root);
        while(!myStack.isEmpty()){
            TreeNode node = myStack.peek();
            if((node.right == root||node.left == root)||(isLeaf(node))){
                System.out.print(node.data +" ");
                root = myStack.pop();
            }
            else{
                if(node.right != null){
                    myStack.push(node.right);
                }
                if(node.left != null){
                    myStack.push(node.left);
                }
            }
        }
        
    }
}
