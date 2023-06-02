package com.mycompany.binarysearchtree;

class Node{
    private int element;
    public Node left, right;
    
    public Node(int element){
        this.element=element;
        left=right=null;
    }
    public int getElement(){
        return element;
    }
}
class Tree{
    public Node root;
    
    public Tree(){
        root=null;
    }
    public void push(int element){
        root=insert(root, element);
    }
    public Node insert(Node root, int element){
        if(root==null){
            root= new Node(element);
            return root;
        }
        if(element<root.getElement()){
            root.left=insert(root.left, element);
        }
        else{
            root.right=insert(root.right, element);
        }
        return root;
    }
    
    public void inorder(){
        print(root);
    }
    
    public void print(Node root){
        if(root!=null){
            print(root.left);
            System.out.print(root.getElement()+" ");
            print(root.right);
        }
    }
}
public class BinarySearchTree {

    public static void main(String[] args) {
       /* Tree tree= new Tree();
        tree.push(45);
        tree.push(10);
        tree.push(7);
        tree.push(12);
        tree.push(90);
        tree.push(50);
        tree.inorder();*/
       String data="480";
        int num=0;
        for(int i=0; i<data.length(); i++){
                num=num*10+((int)data.charAt(i)-48);
            }
        System.out.println(data.length());
        System.out.println(data +3);
        System.out.println( Integer.valueOf(data)+3);
        
    }
}
