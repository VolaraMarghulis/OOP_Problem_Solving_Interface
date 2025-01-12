package methodLesson;

public abstract class Person {
    private String name;
    private String address;
    private int age;

    public Person(String name, String address, int age){
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public Person() {
        this.name = "";
        this.address = "";
        this.age = 0;
    }
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