package algdat21;

/**
 * [alt]+enter mens du holder over klassen for å lage test.
 */

public class MyFirstSort {
    public static void main(String[] args) {

        //System.out.println("Hello algdat");



        int values[] = {1, 2, 7, 4, 6, 9};

        System.out.println(findMax(values, 0, values.length));
        myFirstSort(values);
        findTwoMacIndexes(values, 0,values.length);

    }
    //Denne funksjonen tar inn et array med verdier (heltall),
    //og sorterer dem 'in place'
    // @param values.

    public static void myFirstSort(int[] values) {
        for (int k = 0; k < values.length - 1; k++) {

            //Sjekk at vi får fornuftig svar for *ett* tilfelle
            //Vi må utføre ordentlig testing før vi
            //Faktisk kan stole på kildekoden vår.

            int max_index = findMax(values, k, values.length);

            // System.out.println("Strøste verdi ligger på plass " + max_index + " og har verdi " + values[max_index]);

            //Bytte plass på tall på plass 0 og max_index
            int temp = values[k];
            values[k] = values[max_index];
            values[max_index] = temp;

            /* for (int i = 0; i < values.length; i++) {
               System.out.print(values[i] + ", ");
             }
            System.out.println();

        }
             */
        }
    }

    /**
     * FindMax finner index til største tall i et array,
     * men søker bare innefor tallene i [fra, til)
     */

    public static int findMax(int[] values, int fra, int til){
            //Initialiser ved å se på første kort
            //Dette er det største tallet jeg har funnet sålangt.
            int index=fra;
            int max_value = values[fra];

            for(int i=fra+1; i<til; i++){
                //SJekker om vi har funnet nytt største tall.
                if(values[i]>max_value){
                    max_value=values[i];
                    index = i;
                }
            }
            return index;
    }

    public static int findTwoMacIndexes(int[] values, int fra, int til){

        //Test at grensene gir mening
        if(til-fra<2){
            throw new ArrayIndexOutOfBoundsException("Feil i grenser");
        }
        if(fra<0){
            throw new ArrayIndexOutOfBoundsException("Fra er negativ");
        }
        if(til<2){
            throw new ArrayIndexOutOfBoundsException("Til er ikke lang nok");
        }
        if(til > values.length){
            throw new ArrayIndexOutOfBoundsException("Til er ikke lang nok");
        }
        //Indekser:             0, 1, 2, 3, 4, 5
        //Values.length =       6
        //Starter med verdiene {1, 7, 2, 5, 6, 9}

        // Initialiserer ved å se på første to verdier.
        //Dette er det største og neste største jeg har funnet så langt.
        int indexMax = fra; // 1
        int index_nestMax = fra+1; // 7

        int max_value = values[fra];
        int nest_max_value = values[fra+1];

        //Hvis nest_max har en verdi som er større enn max_value byttes de.
        if(max_value<nest_max_value){
            int temp = max_value;
            max_value=nest_max_value;
            nest_max_value= temp;

            temp=indexMax;
            indexMax=index_nestMax;
            index_nestMax=temp;
        }
        //Status:
        // Vi har sett på de to første elementene {1,7}
        // max_values = 7, index_max=1.
        //nest_max_values=1, nest_max_index=0

        //Looper gjennom resterende tall i array.
        for(int i=fra+2; i<til; i++){

            if(values[i]>nest_max_value){
                if(values[i]>max_value){
                    nest_max_value=max_value;
                    max_value=values[i];
                    index_nestMax=indexMax;
                    indexMax=i;
                } else{
                    nest_max_value=values[i];
                }
            }
        }
        return nest_max_value;

    }
}
