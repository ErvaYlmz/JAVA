package com.mycompany.hw5;


import java.io.*;
import java.nio.file.*;
import java.util.*;

class BinaryHeap{
    public int size;
    public double[] price= new double[100];
    ArrayList<String> name= new ArrayList<String>();
    
    public BinaryHeap(){
        size=0;
    }
    
    public void removeMin(){
        if(size==0){
            System.out.println("Error, no item added yet.");
            return;
        }
        else if(size==1){
            size--;
            name.remove(0);
            System.out.println(name.get(0)+" is removed since it has the min price");
        }
        else{
            System.out.println(name.get(0)+" is removed since it has the min price");
            name.remove(0);
            price[0]=price[size-1];
            size--;
            removeRecursive(0);
            
        }
    }               
    public void removeRecursive(int index){
        int i=index;
        int left=2*index+1;
        int right=2*index+2;
        
        if(left<size && price[left]<price[i]){
            i=left;
        }
        if(right<size && price[right]<price[i]){
            i=right;
        }
        if(i!=index){
            double temp=price[index];
            String temp2=name.get(index);
            
            name.set(index,name.get(i));
            price[index]=price[i];
            
            name.set(i, temp2);
            price[i]=temp;
            
            removeRecursive(i);
        }
    }
    
    public void Add(String pro, double p){
        int i=size;
        price[i]=p;
        name.add( pro);
        size++;
        
        System.out.println(pro+" with price "+p+" added.");
        
        while(i!=0 && (price[i]<price[(i-1)/2])){
            double temp= price[i];
            String temp2=name.get(i);
            
            name.set(i, name.get((i-1)/2));
            price[i]=price[(i-1)/2];
            
            name.set((i-1)/2, temp2);
            price[(i-1)/2]=temp;
            
            i=(i-1)/2;
        }
    }           
    
    public void ListMin(){
        if(size==0){
            System.out.println("Error, no item added yet.");
            return;
        }
        System.out.println(name.get(0)+" with price "+price[0]+" listed. (without removing)");
    }       
    
    public void DecreasePrice(String pro, double p){
        if(size==0){
            System.out.println("Error, no item added yet.");
            return;
        }
        int i=0;
        while(!name.get(i).equals(pro)){
            i++;
        }
        System.out.println(name.get(i)+"’s price is decreased by "+p+" (making it "+(price[i]-p)+")");
        price[i]=p;
        
        while(i!=0 && (price[i]<price[(i-1)/2])){
            double temp= price[i];
            String temp2=name.get(i);
            
            name.set(i, name.get((i-1)/2));
            price[i]=price[(i-1)/2];
            
            name.set((i-1)/2, temp2);
            price[(i-1)/2]=temp;
            
            i=(i-1)/2;
        }
    }          
}

public class Hw5 {

    public static void main(String[] args) throws IOException {
        File file= new File("process.txt");
        
        try(BufferedReader reader= new BufferedReader(new FileReader(file))){
            BinaryHeap heap= new BinaryHeap();
            String[] linesArray= new String[200];
            String line;
            int a=0;
            while((line=reader.readLine())!=null){
                linesArray[a]=line;
                a++;
            }
            for (int i=0; i<a; i++) {
                if(linesArray[i].contains("ListMin")){
                    heap.ListMin();
                }
                if(linesArray[i].contains("RemoveMin")){
                    heap.removeMin();
                }
                if(linesArray[i].contains("DecreasePrice")){
                    String[] temp=linesArray[i].split(" ");
                    
                    heap.DecreasePrice(temp[1], Double.parseDouble(temp[2]));
                }
                if(linesArray[i].contains("Add")){
                    String[] temp=linesArray[i].split(" ");
                    heap.Add(temp[1], Double.parseDouble(temp[2]));
                }
            }
            
        }catch(FileNotFoundException e){
            System.out.println("Cannot find the file!!");
            e.printStackTrace();
        }
    }
}
