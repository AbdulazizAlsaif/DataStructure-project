/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulaziz
 */
public class HashTable<T> {
    
    DLL[] hash;
    private static int counter;
    private static double loadFactor;
    
    public HashTable(){
        this(10);
    }
    public HashTable(int arraySize){
        
        hash=new DLL[arraySize]; 
        counter=0;
        loadFactor=0;
        for (int i = 0; i < hash.length; i++) {
            hash[i]=new DLL<>();
        }
    }
   public T get(int key){
      
       if(hash[hashFunction(key)].head==null)
           return null;
      DNode<T> temp =hash[hashFunction(key)].head;
      if(temp.data instanceof Student){
          Student x;
       while (temp!=null){
           x=(Student)temp.data;  
           if(x.getstudentid()==key)
             return temp.data;
             temp=temp.next;
       }
      }
       return null;
     
       
       
   }
   
   public void add(int key,T data){
     if(hash[hashFunction(key)].head==null)
         counter++;
       hash[hashFunction(key)].add(data);
        
   }
   
   public T remove(int key){
       if(hash[hashFunction(key)].head==null)
           return null;
       DNode<T> temp =hash[hashFunction(key)].head;
       if(temp.data instanceof Student){ 
       Student x;
       
       while (temp!=null){
           x=(Student)temp.data;  
           if(x.getstudentid()==key){
           T data=temp.data;
               hash[hashFunction(key)].remove(temp);
            
              if(hash[hashFunction(key)].head==null)
                  counter--;
            return data;
           }
             temp=temp.next;
       }
       
       }
       else{
           while(temp!=null){
              T data=temp.data;
               hash[hashFunction(key)].remove(temp);
               return data;
           }
       }
       return null;
       
   }
   
   public int hashFunction(int key){
       
       return key%hash.length;
   }
   public void print(){
       
       for (int i = 0; i < hash.length; i++) {
           if(hash[i].head==null){
               System.out.print("index [" + i +"] ");
               System.out.println("null");
               continue;
           }
           DNode<T> curr=hash[i].head;
           Student x;
           while (curr!=null){
               System.out.print("index [" + i +"] ");
               if(curr.data instanceof Student){
                  x=(Student)curr.data;
               x.print();
               }
               else{
                   System.out.println(curr.data);
               }
               curr=curr.next;
           }
       }
       
       
   }
   public double getLoadFactor(){
    loadFactor=counter/counter;
    return loadFactor;
}
}
