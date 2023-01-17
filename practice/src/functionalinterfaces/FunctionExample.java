package functionalinterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {
    static Function<String,String> f1 = i -> i.toUpperCase();
    static Function<String,String> f2 = i -> i.concat("default");

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunc = (sl, p1) -> {
        Map<String, Double> hm = new HashMap<>();
        sl.forEach(s-> {
            if(p1.test(s)) {
                hm.put(s.getName(), s.getGpa());
            }
        });
        return hm;
    };
    public static void main(String[] args) {
        //Function takes one input and returns an output which can be of different type
        //and has abstract method named apply
        System.out.println(f1.apply("java8"));//JAVA8

        //also has a default andThen method which is executed after first function
        System.out.println(f1.andThen(f2).apply("java8"));//JAVA8default

        //also has a default compose method whose param function is executed before the first one
        System.out.println(f1.compose(f2).apply("java8"));//JAVA8DEFAULT

        //biFunction takes two parameters and returns one
        // can also take a Functional Interface as a param
        System.out.println(biFunc.apply(StudentDataBase.getAllStudents(), PredicateAndConsumerExample.p1));

    }
}
