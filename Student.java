/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdulaziz
 */


public class Student {
    
    private int studentid;// this is my unique key
    private String name;
    private String birthDate;
    private String mobile;
    private String address;
    private String specialty;
    private double GPA;
    public static DLL<Student> studentRecords = new DLL<Student>();
    private DNode<Student> d;//uesd for add and delete methods
    public static BST<Student> BSTStudent=new BST<>();
    public static Stack<Student> updatedRecords = new Stack<>();
    public static PriorityQueue<Student> GPAQueue=new PriorityQueue<>();
    public static HashTable<Student> studentHash =new HashTable(10);
        Student g;
     public Student(){//first constructer
         
         this(-1);
     }
     public Student(int studentid){
      
         this(studentid,null);
     }
      public Student(int studentid , String name){
      
         this(studentid,name,null);
     }
     public Student(int studentid , String name ,String birthDate){
      
          this(studentid,name,birthDate,null);
         
     }
      public Student(int studentid , String name ,String birthDate,String mobile){
      
          this(studentid,name,birthDate,mobile,null);
         
     }
         public Student(int studentid , String name ,String birthDate,String mobile,String address){
      
          this(studentid,name,birthDate,mobile,address,null);
         
     }
          public Student(int studentid , String name ,String birthDate,String mobile,String address,String specialty){
      
          this(studentid,name,birthDate,mobile,address,specialty,-1);
         
     }
          
    public Student(int studentid ,String name,String birthDate , String mobile,String address ,String specialty ,double GPA){//last Constructer
        
        this.studentid=studentid;
        this.name=name;
        this.birthDate=birthDate;
        this.mobile=mobile;
        this.address=address;
        this.specialty=specialty;
        this.GPA=GPA;
         d=new DNode<>(this,null,null);
        addToDLL();
        addToBST(studentRecords.last);
        studentHash.add(this.studentid, this);
        updatedRecords.push(this);
         
    }
     private Student(int studentid ,String name,String birthDate , String mobile,String address ,String specialty ,double GPA , String extra){//last Constructer
        
        this.studentid=studentid;
        this.name=name;
        this.birthDate=birthDate;
        this.mobile=mobile;
        this.address=address;
        this.specialty=specialty;
        this.GPA=GPA;
        
      //this constructer for stack use
        updatedRecords.push(this);
        
    }
    
    private void addToDLL()
    {
        
           studentRecords.add(this);
    }
    public void print(){
        
        if(this.name==null)
            return;
        System.out.println("StudentId :" + studentid + ", Name :" + name + ", BirthDate :" +
                           birthDate  + ", Mobile Number :" + mobile + ", Address :" + address + ", Specialty :"+ specialty + ", GPA :" + GPA);
        
  
    }
    
    public void print(int studentId){
        
       Student z= BSTStudent.Search(studentId);
        if(z!=null)
            z.print();
    }
    
    public void addToBST(DNode<Student> x){
        
        BSTStudent.add(x.data.studentid, x.data);
        
    }
    
    /*public static boolean makeItBST(){
        if(studentRecords.head==null)
        return false;
        
        DNode<Student> temp=studentRecords.head;
        while(temp!=null){
            BSTStudent.add(temp.data.studentid, temp.data);
        temp=temp.next;
        }
        return true;
    }*/

    //setters method
    

 
    public void setStudentId(int studId){
        
       updatedRecords.push(oldCopy());
       BSTStudent.changeKey(this.studentid, studId, this);  
        this.studentid=studId;
        updatedRecords.push(this);
        
        
    }
    
        
    public void setName(String name){
        
        updatedRecords.push(oldCopy());
        
        this.name=name;
        updatedRecords.push(this);
    }
    
    
    public void setBirthDate(String birthDate){
        updatedRecords.push(oldCopy());
        this.birthDate=birthDate;
        updatedRecords.push(this);
    }
    
    public void setMobile(String mobile){
       updatedRecords.push(oldCopy());
        this.mobile=mobile;
        updatedRecords.push(this);;
    }
    public void setAddress(String address)
    {
      updatedRecords.push(oldCopy());
       this.address=address;
       updatedRecords.push(this);
    }
    public void setSpecialty(String specialty){
     updatedRecords.push(oldCopy());
        this.specialty=specialty;
        updatedRecords.push(this);
    }
    public void setGPA(double GPA){
        updatedRecords.push(oldCopy());
        this.GPA=GPA;
        updatedRecords.push(this);
    }
    
    public Student oldCopy(){
    
    g=new Student(this.studentid,this.name,this.birthDate,this.mobile,this.address,this.specialty,this.GPA,null);
    return g;
}
    
    // getters methods
    public int getstudentid(){
        
        return this.studentid;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getBirthDate(){
        return this.birthDate;
    }
    
    public String getMobile(){
        return this.mobile;
    }
    public String getAddress()
    {
        return this.address;
    }
    public String getSpecialty(){
        return this.specialty;
    }
    public double getGPA(){
        return this.GPA;
    }
    public DNode<Student> getThisDNode(){
        
        return d;
    }
    
    public static Student removeStudentRecord(int studentId){
        Student x=BSTStudent.Search(studentId);
       DNode<Student> a= studentRecords.head;
       BSTStudent.remove(studentId);
       studentHash.remove(studentId);
       while (a!=null){
           if(a.data.studentid==studentId)
           {
             updatedRecords.push(a.data.oldCopy());
               studentRecords.remove(a);
              break;
           }
           
           a=a.next;
       }
        return x;
    }
    
   /* public static void printall(){
        
        if(studentRecords.head==null)
        return;
        else {
           DNode<Student> curr=studentRecords.head;
           if(GPAQueue.isEmpty()){
           while(curr!=null){
               GPAQueue.enqueue(curr.data.GPA, curr.data);
               curr=curr.next;
           }
           }
            
           while(!GPAQueue.isEmpty())
           GPAQueue.dequeue().print();
           
        }
        
    }*/
    
   public static Student search(int studentId){
        
       Student z= studentHash.get(studentId);
       return z;
    }
}
