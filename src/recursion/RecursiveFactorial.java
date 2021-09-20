package recursion;

public class RecursiveFactorial {

    public static void main(String[] args) {

        int five_factorial = factorial(5);
        System.out.println("5! = " + five_factorial);
        System.out.println("4! = " + factorial(4));
        System.out.println("8! = " + factorial(8));

    }

    static int factorial (int n){
        if(n==1){
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }


}

