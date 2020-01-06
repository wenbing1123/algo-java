package _04_recursion;

public class Fibonacci {

    public int fibonacci(int n) {
        if (n < 3) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        var fi = new Fibonacci();
        System.out.println(fi.fibonacci(3));
    }

}
