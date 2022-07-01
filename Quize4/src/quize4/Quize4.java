
package quize4;


public class Quize4 {

    
    public static void main(String[] args) {
        Course myClass=new Course("AB34",34,"PO MOCHH");
        Student std1=new Student("m",1,2021);
        Student std3=new Student("n",2,2022);
        Student std2=new Student("o",3,2023);
        myClass.addStudent(std2);
        myClass.addStudent(std1);
        myClass.addStudent(std3);
        System.out.println(myClass);
    }
    
}
