package javatekniskGenerics;

import java.util.Arrays;

public class GenericSort {

    public static void main(String[] args) {
        int my_value = 5;
        test(my_value);
        System.out.println("Verson 1: " + my_value);

        int [] my_value_2 = {5};

        test(my_value_2);
        System.out.println("Verson 2: " + Arrays.toString(my_value_2));
    }
    //Pass by value: ting kopieres inn i funksjonen.
    public static void test (int value){
        value = value+2;
    }
    //Pass by reference: vi sender en peker til det faktiske objektet.
    public static void test (int[] value){
        value[0] = value[0]+4;
    }
}
