/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulaziz
 */
public class PriorityQueue<T> {
    
   private int size;
   PQNode<T> head;

public PriorityQueue(){
    
   head=null;
    size=0;
}

public int size(){
    return size;
}

public boolean isEmpty(){
    
    return head==null;
}
public T top(){
    if(head==null)
        return null;
    return head.data;
}
    
public void enqueue(double GPA,T data){
    
    PQNode<T> a=new PQNode<>(GPA,data);
    if(head==null || head.pKey<GPA){
    a.next=head;
    head=a;
    }
    else
    {
        PQNode<T> curr=head;
        PQNode<T> prev=null;
        while(curr!=null && (GPA<=curr.pKey)){
            prev=curr;
            curr=curr.next;
        }
        a.next=curr;
        prev.next=a;
 //   }
    }
        size++;
}

public T dequeue(){
    
    if(head==null)
        return null;
    
    T data=head.data;
    head=head.next;
    size--;
    return data;
}

public void printQ(){
    if(head==null)
        return;
    
    PQNode<T> curr=head;
    while(curr!=null){
        
        if(curr.data instanceof Student){
            Student x=(Student)curr.data;
            x.print();
        }
        else
            System.out.println(curr.data);
        curr=curr.next;
    }
}
}
