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
public class TNode<T> {
    
    T data;
    TNode<T> parent;
    TNode<T> left;
    TNode<T> right;
    int key;
    
  
    public TNode(T data,  int key){
        
       this.data=data;
       this.key=key;
    }
   
}
