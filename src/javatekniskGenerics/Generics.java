package javatekniskGenerics;

import java.util.Arrays;
import java.util.Comparator;

public class Generics {

    public static void main(String[] args) {

        //Integer => java-klasse som implements Comparable
        Integer [] values = {1,9,2,8,6,4,7,3};


        //HUSK!!! T må implementere comparable.
        //Class A implements Comparable {....}
        //class A public B {...}; class B implements Comparable{.....};
        //char?? int? double? => plain old datatypes,IKKE klasser!!
        //Integer, Double, Charater, String
        Character [] char_values = {'a','c','k','u','4','A'};

        int index_1 = max_value(values, 4, values.length);
        System.out.println("Støreste tall er " + values[index_1] + " og ligger på index " +index_1);

        System.out.println("Verdier før sortering: " + Arrays.toString(values));
        sort(values);
        System.out.println("Verdier før sortering: " + Arrays.toString(values));

        int index_2 = max_value(char_values, 0, char_values.length);
        System.out.println(index_2);
        System.out.println("Før sortering: " + Arrays.toString(char_values));
        sort(char_values);
        System.out.println("Etter sortering: " + Arrays.toString(char_values));

    }

    public static
    <T extends Comparable<?super T>>
    void sort (T [] values){
        //vi skal sortere n-1 tall siden siste tall alltid er sortert riktig.
        for (int i=0; i<values.length-1; i++){
            //Finn index til største tall i intervallet [i, n)
            int max_index = max_value(values, i, values.length);

            //Bytt tallet på plass max_index, med plass i
            T temp = values[i];
            values[i] = values[max_index];
            values[max_index] = temp;
        }
    }


    /**
     * Denne funksjonen finner indeksen til støreste heltall
     * innenfor intervallet [begin, end)
     */
    public //Denne funksjonen finnes for absolutt alle.
    static //Trenger ikke Generic gs = new GenericSort() for å bruke funksjonen.
    <T extends Comparable<? super T>>  //Denne funksjonen bruker T som generisk type - den må kunne sammenlignes!
    int //returnerer et heltall => indeksen der vi har størst verdi
    max_value(T[] values, int begin, int end){
        //Se på første verdi. Det er det største tallet vi har sett sålangt
        T current_max = values[begin];
        int current_max_index = begin;

        //Se gjennom alle verdier i [begin, end) og finn største av alle.
        for(int i = begin+1; i<end; i++){
            //ikke sikkert at T har operatoren <, >, ==, !=, ...., +, -, etc.
            //if(values[i]>current_max){ funker ikke med generics

            //Må derfor bruke funksjonen compareTo som
            // ligger i Comparable interfacet.
            //a.compareTo(b) >0 <=> (a>b)
            //a.compateTo(b) < 0 <=> (a<b)
            //a.compareTo(b) == 0 <=> (a==b)
            if(values[i].compareTo(current_max) > 0) {
                current_max = values[i];
                current_max_index = i;

            }
        }
        return current_max_index;
    }
}
