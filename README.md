## Problem

Define the `Person` class with the fields `name`, `address`, and `age`.

Define the `Student` class derived from the `Person` class, with an additional field `grade`.

Read the number of students in the group and their data from a file called `student.txt` into an array. 

Sort and display the students in ascending order of their average grade.


```Java
//Person is an abstract class, meaning it cannot be instantiated directly.
public abstract class Person {
    private String name;
    private String address;
    private int age;
    // Parameterized Constructor:
    public Person(String name, String address, int age){
        this.name = name;
        this.address = address;
        this.age = age;
    }
    //This constructor initializes a Person object with default values
    public Person() {
        this.name = "";
        this.address = "";
        this.age = 0;
    }
    //Getter Methods
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getAge(){
        return age;
    }
}
```
```Java
//The Student class inherits from the Person class
//The Student class implements the Comparator  and Serializable interface
public class Student extends Person implements Comparator<Student>, Serializable{
    private double grade;
    private static final long serialVersionUID = 1L;
    //Parameterized Constructor
    public Student(String name, String address, int age, double grade){
        super(name, address, age); //Calls the constructor of Person
        this.grade = grade;
    }
    public double getGrade(){
        return grade;
    }
    //Default Constructor
    public Student() {
        super(); //Calls the default constructor of Person
        this.grade = 0.0; //Sets grade to 0.0
    }
    //toString Method
    public String toString(){
        return "[Name = " + getName() + ", address = "
                + getAddress() + ", age = " + getAge() + ", grade " + this.grade + "]";
    }
    //comapre Method
    public int compare(Student s1, Student s2){
        return Double.compare(s1.grade, s2.grade);
    }
}
```
```Java
public class Main {

    public static void main(String[] args) {
        //Scanner object to read user input
        Scanner sc = new Scanner(System.in);
        //A dynamic list (ArrayList) to store Student objects.
        List<Student> studentList = new ArrayList<>();
        //Input the Number of Students:
        System.out.print("Input the number of students: ");
        int numberOfStudents = Integer.parseInt(sc.nextLine());
        //Loop to Input Student Details
        for (int i = 0; i < numberOfStudents; i++){
            System.out.print("Input the name for " + (i+1) + " student:");
            String name = sc.nextLine();
            System.out.print("Input the address for "+ (i+1) + " student:");
            String address = sc.nextLine();
            System.out.print("Input the age for " + (i+1) + " student:");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("Input the grade for " + (i+1) + " student:");
            double grade = Double.parseDouble(sc.nextLine());
            Student student = new Student(name, address, age, grade);
            studentList.add(student);
        }
        //Serialization
        
        try (FileOutputStream fos = new FileOutputStream("student.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(studentList);
            System.out.println("Succes");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //Deserialization
        try(FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            List<Student> readStudentList =(List<Student>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        //Sorting the Students
        studentList.sort(new Student());
        //Display the Sorted List
        studentList.forEach(System.out::println);
    }
}
```

