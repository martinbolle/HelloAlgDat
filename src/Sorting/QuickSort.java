package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] a = {8,5,3,6,5,2,9};

        System.out.println("Usortert: " + Arrays.toString(a));
        quicksort(a, 0, a.length-1);
        System.out.println("Sortert: " + Arrays.toString(a));

    }

    /**
     * Rekursiv funksjon som implementerer quicksort og sorterer
     * verdier i intervallet [left, right]
     * @param values intervallet vi skal sortere
     * @param left start-indeks til arrayet
     * @param right slutt-indeks til arrayet.
     */

    public static void quicksort(int [] values, int left, int right){
        //Basistilfelle - Hvis vi ikke har noe intervall igjen (l==r)
        //så stopper rekursjonen.
        if(left >= right){
            return;
        }

        //1. Bytt midterste verdi i arrayet til slutten
        //  - se på veriden. Dette er skilleverdien (pivot)
        int m = (left+right)/2;         //Indeks til midterste verdi
        int pivot = values[m];           //Tar vare på midtverdien i en temp-variabel.
        values[m] = values[right];      //Overskriver midt-variabelen med siste verdi i arrayet.
        values[right] = pivot;           //overskriv siste verdi i arrayet med temp-variabelen (midten)
        System.out.println("Pivot er indeks " + m + " verdi " + pivot);
        System.out.println("Flytter pivot " + m + "-" + right);


        //2. Partisjoner arrayet fra start til nest siste kort (siste kort er midtkort).
        //  -Flytt alt som er større enn eller lik skilleverdi til høyre
        //  -Flytt alt som er mindre enn skilleverdi til venstre
        //  -Ta vare på indeksen til den siste verdien(som er mindre en skilleverdi)
        int index = partition(values, pivot, left, right-1);



        //3. Flytt skilleverdien(sist i arrayet) tilbake til riktig sortert plass.
        //  - (rett til høyre for siste verdi som er mindre enn skilleverdi)
        int sorted_index = index+1;
        int temp = values[sorted_index];
        values[sorted_index] = values[right];
        values[right] = temp;
        System.out.println("Flytter pivot tilbake til indeks " + sorted_index);
        System.out.println(Arrays.toString(values));

        //4. Gjenta for høyre sub-array og venstre sub-array.
        System.out.println("Rekursjon venstre sub-array");
        quicksort(values, left, sorted_index-1);
        System.out.println("Rekursjon høyre sub-array");
        quicksort(values, sorted_index+1, right);

        System.out.println("Ferdig quicksort i intervaller [" + left + ", " + right + "]");
    }

    /**
     * Partisjonerer arrayet basert på en skilleverdi(pivot)
     * Vi plasserer alle verdier som er mindre enn pivot til venstre,
     * oog alle verdier som er større eller lik til høyre. Vi returnerer
     * til slutt indkesen til siste tall som er mindre enn pivot.
     * @param values
     * @param left
     * @param right
     * @param pivot
     * @return
     */
    public static
    int partition(int values[], int pivot, int left, int right){
        int l = left;
        int r = right;

        //Kjør løkke helt til høyre og venste-peker møtes på midten.
        //Da har vi finner riktig plasssering av pivot
        while(l < r){
            //Flytt venstre-peker mot høyre så lenge vi har tall
            //som er riktig sortert i forhold til pivot.
            while(l <= r && values[l] < pivot){
                l = l+1;

            }
            //Gjør tilsvarende for høyre-peker: Flytt mot venstre
            //sålenge vi har tall som er større eller lik pivot.
            while (l <= r && values[r]>=pivot){
                r = r-1;
            }
            //Nå har vi at values[l]>= pivot og values[r] < pivot
            //Disse kan byttes.

            if(l < r){
                System.out.println("Bytter om " + l + "-" + r);
                int tmp = values[r];
                values[r] = values[l];
                values[l] = tmp;
                l = l+1;
                r = r+1;
            }
        }

        System.out.println("Siste tall mindre enn pivot er på indeks " + (l-1));
        return l-1;
    }
}
