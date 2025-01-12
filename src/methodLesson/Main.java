package methodLesson;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> studentList = new ArrayList<>();
        System.out.print("Input the number of students: ");
        int numberOfStudents = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Input the name for " + (i + 1) + " student:");
            String name = sc.nextLine();
            System.out.print("Input the address for " + (i + 1) + " student:");
            String address = sc.nextLine();
            System.out.print("Input the age for " + (i + 1) + " student:");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("Input the grade for " + (i + 1) + " student:");
            double grade = Double.parseDouble(sc.nextLine());
            Student student = new Student(name, address, age, grade);
            studentList.add(student);
        }
        try (FileOutputStream fos = new FileOutputStream("student.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(studentList);
            System.out.println("Succes");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream("student.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Student> readStudentList = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        studentList.sort(new Student());
        studentList.forEach(System.out::println);
    }
}