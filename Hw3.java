package com.mycompany.hw3;


class Node {

    private int data;
    public Node next;

    public Node(int dd) {
        this.data = dd;
        //next=null;
    }

    public int getData(){
        return data;
    }
    
    public void setNext(Node n){
        next=n;
    }
}

////////////////////////////////////////////////////////////////
class MyStack {

    private Node first;
    private Node last;
    private int size;

    public MyStack() {
        first = null;
        last=first;
        size=0;
    }

    public void push(int dd) {
        Node temp= new Node(dd);    
        
        if(size==0){
            first=temp;
            last=temp;
        }
        else if(size==1){
            temp.next = first;
            last=temp;
        }
        else{
            temp.next = last ;
            last=temp;
        }
        size++;
    }
    
    public int peek() {
    	if(size==0){
            return last.getData();
        }
        
        return -1;
    }

    public int pop() {             
        int i=1,a;
        
    	if(size==0){
            return -1;
        }
        else if(size==1){
            a=first.getData();
            first=null;
            last=null;
        }
        
        else{
            a=last.getData();
            last=last.next;
        }
        
        size--;
        
        return a;
    }
    
    public String evaluate(String command) {
	StringBuilder sb=new StringBuilder("");  // You must return your results as a string. Do not change the parts which is already given.
        int a, i, j, temp1, temp2, result=0, intValue;
        
        
        String[] arr=command.split(" ");
        
        for(a=0; a<arr.length; a++){
            try{
                intValue=Integer.parseInt(arr[a]);
                push(intValue);
            }catch(NumberFormatException e){
           
                if("print".equals(arr[a])){
                    sb.append("[");
            
                    if(size==0){
                        sb.append("");
                    }
                    else{
                        if(size==1){
                            sb.append(first.getData());
                        }
                        else{
                            Node temp= last;
                            while(temp!=first){
                                sb.append(temp.getData()+ ", ");
                                temp=temp.next;
                            }
                            
                            sb.append(first.getData());
                        }
                    }
                    
                    sb.append("]\n");
                }
        
                else if("pop".equals(arr[a])){
                    sb.append(pop()+"\n");
                }
        
                else if("exit".equals(arr[a])){
                    sb.append("$\n");
                }
       
                else if("+".equals(arr[a]) || "-".equals(arr[a]) || "*".equals(arr[a]) || "/".equals(arr[a]) || "%".equals(arr[a])){
                    String k;
                    k=doMath(arr[a]);
                    sb.append(k);
                }
        
                else{
                    sb.append("Invalid operator\n");
                }
            }
        }
        
	return sb.toString();
	}

    public String doMath(String command){
        
        int temp1, temp2, result=0;
        
        if(size<2){
            return "Not enough integers in the stack\n";
        }
        else{
            if("+".equals(command)){
             
                temp2=pop();
                temp1=pop();
            
                result=temp1+temp2;
                push(result);
                
            }
            if("-".equals(command)){
            
                temp2=pop();
                temp1=pop();
            
                result=temp1-temp2;
                push(result);
             
            }
            if("*".equals(command)){
           
                temp2=pop();
                temp1=pop();
            
                result=temp1*temp2;
                push(result);
             
            }
            if("/".equals(command)){
            
                temp2=pop();
                temp1=pop();
            
                if(temp2==0){
                    return "Error!!";
                }
                else{
                    result=temp1/temp2;
                    push(result);
                }
            }
            if("%".equals(command)){
            
                temp2=pop();
                temp1=pop();
            
                result=temp1%temp2;
                push(result);
            }
        }
        return "";
    }
}

////////////////////////////////////////////////////////////////
public class Hw3 {

    public static void main(String[] args) {
      
MyStack myStack3 = new MyStack();

System.out.print(myStack3.evaluate("9 2 abc 1.0 3 print"));
System.out.print(myStack3.evaluate("+ print + print"));
System.out.print(myStack3.evaluate("+ - print"));
System.out.print(myStack3.evaluate("exit")); 
    }
}

////////////////////////////////////////////////////////////////
/* EXAMPLE INPUT OUTPUTS FOR TESTING (delete them before you submit)

TEST CASE 1

MyStack myStack = new MyStack();
System.out.print(myStack.evaluate("print"));
System.out.print(myStack.evaluate("50"));
System.out.print(myStack.evaluate("print"));
System.out.print(myStack.evaluate("20"));
System.out.print(myStack.evaluate("10"));
System.out.print(myStack.evaluate("print"));
System.out.print(myStack.evaluate("*"));
System.out.print(myStack.evaluate("print"));
System.out.print(myStack.evaluate("+"));
System.out.print(myStack.evaluate("print"));
System.out.print(myStack.evaluate("pop"));
System.out.print(myStack.evaluate("print"));
System.out.print(myStack.evaluate("10"));
System.out.print(myStack.evaluate("20"));
System.out.print(myStack.evaluate("print"));
System.out.print(myStack.evaluate("/"));
System.out.print(myStack.evaluate("#"));
System.out.print(myStack.evaluate("print"));
System.out.print(myStack.evaluate("push"));
System.out.print(myStack.evaluate("exit"));

Output:
[]
[50]
[10, 20, 50]
[200, 50]
[250]
250
[]
[20, 10]
Invalid input
[0]
Invalid input
$
 
TEST CASE 2
 
MyStack myStack2 = new MyStack();

System.out.print(myStack2.evaluate("print 5 print 10 30 print * print + print pop print exit"));
 
 
Output: 
[]
[5]
[30, 10, 5]
[300, 5]
[305]
305
[]
$

TEST CASE 3

MyStack myStack3 = new MyStack();

System.out.print(myStack3.evaluate("9 2 abc 1.0 3 print"));
System.out.print(myStack3.evaluate("+ print + print"));
System.out.print(myStack3.evaluate("+ - print"));
System.out.print(myStack3.evaluate("exit")); 
 
 
Output: 
Invalid input
Invalid input
[3, 2, 9]
[5, 9]
[14]
Not enough integers in the stack
Not enough integers in the stack
[14]
$


TEST CASE 4

MyStack myStack4 = new MyStack();

System.out.print(myStack4.evaluate("1 2 3 4 + + +"));
System.out.print(myStack4.evaluate("print"));
System.out.print(myStack4.evaluate("pop"));
System.out.print(myStack4.evaluate("print"));
System.out.print(myStack4.evaluate("5 4 * 8 2 / - 9 +"));
System.out.print(myStack4.evaluate("print"));
System.out.print(myStack4.evaluate("exit"));

Output: 
[10]
10
[]
[25]
$

TEST CASE 5
MyStack myStack5 = new MyStack();

System.out.print(myStack5.evaluate("100 39"));
System.out.print(myStack5.evaluate("print"));
System.out.print(myStack5.evaluate("% print"));
System.out.print(myStack5.evaluate("12 print"));
System.out.print(myStack5.evaluate("- print"));
System.out.print(myStack5.evaluate("5 / print"));
System.out.print(myStack5.evaluate("6 * print"));
System.out.print(myStack5.evaluate("exit"));
 
Output:
[39, 100]
[22]
[12, 22]
[10]
[2]
[12]
$ 



*/
