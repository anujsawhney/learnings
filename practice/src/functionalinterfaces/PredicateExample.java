package functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        //predicate takes an input and returns boolean
        // has method named TEST
        // also has and(), or() and negate() methods

        Predicate<Integer> p1 = (i) -> i%2==0;
        Predicate<Integer> p2 = (i) -> i%5==0;
        // BiPreedicate takes two input and returns a boolean output

        System.out.println(p1.test(5));

        //Predicate and method usage
        System.out.println(p1.and(p2).test(10));//predicate chaining

        //Predicate OR method usage
        System.out.println(p1.or(p2).test(15));

        ///Predicate NEGATE method usage
        System.out.println(p1.and(p2).negate().test(10));

        //own Functional Interface
        TestFunctional tf = (s) -> System.out.println(s);
        tf.display("hello ji");
    }
}
