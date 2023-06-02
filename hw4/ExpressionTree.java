package com.mycompany.hw4;

public class ExpressionTree extends LinkedBinaryTree<String>{
     LinkedBinaryTree tree;
     Node root=createNode(null,null,null,null);
     public String s;
     
    public ExpressionTree(String str){
        this.s=str;
        int []ar = new int[8888];
        ar['+']=ar['-']=1;
        ar['*']=2;
        ar[')']=0;
        
        java.util.Stack<Character> ch= new java.util.Stack<>();
        java.util.Stack<Node> node= new java.util.Stack<>();
        
        Node a= createNode(null,null,null,null);
        Node b= createNode(null,null,null,null);
        Node c= createNode(null,null,null,null);
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='('){
                ch.add(str.charAt(i));
            }
            else if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='s'||str.charAt(i)=='c'){
                switch (str.charAt(i)) {
                    case 's':
                        a.setElement("sin");
                        i+=3;
                        break;
                    case 'c':
                        a.setElement("cos");
                        i+=3;
                        break;
                    default:
                        a.setElement(str.charAt(i));
                        break;
                }
                    node.add(a);
            }
            else if(ar[str.charAt(i)]>0){
                while(!ch.isEmpty() && ch.peek()!='(' && ((ar[ch.peek()]>=ar[s.charAt(i)]) || (str.charAt(i)=='*' && ar[ch.peek()]>ar[s.charAt(i)]))){
                    a.setElement(ch.peek());
                    ch.pop();
                    b=node.peek();
                    node.pop();
                    c=node.peek();
                    node.pop();
                    a.setLeft(c);
                    a.setRight(b);
                    
                    node.add(a);
                }
                ch.push(str.charAt(i));
            }
            else if(str.charAt(i)==')'){
                while(!ch.isEmpty() && ch.peek()!='('){
                    a.setElement(ch.peek());
                    ch.pop();
                    b=node.peek();
                    node.pop();
                    c=node.peek();
                    node.pop();
                    
                    a.setLeft(c);
                    a.setRight(b);
                }
                ch.pop();
            }
        }
        a=node.peek();
        root=a;
    }
    
    public int evaluate(int xvalue){
        return evaluateRecursive(tree.root,xvalue);
    }
    public int evaluateRecursive(Node root, int xvalue){
        int left, right;
        
        if(root==null){
            return 0;
        }
        if(root.getLeft()==null && root.getRight()==null){   
            if(tree.root.getElement().equals("X")){
                return xvalue;
            }
                return Integer.parseInt((String) tree.root.getElement());
        }
        
        left=evaluateRecursive(tree.root.getLeft(), xvalue);
        right=evaluateRecursive(tree.root.getRight(), xvalue);
        
        if(tree.root.getElement().equals("+")){
            return left+right;
        }
        if(tree.root.getElement().equals("-")){
            return left-right;
        }
        if(tree.root.getElement().equals("*")){
            return left*right;
        }
        if(tree.root.getElement().equals("sin")){
            return (int)(Math.sin(left));
        }
        if(tree.root.getElement().equals("cos")){
            return (int)(Math.cos(left));
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
        displayInorder(root.getLeft(),num);
        for(int i=0; i<num; i++){
                System.out.print(". ");
            }
        System.out.println(root.getElement());
        displayInorder(root.getRight(),num);
    }   //ok
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        //sb.append("(");
        
        return s;
    }
    
}
