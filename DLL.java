/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulaziz
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eerxtem
 * @param <T>
 */
public class DLL<T> {
    
    DNode<T> head ;
    DNode<T> last;
    public DLL(){
        last=head=null;
    }
    
    public boolean isEmpty(){
        
        return head==null;
    }
    
    public void add(T data){
        DNode l=new DNode(data,null,null);
        if (head==null){//DLL is empty;
            head=last=l;
        return;
        }
        else 
        l.prev=last;
        last.next=l;
        last=l;
        
    }
   /*   public void add(DNode<T> r){
        
        if (head==null){//DLL is empty;
            head=last=r;
        return;
        }
        else 
        r.prev=last;
        last.next=r;
        last=r;
        
    }
    */
   
    public DNode<T> remove(T data){
        
        if(head==null)
            return null;
        DNode<T>b,c, j =null;
        DNode<T> x=head;
        if(data==head.data){
            head=head.next;
            return x;
            }
       if(data==last.data){
           j=last;
           last.prev.next=null;
           return j;
       }
        while(x!=null){
            
            if(data==x.data){
                j=x;
                b=x.prev;
            c=x.next;
            b.next=c;
            c.prev=b;
            break;
        }
            x=x.next;
        }
        return j;
        } 
    
    public T remove(DNode<T> r){
        
        if(r==null)
            return null;
        T data =r.data;
        if(r==head){
            head=head.next;
            return data;}
        DNode<T> curr;
            if(r==last){
                r.prev.next=null;
                return data;
            }
            else{
                curr=r.prev;
                curr.next=r.next;
                curr.next.prev=curr;
                return data;
            }
    }
    public void print(){
        if(isEmpty()==true)
            return;
      if(this.head.data instanceof Student)
      {
          DNode<T> curr=head;
         while(curr!=null){
         printAll((Student) curr.data);//call method printAll for Student records
       curr=curr.next;
         }
      }
        else{
           DNode<T> curr =head;
            while(curr!=null){
                System.out.println(curr.data);
            curr=curr.next;
            }
        
                
                }
    }
    
    
    
    public T search(int key){
        
        if(head==null)
            return null;
        DNode<T> curr=head;
        Student temp;
       if(head.data instanceof Student){
           temp=(Student)curr.data;
       
        while(curr!=null){
           temp =(Student)curr.data;
            if(temp.getstudentid()==key){
                return curr.data;
            }
            curr=curr.next;
        }
        }
        return null;
       }
    
   
     private void printAll(Student s){
        
          System.out.println("StudentId :" + s.getstudentid() + ", Name :" + s.getName() + ", BirthDate :" +
                           s.getBirthDate()  + ", Mobile Number :" + s.getMobile() + ", Address :" + s.getAddress() + ", Specialty :"+ s.getAddress() + ", GPA :" + s.getGPA());
        
    }
     
     
    
}

