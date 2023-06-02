package com.mycompany.hw4;

public class Hw4 {

    public static void main(String[] args) {
        ExpressionTree obj= new ExpressionTree("(X + (5 * 7))");
        System.out.print(obj.toString());
        
        obj.displayTree();
    }
}
