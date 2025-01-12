package methodLesson;
import java.io.*;
import java.util.*;

public class Student extends Person implements Comparator<Student>, Serializable{
    private double grade;
    private static final long serialVersionUID = 1L;
    public Student(String name, String address, int age, double grade){
        super(name, address, age);
        this.grade = grade;
    }
    public double getGrade(){
        return grade;
    }
    public Student() {
        super();
        this.grade = 0.0;
    }
    public String toString(){
        return "[Name = " + getName() + ", address = "
                + getAddress() + ", age = " + getAge() + ", grade " + this.grade + "]";
    }
    public int compare(Student s1, Student s2){
        return Double.compare(s1.grade, s2.grade);
    }
}