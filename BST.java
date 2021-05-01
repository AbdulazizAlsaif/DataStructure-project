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
public class BST<T> {
    
    TNode<T> root;
   private TNode<T> curr;
    int size=0;
    
  
    public BST()
    {
        this.root=null;
        curr=null;
    }
    
    public boolean isEmpty(){
        return root==null;
    }
   //Search methods 
    public boolean findId(int key){
    
        
        if(root==null)
            return false;
       
        else
           return findId(key,root);
    
    }
  
   private boolean findId(int key , TNode<T> parent){
       
       
       if(parent == null)
           return false;
       TNode<T> temp=parent , extra=parent;
  
       
    
       while(temp!=null){
           extra=temp;
         
       if(temp.key==key){
           curr=temp;
           return true;}
       else
           if(key<temp.key)
            temp=temp.left;
              else
               if(key>temp.key)
                   temp=temp.right;
   }
       
             curr=extra;
            return false;
}
   
   public T Search(int key){
       
       if(findId(key))
           return curr.data;
      return null;
       }
       
  
  //add and remove methods
   public void add(int key ,T object){
       TNode<T> a=new TNode<>(object , key);
       TNode<T> b ,r;
       b=curr;
       r=root;
      
       if(isEmpty()){
       root=a;
       return;
       }
       if(findId(key)){ 
           curr=b;
           return ;   
       }
       if(key<curr.key){
           curr.left=a;
           a.parent=curr;
       }
          if(key>curr.key){
          curr.right=a;
          a.parent=curr;
          }
          size++;
   }
   
   public boolean remove(int key){
       
       if(root==null)
           return false;
       boolean b=false;
       TNode<T> x;
       x=remove(key,root,b);
       curr=root=x;
       return b;
   }
   
   private TNode<T> remove(int key,TNode<T> q,boolean b){
       TNode<T> j = null,x=null;
       
       if(q==null)
           return null;
       
       if(key<q.key)
           q.left=remove(key,q.left,b);
       else
           if(key>q.key)
       q.right=remove(key,q.right,b);
           else{
               b=true;
         if(q.right !=null && q.left!= null){//case 1
           j=findMin(q.right);
           q.data=j.data;
           q.key=j.key;
           q.right=remove(j.key,q.right,b);
           }
         else{    
             if(q.right==null)
            x=q.left;
             else 
                   if(q.left==null)
           x=q.right;
       return x;
       }
           }
       return q;
   }
   
   //find min and max method
   public TNode<T> findMax(TNode<T> r){
       if(r==null)
           return null;
       while(r.right!=null)
           r=r.right;
       return r;
   }
   
   public TNode<T> findMin(TNode<T> r){
       
       if(r==null)
       return null;
       while(r.left!=null)
           r=r.left;
       return r;
   }
   
   
   public void changeKey(int oldKey , int newKey , T data){
       
       remove(oldKey);
       add(newKey,data);
       
   }
   
   //print methods
   
     public void printInOrder(){
        if(root==null)
            return;
        else
            printInOrder(root);
        
    }
   private void printInOrder(TNode<T> a){
       
       if(a==null)
       return;
  
           
           if(a.data instanceof Student){
             Student x=(Student)a.data;
               x.print();
            printInOrder(a.left);
            printInOrder(a.right);
           }
           else{
               System.out.println(a.data);
               printInOrder(a.left);
               printInOrder(a.right);
           }
}
       public void printPO(){
        if(root==null)
            return;
        else
            printPO(root);
        
    }
     private void printPO(TNode<T> a){
        
         if(a==null)
             return;
         
         if(a.data instanceof Student){
           Student x=(Student)a.data;
             printPO(a.left);
             x.print();
            printPO(a.right);

           }
         else{
              printPO(a.left); 
             System.out.println(a.data); 
               printPO(a.right);
           }
         }
    
}