/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulaziz
 */
public class PQNode<T> {
    
    PQNode<T> next;
    T data;
    double pKey;

    public PQNode(){
    this.next=null;
    this.data=null;
    this.pKey=-1;
}
    public PQNode(double GPA , T data){
    
    this.pKey=GPA;
    this.data=data;
}
}