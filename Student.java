public class Student {
    int age ;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    void display(){
        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
    }

}
