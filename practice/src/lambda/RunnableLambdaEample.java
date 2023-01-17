package lambda;

public class RunnableLambdaEample {
    public static void main(String[] args) {
        //prior to java 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("In run method");
            }
        };

        new Thread(runnable).start();

        //runnable using lambda
        Runnable r1 = () -> {
            System.out.println("Inside lambda Runnable");
        };
        Thread t = new Thread(r1);
        t.start();

        // Illegal thread state exception.
        //t.start();

        //if it's a single line we don't need curly braces to define lambda
        Runnable r2 = () -> System.out.println("Single line runnable");
        new Thread(() -> System.out.println("Inside Thread method")).start();
    }
}
