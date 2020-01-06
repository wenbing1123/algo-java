package _04_recursion;

public class Factorial {

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        var fa = new Factorial();
        System.out.println(fa.factorial(3));
    }
}
