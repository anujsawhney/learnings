package functionalinterfaces;

import java.util.function.Function;

public class FunctionExample {
    static Function<String,String> f1 = i -> i.toUpperCase();
    static Function<String,String> f2 = i -> i.concat("default");
    public static void main(String[] args) {
        //Function takes one input and returns an output which can be of different type
        //and has abstract method named apply
        System.out.println(f1.apply("java8"));//JAVA8

        //also has a default andThen method
        System.out.println(f1.andThen(f2).apply("java8"));//JAVA8default

        //also has a default compose method whose param function is executed before the first one
        System.out.println(f1.compose(f2).apply("java8"));//JAVA8DEFAULT

    }
}
