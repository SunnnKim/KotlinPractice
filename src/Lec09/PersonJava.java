package Lec09;

public class PersonJava {
    String name;
    int age;


    public PersonJava(){

    }
    public PersonJava(String name, int age){
        this.age = age;
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
