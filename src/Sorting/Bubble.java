package Sorting;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {

        int [] values = {4,3,2,1};

        // To for-løkker:
        // Ytre løkke: Sorterer ett tall per gjennomgang.
        for(int i = 0; i<values.length-1; i++){
            System.out.println("Skal finne plass " + i);
            System.out.println("Array før sortering starter" + Arrays.toString(values));

            // Indre løkke: "Bobler" opp tall til riktig posisjon.
            for (int j=values.length-1; j>i; j--){
                //Sjekk om tall på posisjon j og (j-1) er sortert riktig.
                if(values[j]<values[j-1]){
                    int temp = values[j];
                    values[j] = values[j-1];
                    values[j-1] = temp;
                    System.out.println("Bytter plass " + values[j] + " med " + values[j-1] + ": " + Arrays.toString(values));
                }
                System.out.println("Sorterte array: ");
                System.out.println(Arrays.toString(values));
            }

        }
    }
}
