package lambda;

import java.util.Comparator;


public class ComparatorLambdaExample {
    public static void main(String[] args) {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            //@Override
            public int compare(Integer o1, Integer o2){
                return o1.compareTo(o2);
            }
        };

        System.out.println("Result of the comparator is : "+c1.compare(5,6));

        Comparator<Integer> c2 = (Integer o1, Integer o2) -> o1.compareTo(o2);
        System.out.println("Result of the Lambda comparator is : "+c1.compare(5,6));

        //no need to mention the type as already defined while defining the comparator
        Comparator<Integer> c3 = (o1, o2) -> o1.compareTo(o2);
        System.out.println("Result of the Lambda comparator is : "+c1.compare(5,6));

    }
}
