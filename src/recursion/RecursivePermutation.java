package recursion;

import java.util.Arrays;

public class RecursivePermutation {
    public static void main(String[] args) {
        System.out.println("Recursive permutations!");

        int values [] = {1,2,3};

        recursivePermutation(values, 0);

    }

    static void recursivePermutation(int [] values, int k){
        if (k == values.length){
            System.out.println(Arrays.toString(values));
        }

        //[1], 2, 3 => 1, 3, 2
        //2, 1, 3 => 2, 3, 1
        //3, 2, 1 => 3, 1, 2
        for (int i = k; i< values.length; i++){
            swap(values, i, k);
            recursivePermutation(values, k+1);
            //System.out.println(Arrays.toString(values));
            swap(values, k, i);

        }
        //recursivePermutation(values);


    }

    public static void swap (int [] values, int m, int n){
        //Eksempel: m=2, n=3;
        //temp = values[2];
        int temp = values[m];

        //values[2]=values[3];
        values[m] = values[n];
        //values[3] = temp = values[2];
        values[n]=temp;

    }
}
