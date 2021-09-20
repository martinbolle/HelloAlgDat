package recursion;

public class Recursion {
    public static void main(String[] args) {

        int value = 15;
        int return_value = recursiceFunction(value);
        System.out.println("Main: " + return_value);

    }
    static int recursiceFunction(int value){
        System.out.println("Recursice function " + value);

        if (value<=5){
            return -9;
        } else {
            return recursiceFunction(value-1);
        }
    }
}
