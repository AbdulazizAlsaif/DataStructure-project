/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulaziz
 * @param <T>
 */
public class Stack<T> {
    
    private DNode<T> top;
    private int size;
    
    public Stack(){
        top=null;
        size=0;
    }
    
    public boolean isEmpty(){
        return top==null;
    }
    
    public void push(T data){
        
        DNode<T> curr=new DNode<>(data,null,null);
        if(isEmpty())
            top=curr;
           
        else{
            curr.next=top;
            top=curr;
            
        }
        size++;
        
    }
    
    public T pop(){
        
        if(isEmpty())
            return null;
        T data=top.data;
        top=top.next;
        size--;
        return data;
        
    }
    
    public T top(){
        if(isEmpty())
            return null;
        return top.data;
    }
    
    public int getSize(){
        return size;
    }
    
    public void printStack(){
        
        if(isEmpty())
            return;
        else{
            Stack<T> z=new Stack<>();
            if(top.data instanceof Student){
                Student x;
                while (!isEmpty()){
                    x=(Student)top.data;
                    x.print();
                    z.push(pop());
                }
            }
                else {
                        while(!isEmpty()){
                            System.out.println(top.data);
                            z.push(pop());
                        }
                        }
            while(!z.isEmpty()){
                push(z.pop());
            }
            }
        
      
        }
        
   
}
