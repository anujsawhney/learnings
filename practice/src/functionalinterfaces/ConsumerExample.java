package functionalinterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    static List<Student> studentList = StudentDataBase.getAllStudents();
    static Consumer<Student> c1 = (s) -> System.out.println(s.getName());
    static Consumer<Student> c2 = (s) -> System.out.println(s.getActivities());
    public static void main(String[] args) {
        //As the name suggests consumer only accepts and returns void and thus has a
        // method named accept
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

        c1.accept("anuj sawhney");

        //printNameAndActivitesConditional();
        multiplyWithBiConsumer();
    }

    public static void printNameAndActivities() {
        Consumer<Student> c1 = (s) -> System.out.println(s.getName());
        Consumer<Student> c2 = (s) -> System.out.println(s.getActivities());
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c1.andThen(c2)); //consumer chaining
    }

    public static void printName() {
        Consumer<Student> c1 = (s) -> System.out.println(s);
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c1);
    }

    public static void printNameAndActivitesConditional() {
        studentList.forEach((student) -> {
            c1.andThen(c2).accept(student);
        });
    }

    public static void multiplyWithBiConsumer() {
        BiConsumer<Integer, Integer> bc = (a,b) -> {
            System.out.println("multiplication is: "+ (a*b));
        };
        bc.accept(3,4);
    }
}
