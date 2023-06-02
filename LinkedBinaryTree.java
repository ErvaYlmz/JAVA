package com.mycompany.linkedbinarytree;

class Node{
    public char data;
    public Node left, right;
    public int depth;
    
    public Node(char data){
        this.data=data;
        left=right=null;
    }
}
class ExpressionTree{
    Node root;
    
    public ExpressionTree(){
        root=null;
    }
    
    public int evaluate(int xvalue){
        return evaluateRecursive(root,xvalue);
    }
    public int evaluateRecursive(Node root, int xvalue){
        int left, right, num=0, i;
        
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){   
            if(root.data=='X'){
                return xvalue;
            }
                return Integer.valueOf(root.data);
        }
        
        left=evaluateRecursive(root.left, xvalue);
        right=evaluateRecursive(root.right, xvalue);
        
        if(root.data=='+'){
            return left+right;
        }
        if(root.data=='-'){
            return left-right;
        }
        if(root.data=='*'){
            return left*right;
        }
        if(root.data=='/'){
            return left/right;
        }
        return 1;
    }
    
    public void displayTree(){
        displayInorder(root, -1);
    }                          //ok
    public void displayInorder(Node root, int num){ 
        if(root==null){
            return;
        }
        num++;
        displayInorder(root.left,num);
        for(int i=0; i<num; i++){
                System.out.print(". ");
            }
        System.out.println(root.data);
        displayInorder(root.right,num);
    }   //ok
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        
        return sb.toString();
    }
    
}

public class LinkedBinaryTree {

    public static void main(String[] args) {
        
    }
}
