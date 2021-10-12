package stack;

import java.util.Stack;

public class FactorialTest {

    public static void main(String[] args) {
        System.out.println("Tester factorial");

        System.out.println("5! = " +factorial(5));

        System.out.println("5! = " + stackBasedFactorial(5));
    }


    /**
     * n! (n fakultet) = n * (n-1) * (n-2) * ... *
     */
     static int factorial (int n){
        //Basistilfellet - slutter rekusjon
        if(n==1){
            return 1;
        }

        //Forenkling - gå mot et basistilfelle

        //Kalle seg selv.
        return n* factorial(n-1);
    }

    public static int stackBasedFactorial(int n){
         // Vi trenger comparable-interfacet
         // derav integer og ikke int.
        Stack<Integer> factorial_stack = new Stack<>();

        factorial_stack.add(n);

        int result = 1;
        while (!factorial_stack.isEmpty()){
            Integer current = factorial_stack.pop();
            result = result * current;
            if(n>1) {
                factorial_stack.add(n - 1);
                n--;
            }

        }
        return result;
    }
}
