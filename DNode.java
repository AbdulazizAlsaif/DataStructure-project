/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulaziz
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eerxtem
 * @param <T>
 */
public class DNode<T> {
    
    DNode<T> next;
    DNode<T> prev;
    T data;
    
    public DNode(){
        
        this(null);
    }
    public DNode(T data){
        
        this(data,null);
    }
    public DNode(T data ,DNode<T> next){
        
        this(data,next,null);
        
    }
    public DNode(T data ,DNode<T> next,DNode<T> prev){
        
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
}
