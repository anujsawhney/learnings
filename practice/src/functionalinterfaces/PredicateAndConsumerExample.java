package functionalinterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {
    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;
    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;
    static BiConsumer<String, List<String>> bc = (name,activites) -> System.out.println("name: "+name+" activities: "+activites);

    static Consumer<Student> studentConsumer = s -> {
        if(p1.and(p2).test(s)) {
            bc.accept(s.getName(), s.getActivities());
        }
    };
    public static void main(String[] args) {
      List<Student> studentList = StudentDataBase.getAllStudents();
      studentList.forEach(studentConsumer);
    }
}
