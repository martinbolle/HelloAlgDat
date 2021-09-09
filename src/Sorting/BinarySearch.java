package Sorting;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int [] values = {5, 6, 9, 2, 8, 3, 1, 10, 32, 4, 7, 14, 17, 18, 13};

        bubbleSort(values);

        //System.out.println(Arrays.toString(values));

        //System.out.println("Fant tallet 9 på plass "  + binarySearch(values, 9));

        int index2 = binarySearchRecursive(values, 6, 0, values.length-1);

        System.out.println(Arrays.toString(values));
        System.out.println(index2);

    }
    public static int binarySearch(int [] values, int target){
        // Søk etter 6
        // [L        R]
        //midt : l+right/2;
        //l=0 // left index 0.
        // r = 9 // right index 9
        // m = (l\r)/2 = (0+9)/2 = 4 // middle.
        //Tanke: (0.0+9.0) / 2 = 4.5 - double promotering.

        //Søk i intervallet l, r:
        int l = 0;
        int r = values.length-1;
        int m = (l+r)/2;

        while(l <= r) {
            System.out.println("SJekker intervallet [" + l + ", " + r+"]");

            m = (l+r)/2;

            //Hvis midt er større, Gå til venstre.
            if (values[m] > target) {
                l = l;
                r = m - 1;

            } else if (values[m] < target) {
                l = m + 1;
                r = r;

            } else if (values[m] == target) {
                return m;

            } else {
                System.out.println("Something wrong");
            }
        }

        return -1;
    }

    public static int binarySearchRecursive (int[] values, int serach_value, int l, int r){
        int m = (l+r)/2;

        if(l > r){
            return -1;
        }

        if(values[m] > serach_value){
            r = m-1;
            return binarySearchRecursive(values, serach_value, l, r);

        } else if(values[m] < serach_value){
            l = m+1;
            return binarySearchRecursive(values, serach_value, l, r);

        } else if(values[m]== serach_value){
            return m;
        } else {
            System.out.println("Something wrong! NaN etc.");
            return -m;
        }
    }


    public static void bubbleSort (int[] values){
        // To for-løkker:
        // Ytre løkke: Sorterer ett tall per gjennomgang.
        for(int i = 0; i<values.length-1; i++){
            //System.out.println("Array før sortering");
            //System.out.println(Arrays.toString(values));

            // Indre løkke: "Bobler" opp tall til riktig posisjon.
            for (int j=values.length-1; j>i; j--){
                //Sjekk om tall på posisjon j og (j-1) er sortert riktig.
                if(values[j]<values[j-1]){
                    //System.out.println("Inversjon! Bytter plass på " + j + " " + " og " + (j-1));
                    int temp = values[j];
                    values[j] = values[j-1];
                    values[j-1] = temp;
                }
                //System.out.println("Sorterte verdier: ");
                //System.out.println(Arrays.toString(values));
            }


        }
    }
}
